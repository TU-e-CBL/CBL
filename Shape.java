package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Shape extends GameObject {

    private Color color;
    private String shape;

    public Shape(int x, int y, int width, int height, Color color, String shape) {
        super(x, y, width, height);
        this.color = color;
        this.shape = shape;
    }

    @Override
    public boolean collidesWith(int charX, int charY, int charWidth, int charHeight) {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if (shape.equalsIgnoreCase("roundrect")) {
            g.fillRoundRect(x, y, width, height, 50, 100);
        } else if (shape.equalsIgnoreCase("oval")) {
            g.fillRoundRect(x, y, width, height, 100, 100);
        } else {
            g.fillRect(x, y, width, height);
        }
    }

}
