package CBL;

import java.awt.*;
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public abstract class GameObject {

    protected boolean spoken;
    protected int x, y;
    protected int width;
    protected int height;
    protected Color color;
    protected TextPanel textPanel = Play.textPanel;
    protected String[] dialogue;

    protected int boundsWidth = Play.wallThickness * 12;
    protected int boundsHeight = boundsWidth / 2;
    protected int boundsX = x - boundsWidth - (width + height);
    protected int boundsY = y - (boundsHeight - height) / 2;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width; 
        this.height = height;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
   
    public String[] loadDialogue(String filePath) {
        ArrayList<String> dialogueList = new ArrayList<>(); 
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                dialogueList.add(line); 
            }
        } catch (IOException e) {
            System.err.println("No dialogue: " + e.getMessage());
        }

        return dialogueList.toArray(new String[0]); 
    }

    public abstract void draw(Graphics g);

    public boolean collidesWith(int charX, int charY, int charWidth, int charHeight) {
        return (charX < x + width && charX + charWidth > x &&
                charY < y + height && charY + charHeight > y);
    }
}
