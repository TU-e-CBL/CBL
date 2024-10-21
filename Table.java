package CBL;

import java.awt.*;

public class Table {
    private int x, y;
    private int width;
    private int height;
    private int targetRoomId;

    public Table(int x, int y, int width, int height, int targetRoomId) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.targetRoomId = targetRoomId;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    public boolean collidesWith(int charX, int charY, int charWidth, int charHeight) {
        return (charX < x + width && charX + charWidth > x &&
                charY < y + height && charY + charHeight > y);
    }
}
