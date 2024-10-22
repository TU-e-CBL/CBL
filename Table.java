package CBL;

import java.awt.*;

public class Table {
    private int x, y;
    private int width;
    private int height;

    public Table(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width; 
        this.height = height;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height / 6);
        g.fillRect(x + width / 6, y + height / 6, width / 6, height * 5 / 6);
        g.fillRect(x + width * 5 / 6, y + height / 6, width / 6, height * 5 / 6);
    }

    public boolean collidesWith(int charX, int charY, int charWidth, int charHeight) {
        return (charX < x + width && charX + charWidth > x &&
                charY < y + height && charY + charHeight > y);
    }
}
