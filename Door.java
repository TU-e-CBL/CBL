package CBL;

import java.awt.Graphics;

public class Door {
    private int x, y;
    private int width;
    private int height;
    private int targetRoomId;

    public Door(int x, int y, int width, int height, int targetRoomId) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.targetRoomId = targetRoomId;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    public boolean enteredDoor(int charX, int charY, int charWidth, int charHeight) {
        return (charX < x + width && charX + charWidth > x &&
                charY < y + height && charY + charHeight > y);
    }
    public int getTargetRoomId() {
        return targetRoomId;  // Return the room ID this door leads to
    }
}
