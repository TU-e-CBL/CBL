package CBL;

public class Movement {
    private int x, y; 
    private int speed; 
    private int width; 
    private int height; 

    public Movement(int startX, int startY, int speed, int width, int height) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWidth() {
        return width; 
    }

    public int getHeight() {
        return height; 
    }
    // for collision
}
