SPRAVOCHNIK ISKHODNIKOV BIBLIOTEK (iz libs.zip, raspolozhen 2026-11-18)
=========================================================================

CHTO ZDESS EST:

1. Lib_items/src/Lib_items_store.java  - STARAYA versiya (iz igry StarBattle)!
   NE ZAMENYAT nashev libs/Lib_items_store.java - nashev NOVEE:
   u nas est flagi predmetov (getitemflags, setitemdata s flags),
   kotorye ispolzuyutsya v items.cfg / items.mpsrc / console.mpsrc.
   Staraya versiya ih ne umeet - ot nee igra slomaetsya.

2. Lib_jsr75i/  - polnyi istochnik raboty s fajlovoi sistemoi (JSR-75).
   Polezno kak spravochnik. V igre uzhe ispolzuetsya nash
   libs/Lib_jsr75i.class (ravnocennyi).

3. Lib_memory/  - istochnik, identichen nashemu.

4. Lib_starbattle/ - iz drugoi igry toi zhe komandy:
   - Lib_sb_media: tone(noty), vibration(vibraciya) - mozhno podklyuchit k CaveCraft;
   - F/FS/FW/H/M/P/Real/RS/S/SM .java - POLNYI ISKHODNIK RUNTIME MidletPascal
     (spravochnik po vstroennym funkciyam). NE podmenyat nashi stuby -
     skompilirovannyi kod sobran pod stuby iz MP 3.5.

GLAVNOE OTKRYTIE:
V libs/ uzhe lezhit gotovyi zvukovoi dvizhok Lib_sounds.class
(loadsound / set_volume / playerstart / playerstop / playerstate),
v res/sound/ lezhat ROVNO 13 zvukov (block, chest, door, eat, explode,
chickenhurt, cowhurt, creeperhurt, pighurt, sheephurt, spiderhurt,
zombiehurt, zpighurt) = konstanta max_sounds=13 v vars.mpsrc.
No zvuk v kode igry NIKOGDA ne vyzyvaetsya, i zvuki ne dobavleny
v resursy CAVE.mpproj - avtor ne ushel podklyuchit zvuk.
Eto gotovyi kandidat na novyi kontent.
