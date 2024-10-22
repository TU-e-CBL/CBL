package CBL;

import java.awt.color;
import java.awt.Color;
import java.awt.Graphics;

public class Table extends GameObject {
    public Table(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x, y, width, height / 6);
        g.fillRect(x + width / 10, y + height / 6, width / 10, height * 5 / 6);
        g.fillRect(x + width * 8 / 10, y + height / 6, width / 10, height * 5 / 6);
    }
}
