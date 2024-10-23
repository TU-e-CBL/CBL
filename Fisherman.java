package CBL;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Fisherman extends GameObject {

    private ArrayList<String> dialogue;

    public Fisherman(int x, int y) {
        super(x, y, 100, 100);
        dialogue = new ArrayList<>();
    }

    public void loadDialogue(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                dialogue.add(line);
            }
        } catch (IOException e) {
            System.err.println("No dialogue: " + e.getMessage());
        }
    }

    public ArrayList<String> getDialogue() {
        return dialogue;
    }

    public void interact() {}

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}
