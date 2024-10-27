package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Fisherman extends GameObject {

    private TextPanel textPanel = Play.textPanel;
    private String[] dialogue;

    private int boundsWidth = Play.wallThickness * 12;
    private int boundsHeight = boundsWidth / 2;
    private int boundsX = x - boundsWidth - width;
    private int boundsY = y - (boundsHeight - height) / 2;

    public Fisherman(int x, int y, int width, int height, Color color, String textPath) {
        super(x, y, width, height);
        this.color = color;
        dialogue = loadDialogue(textPath);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }    

    public void interact() {
        textPanel.setParameters(boundsX, boundsY, boundsWidth, boundsHeight);
        textPanel.interaction(dialogue, textPanel);
        spoken = true;
    }
}

