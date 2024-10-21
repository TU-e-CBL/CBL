package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Character {
    private int x, y; 
    private int speed; 
    private int width = 80; 
    private int height = 90;

    public Character(int startX, int startY, int speed) {
        this.x = startX;
        this.y = startY;
        this.speed = speed;
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

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height - 40); 
        g.fillRect(x + 15, y + 50, 20, height - 50);
        g.fillRect(x + 35, y + 50, 10, height - 60);
        g.fillRect(x + 45, y + 50, 20, height - 50);

        g.setColor(Color.BLACK);
        g.fillRect(x + 10, y + 25, 25, 15);
        g.fillRect(x + 45, y + 25, 25, 15);
    }
}
