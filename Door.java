package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Door extends GameObject {
    private int targetRoomId;

    public Door(int x, int y, int width, int height, int targetRoomId) {
        super(x, y, width, height);
        this.targetRoomId = targetRoomId;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x, y, width, height);
        g.setColor(Color.orange);
        int knobSize;
        if (width > height) {
            knobSize = width / 6;
            g.fillRect(x + width * 2 / 3, y + height, knobSize, knobSize);
        } else {
            knobSize = height / 6;
            g.fillRect(x + width, y + height / 3, knobSize, knobSize);
        }
    }

    public int getTargetRoomId() {
        return targetRoomId;  // Return the room ID this door leads to
    }
}