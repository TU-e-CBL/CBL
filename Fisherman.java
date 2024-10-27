package CBL;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Fisherman extends GameObject {
    
    public static boolean spoken = false;
    private TextPanel textPanel;
    private String[] dialogue;
    
    private int boundsWidth = 600;
    private int boundsHeight = 300;
    private int boundsX = x - (boundsWidth - width) / 2;
    private int boundsY = y - (boundsHeight + (width + height) / 4);

    public Fisherman(int x, int y, String filepath) {
        super(x, y, 100, 100);
        dialogue = loadDialogue(filepath);
        textPanel = Play.textPanel;
        textPanel.setParameters(boundsX, boundsY, boundsWidth, boundsHeight);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public void interact() {
        textPanel.interaction(dialogue, textPanel, "bruh.wav");
        spoken = true;
    }
}