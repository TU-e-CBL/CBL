package CBL;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Fisherman extends GameObject {

    private CustomTextPanel panel;
    private String[] dialogue;
    public static boolean spoken;

    public Fisherman(int x, int y) {
        super(x, y, 100, 100);
        dialogue = loadDialogue("Hello_there.txt");
        textPanel = new CustomTextPanel("");
    }

    private String[] loadDialogue(String filePath) {
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

    public String[] getDialogue() {
        return dialogue;
    }

    public void interact() {
        spoken = true;
        for (String line : dialogue) { 
            JOptionPane.showMessageDialog(null, line, null, JOptionPane.PLAIN_MESSAGE);
        }
        Play.upPressed = false;
        Play.downPressed = false;
        Play.leftPressed = false;
        Play.rightPressed = false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}
