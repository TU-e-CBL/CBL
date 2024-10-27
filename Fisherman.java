package CBL;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Fisherman extends GameObject implements Interactable {

    @Override
    public void interact() {
        textPanel.interaction(dialogue, textPanel);
        spoken = true;
    }
    
    public boolean spoken = false;
    private Color color;
    private TextPanel textPanel;
    private String[] dialogue;
    
    private int boundsWidth = Play.wallThickness * 12;
    private int boundsHeight = boundsWidth / 2;
    private int boundsX = x - boundsWidth - (width + height);
    private int boundsY = y - (boundsHeight - height) / 2;

    public Fisherman(int x, int y, int width, int height, Color color, String filepath) {
        super(x, y, width, height);
        this.color = color;
        dialogue = loadDialogue(filepath);
        textPanel = Play.textPanel;
        textPanel.setParameters(boundsX, boundsY, boundsWidth, boundsHeight);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }    
}