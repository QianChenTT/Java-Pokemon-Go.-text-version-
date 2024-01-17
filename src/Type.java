public class Type {
    public static final int NO_TYPE = 0;
    public static final int FIRE = 1;
    public static final int GRASS = 2;
    public static final int WATER = 3;
    public static final int NORMAL = 4;
    public static final String[] toString = {"NO_TYPE","FIRE","GRASS","WATER","NORMAL"};
    public static final double[][] effectiveness = {
        {1.0, 1.0, 1.0, 1.0, 1.0},
        {1.0, 1.0, 2.0, 0.5, 1.0},
        {1.0, 0.5, 1.0, 2.0, 1.0},
        {1.0, 2.0, 0.5, 1.0, 1.0},
        {1.0, 1.0, 1.0, 1.0, 1.0}
    };
}
