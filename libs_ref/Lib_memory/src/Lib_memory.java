import java.lang.*;

class Lib_memory
{
 public static void run_gc()
  {
   System.gc();
  }

 public static int get_totalmemory()
  {
   Runtime rt = Runtime.getRuntime();
   return (int) rt.totalMemory();
  }

 public static int get_freememory()
  {
   Runtime rt = Runtime.getRuntime();
   return (int) rt.freeMemory();
  }
}