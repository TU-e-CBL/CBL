package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends GameObject {

    public Wall(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void design(Graphics g) {
        g.fillRect(x, y, width, height);
    }
}