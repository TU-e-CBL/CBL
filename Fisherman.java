package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Fisherman extends GameObject {
    
    public static boolean spoken = false;
    private TextPanel textPanel;
    private String[] dialogue;

    private int boundsWidth = 600;
    private int boundsHeight = 300;
    private int boundsX = x - (boundsWidth - width) / 2;
    private int boundsY = y - (boundsHeight + (width + height) / 4);

    public Fisherman(int x, int y, String filepath) {
        super(x, y, 100, 100, Color.RED);
        dialogue = loadDialogue(filepath);
        textPanel = Play.textPanel;
        textPanel.setParameters(boundsX, boundsY, boundsWidth, boundsHeight);
    }

    @Override
    public void design(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    public void interact() {
        textPanel.interaction(dialogue, textPanel);
        spoken = true;
    }
}
