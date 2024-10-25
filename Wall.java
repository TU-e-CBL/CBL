package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends GameObject {

    private Color color;

    public Wall(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}