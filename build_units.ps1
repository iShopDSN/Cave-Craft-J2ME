# Сборка CaveCraft: юниты в порядке зависимостей -> главный файл
$mp      = 'C:\Program Files (x86)\MIDletPascal 3.5 FINAL\mp3CC.exe'
$mpLibs  = 'C:\Program Files (x86)\MIDletPascal 3.5 FINAL\Libs'
$src     = 'D:\rt\CAVE9\src'
$build   = 'D:\rt\CAVE9\build'
$lib     = Join-Path $build 'lib'
$out     = 'D:\rt\CAVE9\bin_test'

New-Item -ItemType Directory -Force -Path $lib  | Out-Null
New-Item -ItemType Directory -Force -Path $out  | Out-Null
# чистая папка библиотек: Lib_*.class из libs + сюда же лягут юниты
Remove-Item "$lib\*" -Force -Recurse -ErrorAction SilentlyContinue
Copy-Item 'D:\rt\CAVE9\libs\*' $lib -Force

# порядок зависимостей (топологический)
$units = @(
  'vars','randoms','utils','items','phy','func','inv','drop','particles',
  'keyboard','chest','player','video','furnace','craft','mobs','testspawn',
  'worldgen','console','cellui','invui','items_logic'
)

$failed = $null
foreach ($u in $units) {
  Write-Output "== $u =="
  $log = & $mp "-s$src\$u.mpsrc" "-o$lib" "-l$mpLibs" "-p$lib" -m1 2>&1
  $err = $log | Where-Object { $_ -match '\[Pascal Error\]|Fatal' }
  if ($err) {
    $err | ForEach-Object { Write-Output "  $_" }
    Write-Output "!! FAILED: $u"
    $failed = $u
    break
  }
}
if (-not $failed) {
  Write-Output '== MAIN: CAVE.mpsrc =='
  # главный файл компилируем В ПАПКУ ЮНИТОВ (-o = $lib): он грузит юниты только из выходной папки
  $log = & $mp "-s$src\CAVE.mpsrc" "-o$lib" "-l$mpLibs" "-p$lib" -m1 2>&1
  $log | Where-Object { $_ -match '\[Pascal Error\]|Fatal|^Compiling|^Preverif' } | ForEach-Object { Write-Output "  $_" }
  if ($LASTEXITCODE -ne 0 -and ($log | Where-Object { $_ -match '\[Pascal Error\]|Fatal' })) { Write-Output '!! MAIN FAILED' }
  else { Write-Output '== MAIN OK =='; Get-ChildItem $out | Select-Object Name, Length | Format-Table -AutoSize }
}
