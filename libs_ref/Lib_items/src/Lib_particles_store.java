class Lib_particles_store
 {
  static byte[] particle_type;
  static byte[] particle_ani;
  static short[] particle_x;
  static short[] particle_y;

  public static void reset_particles(int len)
   {
    particle_type = new byte[len];
    particle_ani = new byte[len];
    particle_x = new short[len];
    particle_y = new short[len];
   }

  public static void set_particle(int id, int type, int ani, int x, int y)
   {
    particle_type[id] = (byte) type;
    particle_ani[id] = (byte) ani;
    particle_x[id] = (short) x;
    particle_y[id] = (short) y;
   }

  public static void set_particle_type(int id, int type)
   {
    particle_type[id] = (byte) type;
   }

  public static void set_particle_ani(int id, int ani)
   {
    particle_ani[id] = (byte) ani;
   }

  public static void set_particle_x(int id, int x)
   {
    particle_x[id] = (short) x;
   }

  public static void set_particle_y(int id, int y)
   {
    particle_y[id] = (short) y;
   }

  public static int get_particle_type(int id)
   {
    return particle_type[id] & 0xFF;
   }

  public static int get_particle_ani(int id)
   {
    return particle_ani[id] & 0xFF;
   }

  public static int get_particle_x(int id)
   {
    return particle_x[id];
   }

  public static int get_particle_y(int id)
   {
    return particle_y[id];
   }
}