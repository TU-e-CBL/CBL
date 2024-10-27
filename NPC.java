package CBL;

public class NPC extends LoadedObject {

    private TextPanel textPanel = Play.textPanel;
    private String[] dialogue;

    private int boundsWidth = Play.wallThickness * 12;
    private int boundsHeight = boundsWidth / 2;
    private int boundsX = x - (boundsWidth - width) / 2;
    private int boundsY = y - boundsHeight;

    public NPC(int x, int y, int width, int height, String imagePath, String textPath) {
        super(x, y, width, height, imagePath);
        dialogue = loadDialogue(textPath);
    }

    public void interact() {
        textPanel.setParameters(boundsX, boundsY, boundsWidth, boundsHeight);
        textPanel.interaction(dialogue, textPanel);
        spoken = true;
    }
}
