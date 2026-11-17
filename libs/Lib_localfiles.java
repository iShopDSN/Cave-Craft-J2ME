import java.io.*;

class Lib_localfiles
{
 public static int readunsbyte(InputStream is)
  {
   try{
    DataInputStream dis = new DataInputStream(is);
    return (int) dis.readUnsignedByte();
   } catch(Exception e) {return -1;}
  }
}