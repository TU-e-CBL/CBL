package CBLPROTOTYPE.src;

import java.awt.Color;
import java.awt.Graphics;

public class Character {
    private int x, y; 
    private Movement movement; 
    private final int width = 20; 
    private final int height = 20; 

    public Character(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.movement = new Movement(startX, startY, 4, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height); 
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

    public Movement getMovement() {
        return movement;
    }

    public int getWidth() {
        return width; 
    }

    public int getHeight() {
        return height; 
    }
    // for collision
}
