import javax.microedition.media.*;

class Lib_sb_media
 {

  public static void tone(int note, int duration, int volume)
   {
    try 
     {
       Manager.playTone(note, duration, volume);
      } catch(MediaException me) { return; }
   }

  public static void vibration(int time)
   {
     FW.fw.display.vibrate(time);
   }
 }