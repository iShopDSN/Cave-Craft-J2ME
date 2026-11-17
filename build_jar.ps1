# Сборка финального jar: классы + стабы + ресурсы из CAVE.mpproj
Add-Type -AssemblyName System.IO.Compression.FileSystem

$build   = 'D:\rt\CAVE9\build'
$lib     = "$build\lib"
$staging = "$build\jar"
$mpStubs = 'C:\Program Files (x86)\MIDletPascal 3.5 FINAL\Stubs'
$oldJar  = 'D:\rt\CAVE9\bin\CAVE.jar'
$outJar  = 'D:\rt\CAVE9\bin\CAVE_test.jar'
$outJad  = 'D:\rt\CAVE9\bin\CAVE_test.jad'

if (Test-Path $staging) { Remove-Item "$staging\*" -Recurse -Force }
New-Item -ItemType Directory -Force -Path "$staging\META-INF" | Out-Null

# 1. Все скомпилированные классы (юниты + M + R_0/R_1 + Lib_*), БЕЗ .bsf
# кроме Lib_*, которых не было в старом jar (неиспользуемые)
$unusedLibs = 'Lib_beta','Lib_cnv2','Lib_localfiles','Lib_sounds','Lib_threads'
Get-ChildItem "$lib\*.class" | Where-Object { $unusedLibs -notcontains $_.BaseName } | ForEach-Object {
  Copy-Item $_.FullName $staging -Force
}

# 2. Стабы MIDletPascal (как в старом jar: F, FS, FW, RS, S)
foreach ($s in 'F','FS','FW','RS','S') {
  Copy-Item "$mpStubs\$s.class" $staging -Force
}

# 3. Ресурсы по списку из mpproj
[xml]$proj = Get-Content 'D:\rt\CAVE9\CAVE.mpproj'
$resCount = 0
foreach ($r in $proj.Project.Resources.resource) {
  $fn = $r.filename
  if (Test-Path "D:\rt\CAVE9\res\$fn") {
    $dest = Join-Path $staging $fn
    $destDir = Split-Path $dest -Parent
    if (-not (Test-Path $destDir)) { New-Item -ItemType Directory -Force -Path $destDir | Out-Null }
    Copy-Item "D:\rt\CAVE9\res\$fn" $dest -Force
    $resCount++
  } else {
    Write-Output "!! ресурс не найден: $fn"
  }
}
Write-Output "ресурсов скопировано: $resCount"

# 4. Манифест из старого jar + бамп версии
$oldZip = [System.IO.Compression.ZipFile]::OpenRead($oldJar)
$mfEntry = $oldZip.Entries | Where-Object { $_.FullName -eq 'META-INF/MANIFEST.MF' }
$reader = New-Object System.IO.StreamReader($mfEntry.Open(), [System.Text.Encoding]::GetEncoding(1251))
$manifest = $reader.ReadToEnd()
$reader.Close()
$oldZip.Dispose()
$manifest = $manifest -replace 'MIDlet-Version: 1\.9\.0', 'MIDlet-Version: 1.9.1'
if ($manifest -notmatch 'MIDlet-Version') { $manifest = "MIDlet-Version: 1.9.1`r`n" + $manifest }
# манифест обязан заканчиваться переводом строки
if (-not $manifest.EndsWith("`n")) { $manifest += "`r`n" }
[System.IO.File]::WriteAllText("$staging\META-INF\MANIFEST.MF", $manifest, [System.Text.Encoding]::GetEncoding(1251))

# 5. Zip -> jar (записи с ПРЯМЫМИ слэшами, как требует JAR/MIDP)
if (Test-Path $outJar) { Remove-Item $outJar -Force }
$fs = [System.IO.File]::Open($outJar, 'Create')
$zip = New-Object System.IO.Compression.ZipArchive($fs, [System.IO.Compression.ZipArchiveMode]::Create)
foreach ($f in (Get-ChildItem $staging -Recurse -File)) {
  $rel = $f.FullName.Substring($staging.Length + 1).Replace('\', '/')
  [void][System.IO.Compression.ZipFileExtensions]::CreateEntryFromFile($zip, $f.FullName, $rel, [System.IO.Compression.CompressionLevel]::Optimal)
}
$zip.Dispose()
$fs.Dispose()
$jarSize = (Get-Item $outJar).Length
Write-Output ("jar: {0} ({1} байт)" -f $outJar, $jarSize)

# 6. JAD по образцу старого
$jad = "MIDlet-Name: CaveCraft`r`nMIDlet-Vendor: DeaDSoftWare`r`nMIDlet-Version: 1.9.1`r`nMIDlet-Jar-URL: CAVE_test.jar`r`nMIDlet-Jar-Size: $jarSize`r`n"
[System.IO.File]::WriteAllText($outJad, $jad, [System.Text.Encoding]::ASCII)
Write-Output "jad: $outJad"

# 7. Обновить classes/ свежими .bsf + классами юнитов (для будущих сборок)
foreach ($f in (Get-ChildItem $lib -Filter *.bsf)) { Copy-Item $f.FullName 'D:\rt\CAVE9\classes' -Force }
foreach ($u in 'vars','items','func','phy','inv','drop','furnace','chest','player','randoms','keyboard','particles','video','mobs','craft','testspawn','worldgen','console','cellui','invui','items_logic') {
  Copy-Item "$lib\$u.class" 'D:\rt\CAVE9\classes' -Force
}
Copy-Item "$lib\R_0.class","$lib\R_1.class" 'D:\rt\CAVE9\classes' -Force
Write-Output 'classes/ updated'
