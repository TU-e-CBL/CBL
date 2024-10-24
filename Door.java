package CBL;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

public class Door extends GameObject {
    
    private int screenWidth = Play.screenWidth;
    private int screenHeight = Play.screenHeight;
    private int targetRoomId;

    public Door(int x, int y, int width, int height, int targetRoomId) {
        super(x, y, width, height);
        this.targetRoomId = targetRoomId;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.orange);
        if (width > height && y > screenHeight / 2) {
            g.fillRect(x + height, y - height / 2, height, height);
        } else if (width > height) {
            g.fillRect(x + width - height * 2, y + height / 2, height, height);
        } else if (x > screenWidth / 2) {
            g.fillRect(x - width / 2, y + height - width * 2, width, width);
        } else {
            g.fillRect(x + width / 2, y + width, width, width);
        }

        g.setColor(Color.gray);
        g.fillRect(x, y, width, height);
    }

    public int getTargetRoomId() {
        return targetRoomId;  // Return the room ID this door leads to
    }

}
