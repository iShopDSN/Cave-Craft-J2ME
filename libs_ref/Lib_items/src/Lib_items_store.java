class Lib_items_store
 {
  /*Items*/
  static byte[] item_type;
  static byte[] item_tex;
  static int[] item_max;
  static byte[] item_info;
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
  static byte[] tool_tool;
  static byte[] tool_lvl;
  static byte[] tool_speed;
  static byte[] tool_damg;

/*Items*/
  public static void reset_items(int len)
   {
    try {
     item_type = new byte[len];
     item_tex = new byte[len];
     item_max = new int[len];
     item_info = new byte[len];
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_item(int id, int type, int tex, int max, int info)
   {
    try {
     item_type[id] = (byte) type;
     item_tex[id] = (byte) tex;
     item_max[id] = max;
     item_info[id] = (byte) info;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_item_type(int id, int type)
   {
    try {
     item_type[id] = (byte) type;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_item_tex(int id, int tex)
   {
    try {
     item_tex[id] = (byte) tex;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_item_max(int id, int max)
   {
    try {
     item_max[id] = max;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_item_info(int id, int info)
   {
    try {
     item_info[id] = (byte) info;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static int get_item_type(int id)
   {
    try {
     return (int) item_type[id] & 0xFF;
    } catch(Exception e) { e.printStackTrace(); return -1;}
   }

  public static int get_item_tex(int id)
   {
    try {
     return (int) item_tex[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_item_max(int id)
   {
    try{
     return item_max[id];
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_item_info(int id)
   {
    try {
     return (int) item_info[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

/*Blocks*/

  public static void reset_blocks(int len)
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

  public static void set_block(int id, int tex, int hp, int coll, int tool, int lvl, int flags, int tr, int li)
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

  public static void set_block_tex(int id, int tex)
   {
    try {
     block_tex[id] = (byte) tex;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_block_hp(int id, int hp)
   {
    try {
     block_hp[id] = hp;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_block_coll(int id, int coll)
   {
    try {
     block_coll[id] = (byte) coll;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_block_tool(int id, int tool)
   {
    try {
     block_tool[id] = (byte) tool;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_block_lvl(int id, int lvl)
   {
    try {
     block_lvl[id] = (byte) lvl;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_block_flags(int id, int flags)
   {
    try {
     block_flags[id] = (byte) flags;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_block_tr(int id, int tr)
   {
    try {
     block_tr[id] = (byte) tr;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_block_li(int id, int li)
   {
    try {
     block_li[id] = (byte) li;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static int get_block_tex(int id)
   {
    try {
     return (int) block_tex[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_block_hp(int id)
   {
    try {
     return block_hp[id];
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_block_coll(int id)
   {
    try {
     return (int) block_coll[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_block_tool(int id)
   {
    try {
     return (int) block_tool[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_block_lvl(int id)
   {
    try {
     return (int) block_lvl[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  /*Block Flags*/
  public static int get_block_flags(int id)
   {
    try {
     return (int) block_flags[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_block_back(int id)
   {
    try {
     return (int) block_flags[id] & 0x1;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_block_fore(int id)
   {
    try {
     return (int) (block_flags[id] & 0x2)>>1;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_block_set(int id)
   {
    try {
     return (int) (block_flags[id] & 0x4)>>2;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }
  /*Block Flags END*/

  public static int get_block_tr(int id)
   {
    try {
     return (int) block_tr[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_block_li(int id)
   {
    try {
     return (int) block_li[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
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
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_craftin_sum(int id, int num, int sum)
   {
    try {
     craftIN_sum[num][id] = (byte) sum;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_craftout_item(int id, int item)
   {
    try {
     craftOUT_item[id] = (byte) item;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_craftout_sum(int id, int sum)
   {
    try {
     craftOUT_sum[id] = sum;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_craftout_flag(int id, int flag)
   {
    try {
     craftOUT_flag[id] = (byte) flag;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static int get_craftin_item(int id, int num)
   {
    try {
     return craftIN_item[num][id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_craftin_sum(int id, int num)
   {
    try {
     return craftIN_sum[num][id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_craftout_item(int id)
   {
    try {
     return craftOUT_item[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_craftout_sum(int id)
   {
    try {
     return craftOUT_sum[id];
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_craftout_flag(int id)
   {
    try {
     return craftOUT_flag[id] & 0xFF;
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

/*Tools*/
  public static void reset_tools(int len)
   {
    try {
     tool_tool = new byte[len];
     tool_lvl = new byte[len];
     tool_speed = new byte[len];
     tool_damg = new byte[len];
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_tool(int id, int tool, int lvl, int speed, int damg)
   {
    try {
     tool_tool[id] = (byte) tool;
     tool_lvl[id] = (byte) lvl;
     tool_speed[id] = (byte) speed;
     tool_damg[id] = (byte) damg;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_tool_tool(int id, int tool)
   {
    try {
     tool_tool[id] = (byte) tool;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_tool_lvl(int id, int lvl)
   {
    try {
     tool_lvl[id] = (byte) lvl;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_tool_speed(int id, int speed)
   {
    try {
     tool_speed[id] = (byte) speed;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static void set_tool_damg(int id, int damg)
   {
    try {
     tool_damg[id] = (byte) damg;
    } catch(Exception e) {e.printStackTrace();}
   }

  public static int get_tool_tool(int id)
   {
    try {
     return tool_tool[id];
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_tool_lvl(int id)
   {
    try {
     return tool_lvl[id];
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_tool_speed(int id)
   {
    try {
     return tool_speed[id];
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

  public static int get_tool_damg(int id)
   {
    try {
     return tool_damg[id];
    } catch(Exception e) {e.printStackTrace(); return -1;}
   }

 }