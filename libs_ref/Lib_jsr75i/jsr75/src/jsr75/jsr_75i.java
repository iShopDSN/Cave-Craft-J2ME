/*
JSR-75 FILESYSTEM ACCESS LIBRARY
*/
import javax.microedition.io.file.*;
import javax.microedition.io.*;
import java.io.*;
import java.util.Enumeration;
import java.lang.*;


class Lib_jsr75i{
public static String get_dirs(String path) {
    StringBuffer s = new StringBuffer();
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+path);
        Enumeration r = fs.list();
        fs.close();
        while(r.hasMoreElements()) {
            String t = (String)r.nextElement();
            if(t.endsWith("/"))
               s.append(t).append('|');
            /*
            fs = (FileConnection)Connector.open("file:///"+path+t);
            if(fs.isDirectory())
                s.append(t).append('|');
            fs.close();
            */
        }
    }catch(Exception e) {return "";}
    return s.toString();
}
public static String get_files(String path) {
    StringBuffer s = new StringBuffer();
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+path);
        Enumeration r = fs.list();
        fs.close();
        while(r.hasMoreElements()) {
            String t = (String)r.nextElement();
            if(!t.endsWith("/"))
               s.append(t).append('|');
            /*
            fs = (FileConnection)Connector.open("file:///"+path+t);
            if(!fs.isDirectory())
                s.append(t).append('|');
            fs.close();
            */
        }
    }catch(Exception e) {return "";}
    return s.toString();
}

public static String get_files_with_path(String path) {
      StringBuffer s = new StringBuffer();
      try{
          FileConnection fs = (FileConnection)Connector.open("file://"+path);
          Enumeration r = fs.list();
          fs.close();
          while(r.hasMoreElements()) {
              String t = (String)r.nextElement();
              if(!t.endsWith("/"))
                s.append(path).append(t).append('|');
          }
      }catch(Exception e) {return "";}
      return s.toString();
  }

public static String get_dirs_with_path(String path) {
        StringBuffer s = new StringBuffer();
        try{
            FileConnection fs = (FileConnection)Connector.open("file://"+path);
            Enumeration r = fs.list();
            fs.close();
            while(r.hasMoreElements()) {
                String t = (String)r.nextElement();
                if(t.endsWith("/"))
                  s.append(path).append(t).append('|');
            }
        }catch(Exception e) {return "";}
        return s.toString();
    }


public static String read_file(String name) {
    StringBuffer s = new StringBuffer();
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        int sz = (int)fs.fileSize();
        byte[] d = new byte[sz];
        DataInputStream is = fs.openDataInputStream();
        is.read(d, 0, sz);
        for(int i=0;i<sz;i++){
            byte b= d[i];
            s.append((char)(b < 0 ? b == -88 ? 0x401 : b == -72 ? 0x451 : (0x400 | ((b & 0x7f) - 0x30)) : b));
        }
    }catch(Exception e) {return "";}
    return s.toString();
}

public static String read_file_a(String name) {
    StringBuffer s = new StringBuffer();
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        int sz = (int)fs.fileSize();
        byte[] d = new byte[sz];
        DataInputStream is = fs.openDataInputStream();
        is.read(d, 0, sz);
        for(int i=0;i<sz;i++){
            byte b= d[i];
            s.append((char)b);
        }
    }catch(Exception e) {return "";}
    return s.toString();
}

public static void write_file_a(String name, String info) {
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        if (!fs.exists())fs.create();
        DataOutputStream os = fs.openDataOutputStream();
        byte[] d = new byte[info.length()];
        for(int i=0;i<d.length;i++){
            char b =  info.charAt(i);
            d[i] = (byte)b;
        }
        os.write(d,0,d.length);
        os.flush();
        os.close();
    }catch(Exception e) {return;}
}

public static void write_file(String name, String info) {
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        if (!fs.exists())fs.create();
        DataOutputStream os = fs.openDataOutputStream();
        byte[] d = new byte[info.length()];
        for(int i=0;i<d.length;i++){
            char b =  info.charAt(i);
            if(b>255)
                d[i] = (byte)(b-848);
            else
                d[i] = (byte)b;
        }
        os.write(d,0,d.length);
        os.flush();
        os.close();
    }catch(Exception e) {return;}
}


public static void delete_file(String name) {
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        fs.delete();
        fs.close();
    }catch(Exception e) {return;}
}

public static int file_exists(String name) {
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        if(fs.exists()) return 1;
    }catch(Exception e) {return 0;}
    return 0;
}

public static String get_path(String name) {
  String result = "";
  try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        result=fs.getPath();
    }catch(Exception e) {result="";}
    return result;
}

  public static String get_name(String name) {
    String result = "";
    try{
          FileConnection fs = (FileConnection)Connector.open("file://"+name);
          result=fs.getName();
      }catch(Exception e) {result="";}
      return result;
  }

  public static String get_url(String name) {
  String result = "";
  try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        result=fs.getURL();
    }catch(Exception e) {result="";}
    return result;
}

public static void file_create(String name) {
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        fs.create();
    }catch(Exception e) {}
}

public static void file_rename(String name1, String name2) {
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name1);
        fs.rename(name2);
    }catch(Exception e) {}
}

public static int file_size(String name) {
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        int sz = (int)fs.fileSize();
        return sz;
    }catch(Exception e) {return -1;}
//    return -1;
}
/*
public static void file_set_attr(String name, int Hidden, int Writable, int Readable) {
        FileConnection fs = (FileConnection)Connector.open("file:///"+name);
        if (Hidden==1)
          fs.setHidden(true);
          else fs.setHidden(false);
        if (Writable==1)
          fs.setWritable(true);
          else fs.setWritable(false);
        if (Readable==1)
          fs.setReadable(true);
          else fs.setReadable(false);

}
*/

public static int file_canread(String name) {
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        if(fs.canRead()) return 1;
    }catch(Exception e) {return 0;}
    return 0;
}

public static int file_canwrite(String name) {
    try{
        FileConnection fs = (FileConnection)Connector.open("file://"+name);
        if(fs.canWrite()) return 1;
    }catch(Exception e) {return 0;}
    return 0;
}


public static int open_file(String name) {
    try{
        fc = (FileConnection) Connector.open("file://"+name);
    }catch(IOException ex) {return -1;}
    return 1;
}

public static int read_byte() throws IOException{
    if(dis==null)
        dis = fc.openDataInputStream();
    return dis.read();
}

public static int read_uns_byte() throws IOException{
    if(dis==null)
        dis = fc.openDataInputStream();
    return dis.readUnsignedByte();
}


public static String read_bytes(int off, int len) {
    StringBuffer s = new StringBuffer();
    try{
        byte[] d = new byte[len];
        if(dis==null)
            dis = fc.openDataInputStream();
        dis.read(d, off, len);
        for(int i=0;i<len;i++){
            byte b= d[i];
            s.append((char)b);
        }
    }catch(Exception e) {return "";}
    return s.toString();
}

public static void write_byte(int b) throws IOException{
    if(dos==null)
        dos = fc.openDataOutputStream();
    dos.writeByte(b);
}

public static void write_data(String info) throws IOException{
  if(dos==null)
    dos = fc.openDataOutputStream();
    byte[] d = new byte[info.length()];
    for(int i=0;i<d.length;i++)
    {
      char b =  info.charAt(i);
      d[i] = (byte)b;
    }
    info = "";
    dos.write(d,0,d.length);
  }



public static void flush() throws IOException{
    if(dos==null)
        dos = fc.openDataOutputStream();
    dos.flush();
}


public static void skip(int offset) throws IOException{
    if(dis==null)
    {
      dis = fc.openDataInputStream();
      dis.skip(offset);
    }
}

public static void reset() throws IOException{
    if(dis==null)
    {
      dis = fc.openDataInputStream();
      dis.reset();
    }
}


public static String read_string() throws IOException{
    if(dis==null)
        dis = fc.openDataInputStream();
    StringBuffer r = new StringBuffer();
    int ch = 0;
    while((ch=dis.read())!='\n'){
        r.append((char)ch);
    }
    return r.toString();
}

public static void write_string(String s) throws IOException{
    if(dos==null)
        dos = fc.openDataOutputStream();
	byte[] b = s.getBytes();
	dos.write(b, 0, b.length);
}

public static int close_file(String name) {
    try{
        if(dis!=null)  {
         dis.close();
         dis=null;
        }

        if(dos!=null) {
            dos.flush();
            dos.close();
            dos=null;
        }
        fc.close();
        fc=null;
    }catch(IOException ex) {return -1;}
    return 1;
}

public static String get_roots() {
    StringBuffer s = new StringBuffer();
    try{
        Enumeration r  = FileSystemRegistry.listRoots();
        while (r.hasMoreElements())
            s.append((String) r.nextElement()).append('|');
    }catch(Exception e) {return "";}
    return s.toString();
}

public static InputStream get_stream() throws IOException{
    if(dis==null)
    {
      dis = fc.openDataInputStream();
	}  
	return dis;
}

public static int create_folder(String name) {
    try{
      FileConnection fs = (FileConnection)Connector.open("file://"+name);
      fs.mkdir();
      return 1;
    }catch(Exception e) {return -1;}
}

public static int folder_size(String name) {
    try{
      FileConnection fs = (FileConnection)Connector.open("file://"+name);
      int sz= (int)fs.directorySize(true);
      return sz;
    }catch(Exception e) {return -1;}
}

private static FileConnection fc = null;
private static DataInputStream dis = null;
private static DataOutputStream dos = null;
}