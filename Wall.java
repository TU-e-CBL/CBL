package CBL;

import java.awt.Graphics;

public class Wall extends GameObject {
    public Wall(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }
}