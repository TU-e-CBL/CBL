package CBL;

import java.awt.*;

public class Table {
    public Table(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height / 6);
        g.fillRect(x + width / 10, y + height / 6, width / 10, height * 5 / 6);
        g.fillRect(x + width * 8 / 10, y + height / 6, width / 10, height * 5 / 6);
    }
}
