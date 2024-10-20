package CBL;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Character {
    private int x, y; 
    private Movement movement; 
    private final int width = 80; 
    private final int height = 90; 
    private Image characterImage;
    String imagePath = "hi.png";


    public Character(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.movement = new Movement(startX, startY, 4, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height - 40); 
        g.fillRect(x + 15, y + 50, 20, height - 50);
        g.fillRect(x + 35, y + 50, 10, height - 60);
        g.fillRect(x + 45, y + 50, 20, height - 50);
        //g.drawImage(characterImage, x, y, width, height, null);
        g.setColor(Color.BLACK);
        g.fillRect(x + 10, y + 25, 25, 15);
        g.fillRect(x + 45, y + 25, 25, 15);
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
