package CBL;

public class NPC extends LoadedObject implements Interactable {

    public boolean spoken = false;
    private TextPanel textPanel;
    private String[] dialogue;

    private int boundsWidth = Play.wallThickness * 12;
    private int boundsHeight = boundsWidth / 2;
    private int boundsX = x - boundsWidth - (width + height);
    private int boundsY = y - (boundsHeight - height) / 2;

    NPC(int x, int y, int width, int height, String imagePath, String dialogue) {
        super(x, y, width, height, imagePath);

    }

    @Override
    public void interact() {
        textPanel.interaction(dialogue, textPanel);
        spoken = true;
    }
}
