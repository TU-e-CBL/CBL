package CBL;

public class NPC extends LoadedObject implements Interactable {

    private TextPanel textPanel;
    private String[] dialogue;

    @Override
    public void interact() {
        textPanel.setParameters(boundsX, boundsY, boundsWidth, boundsHeight);
        textPanel.interaction(dialogue, textPanel);
        spoken = true;
    }

    public NPC(int x, int y, int width, int height, String imagePath, String filePath) {
        super(x, y, width, height, imagePath);
        dialogue = loadDialogue(filePath);
    }
}
