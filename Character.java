package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject{ 

    protected int speed = 10;

    public Character(int startX, int startY) {
        super(startX, startY, 80, 90);
    }

    @Override
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
