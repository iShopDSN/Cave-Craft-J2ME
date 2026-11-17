import java.util.Random;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class M extends Canvas
  implements Runnable
{
  public static Random RNG;
  public static Image I;
  public static M T;
  public static Graphics G;
  public static int KC;
  public static int KP;
  public static int[] IC;

  public void paint(Graphics paramGraphics)
  {
    paramGraphics.drawImage(I, 0, 0, 20);
  }

  public void run()
  {
    try
    {
      R();
    }
    catch (Exception localException)
    {
    }
  }

  public void keyPressed(int paramInt)
  {
    KP = M.KC = paramInt;
  }

  public void keyReleased(int paramInt)
  {
    KP = 0;
  }

  public static void R()
    throws Exception
  {
    RNG = new Random();
    IC = new int[25];
    KC = 0;
    KP = 0;
    FW.fw.destroyApp(true);
  }
}