package utils;

public class Line {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private int x0;
    private int y0;
    private int x1;
    private int y1;

    private boolean[] collisions;

    public Line(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;

        collisions = new boolean[4];
    }

    public void setCollision(int i, boolean collided) {
        collisions[i] = collided;
    }

    public boolean getCollision(int i) {
        return collisions[i];
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

}
