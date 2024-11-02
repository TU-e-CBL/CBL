package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Door extends GameObject {
    
    private int screenWidth = Play.screenWidth;
    private int screenHeight = Play.screenHeight;
    private int targetRoomId;

    private boolean bottom = false;
    private boolean top = false;
    private boolean right = false;

    public Door(int x, int y, int width, int height, int targetRoomId) {
        super(x, y, width, height);
        this.targetRoomId = targetRoomId;
        bottom = (this.width > this.height && this.y > screenHeight / 2);
        top = (this.width > this.height);
        right = (this.x > screenWidth / 2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(240,230, 140));
        if (bottom) {
            g.fillRect(x + height, y - height / 2, height, height);
        } else if (top) {
            g.fillRect(x + height, y + height / 2, height, height);
        } else if (right) {
            g.fillRect(x - width / 2, y + height - width * 2, width, width);
        } else {
            g.fillRect(x + width / 2, y + height - width * 2, width, width);
        }

        g.setColor(new Color(102,68,51));
        g.fillRect(x, y, width, height);
    }

    public int getTargetRoomId() {
        return targetRoomId;
    }
  
    public boolean bottom() {
        return bottom;
    }

    public boolean top() {
        return top;
    }

    public boolean right() {
        return right;
    }
}
