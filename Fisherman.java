package CBL;

import java.awt.Color;
import java.awt.Graphics;

public class Fisherman extends GameObject implements Interactable {

    @Override
    public void interact() {
        textPanel.setParameters(boundsX, boundsY, boundsWidth, boundsHeight);
        textPanel.interaction(dialogue, textPanel);
        spoken = true;
    }

    public Fisherman(int x, int y, int width, int height, Color color, String filepath) {
        super(x, y, width, height);
        this.color = color;
        dialogue = loadDialogue(filepath);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }    
}
