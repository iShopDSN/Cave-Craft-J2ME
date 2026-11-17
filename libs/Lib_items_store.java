class Lib_items_store
 {
  /*Items*/
  static byte[] item_type;
  static byte[] item_tex;
  static int[] item_max;
  static byte[] item_info;
  static byte[] item_flags;
  /*Blocks*/
  static byte[] block_tex;
  static int[] block_hp;
  static byte[] block_coll;
  static byte[] block_tool;
  static byte[] block_lvl;
  static byte[] block_flags;
  static byte[] block_tr;
  static byte[] block_li;
  /*Craft*/
  static byte[] [] craftIN_item;
  static byte[] [] craftIN_sum;
  static byte[] craftOUT_item;
  static int[] craftOUT_sum;
  static byte[] craftOUT_flag;
  /*Tools*/
  static byte[] tool_type;
  static byte[] tool_lvl;
  static byte[] tool_speed;
  static byte[] tool_damg;

/*Items*/
  public static void resetitems(int len)
   {
    try {
     item_type = new byte[len];
     item_tex = new byte[len];
     item_max = new int[len];
     item_info = new byte[len];
	 item_flags = new byte[len];
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void setitemdata(int id, int type, int tex, int max, int info, int flags)
   {
    try {
     item_type[id] = (byte) type;
     item_tex[id] = (byte) tex;
     item_max[id] = max;
     item_info[id] = (byte) info;
	 item_flags[id] = (byte) flags;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static int getitemtype(int id)
   {
    try {
     return (int) item_type[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getitemtex(int id)
   {
    try {
     return (int) item_tex[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getitemmax(int id)
   {
    try{
     return item_max[id];
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getiteminfo(int id)
   {
    try {
     return (int) item_info[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }
   
  public static int getitemflags(int id)
   {
    try {
     return (int) item_flags[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

/*Blocks*/

  public static void resetblocks(int len)
   {
    try {
     block_tex = new byte[len];
     block_hp = new int[len];
     block_coll = new byte[len];
     block_tool = new byte[len];
     block_lvl = new byte[len];
     block_flags = new byte[len];
     block_tr = new byte[len];
     block_li = new byte[len];
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void setblockdata(int id, int tex, int hp, int coll, int tool, int lvl, int flags, int tr, int li)
   {
    try {
     block_tex[id] = (byte) tex;
     block_hp[id] = hp;
     block_coll[id] = (byte) coll;
     block_tool[id] = (byte) tool;
     block_lvl[id] = (byte) lvl;
     block_flags[id] = (byte) flags;
     block_tr[id] = (byte) tr;
     block_li[id] = (byte) li;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static int getblocktex(int id)
   {
    try {
     return (int) block_tex[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getblockhp(int id)
   {
    try {
     return block_hp[id];
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getblockcoll(int id)
   {
    try {
     return (int) block_coll[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getblocktool(int id)
   {
    try {
     return (int) block_tool[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getblocklvl(int id)
   {
    try {
     return (int) block_lvl[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getblockflags(int id)
   {
    try {
     return (int) block_flags[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getblocktr(int id)
   {
    try {
     return (int) block_tr[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int getblockli(int id)
   {
    try {
     return (int) block_li[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

 /*Craft*/
  public static void reset_crafts(int len)
   {
    try {
     craftIN_item = new byte[4][len];
     craftIN_sum = new byte[4][len];
     craftOUT_item = new byte[len];
     craftOUT_sum = new int[len];
     craftOUT_flag = new byte[len];
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_craft(int id, int item0, int sum0, int item1, int sum1,  int item2, int sum2, int item3, int sum3, int outitem, int outsum, int flag)
   {
    try {
     craftIN_item[0][id] = (byte) item0;
     craftIN_sum[0][id] = (byte) sum0;
     craftIN_item[1][id] = (byte) item1;
     craftIN_sum[1][id] = (byte) sum1;
     craftIN_item[2][id] = (byte) item2;
     craftIN_sum[2][id] = (byte) sum2;
     craftIN_item[3][id] = (byte) item3;
     craftIN_sum[3][id] = (byte) sum3;
     craftOUT_item[id] = (byte) outitem;
     craftOUT_sum[id] = outsum;
     craftOUT_flag[id] = (byte) flag;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_craftin_item(int id, int num, int item)
   {
    try {
     craftIN_item[num][id] = (byte) item;
    } catch(Exception e) {/*e.printStackTrace();*/}
   }

  public static void set_craftin_sum(int id, int num, int sum)
   {
    try {
     craftIN_sum[num][id] = (byte) sum;
    } catch(Exception e) {/*e.printStackTrace();*/}
   }

  public static void set_craftout_item(int id, int item)
   {
    try {
     craftOUT_item[id] = (byte) item;
    } catch(Exception e) {/*e.printStackTrace();*/}
   }

  public static void set_craftout_sum(int id, int sum)
   {
    try {
     craftOUT_sum[id] = sum;
    } catch(Exception e) {/*e.printStackTrace();*/}
   }

  public static void set_craftout_flag(int id, int flag)
   {
    try {
     craftOUT_flag[id] = (byte) flag;
    } catch(Exception e) {/*e.printStackTrace();*/}
   }

  public static int get_craftin_item(int id, int num)
   {
    try {
     return craftIN_item[num][id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int get_craftin_sum(int id, int num)
   {
    try {
     return craftIN_sum[num][id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int get_craftout_item(int id)
   {
    try {
     return craftOUT_item[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int get_craftout_sum(int id)
   {
    try {
     return craftOUT_sum[id];
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int get_craftout_flag(int id)
   {
    try {
     return craftOUT_flag[id] & 0xFF;
    } catch(Exception e) {/*e.printStackTrace();*/ return 0xFF;}
   }

/*Tools*/
  public static void resettools(int len)
   {
    try {
     tool_type = new byte[len];
     tool_lvl = new byte[len];
     tool_speed = new byte[len];
     tool_damg = new byte[len];
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void settooldata(int id, int tool, int lvl, int speed, int damg)
   {
    try {
     tool_type[id] = (byte) tool;
     tool_lvl[id] = (byte) lvl;
     tool_speed[id] = (byte) speed;
     tool_damg[id] = (byte) damg;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static int gettooltype(int id)
   {
    try {
     return tool_type[item_info[id]];
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int gettoollvl(int id)
   {
    try {
     return tool_lvl[item_info[id]];
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int gettoolspeed(int id)
   {
    try {
     return tool_speed[item_info[id]];
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

  public static int gettooldamg(int id)
   {
    try {
     return tool_damg[item_info[id]];
    } catch(Exception e) {/*e.printStackTrace();*/ return 0;}
   }

 }