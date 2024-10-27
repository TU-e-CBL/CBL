package CBL;

import java.awt.*;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;

public abstract class GameObject {

    protected boolean spoken;
    protected int x, y;
    protected int width;
    protected int height;
    protected Color color;

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
   
    public String[] loadDialogue(String textPath) {
        ArrayList<String> dialogueList = new ArrayList<>(); 
        try (BufferedReader br = new BufferedReader(new FileReader(textPath))) {
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
