package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject{ 

    protected int wallThickness = Play.screenWidth / 50;
    protected int speed = wallThickness / 2;

    public Character(int startX, int startY) {
        super(startX, startY, Play.screenWidth * 12 / 250, Play.screenWidth * 27 / 500);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height - wallThickness * 6 / 5); 
        g.fillRect(x + wallThickness * 9 / 20, y + wallThickness * 3 / 2, wallThickness * 3 / 5, height - wallThickness * 3 / 2);
        g.fillRect(x + wallThickness, y + wallThickness * 3 / 2, wallThickness * 2 / 5, height - wallThickness * 9 / 5);
        g.fillRect(x + wallThickness * 27 / 20, y + wallThickness * 3 / 2, wallThickness * 3 / 5, height - wallThickness * 3 / 2);

        g.setColor(Color.BLACK);
        g.fillRect(x + wallThickness * 3 / 10, y + wallThickness * 3 / 4, wallThickness * 3 / 4, wallThickness * 9 / 20);
        g.fillRect(x + wallThickness * 27 / 20, y + wallThickness * 3 / 4, wallThickness * 3 / 4, wallThickness * 9 / 20);
    }
}
