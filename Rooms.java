package CBL;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Rooms {

    private int screenWidth = Play.screenWidth;
    private int screenHeight = Play.screenHeight;
    private List<GameObject> objects;
    private Color white = Color.WHITE.darker();
    private Color backgroundColor;

    public Rooms() {
        objects = new ArrayList<>();
    }

    public void outside_1() {
        objects.clear();
        backgroundColor = new Color(20, 60, 20);

        objects.add(new Wall(200, 200, 5, screenHeight - 400, Color.DARK_GRAY));

        for (int x = 200; x < screenWidth; x = x + 10) {
            objects.add(new Wall(x, 100, 5, 100, Color.DARK_GRAY));
            objects.add(new Wall(x, screenHeight - 200, 5, 100, Color.DARK_GRAY));
        }
        objects.add(new Door(screenWidth, 0, 0, screenHeight, 2));
    }

    public void outside_2() {
        objects.clear();
        backgroundColor = new Color(20, 60, 20);

        for (int x = 0; x < screenWidth - 200; x = x + 10) {
            objects.add(new Wall(x, 100, 5, 100, Color.DARK_GRAY));
            objects.add(new Wall(x, screenHeight - 200, 5, 100, Color.DARK_GRAY));
        }
        objects.add(new Wall(screenWidth - 50, 0, 50, screenHeight / 4, white));
        objects.add(new Wall(screenWidth - 50, screenHeight / 4 + 200, 50, screenHeight * 3 / 4 - 200, white));

        objects.add(new Door(0, 0, 0, screenHeight, 1));
        objects.add(new Door(screenWidth - 20, screenHeight / 4, 20, 200, 3));
    }

    public void entrance_1() {
        objects.clear();
        backgroundColor = new Color(20, 20, 20);

        objects.add(new Wall(0, 0, screenWidth, 50, white));
        objects.add(new Wall(0, screenHeight - 50, screenWidth, 50, white));
        objects.add(new Wall(0, 0, 50, screenHeight / 4, white));
        objects.add(new Wall(0, screenHeight / 4 + 200, 50, screenHeight * 3 / 4 - 200, white));

        objects.add(new Door(0, screenHeight / 4, 20, 200, 2)); 
        objects.add(new Door(screenWidth / 2 - 25, 100, 50, 10, 5));

        objects.add(new LoadedObject(400, 50, 150, 600,"shoe_rack_1.png"));
    }

    public void entrance_2() {
        objects.clear(); 

        objects.add(new Wall(0, 0, screenWidth, 250, white)); 
        objects.add(new Wall(0, screenHeight - 50, screenWidth, 50, white));
        objects.add(new Wall(0, 0, 50, screenHeight, white)); 
        objects.add(new Wall(screenWidth - 50, 0, 50, screenHeight, white));
        objects.add(new Door(screenWidth-65, 500, 15, 60, 3)); 
    }

    public void upstairs_1() {
        objects.clear();

        objects.add(new Wall(0, 0, screenWidth, 100, white)); 
        objects.add(new Door(200, 200, 50, 10, 3)); 

        Fisherman fisherman = new Fisherman(800, 800, "Hello_there.txt");
        objects.add(fisherman);
    }

    // Draws walls and doors for the current room
    public void drawObjects(Graphics g) {
        for (GameObject object : objects) {
            object.draw(g); 
        }
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public List<GameObject> getObjects() {
        return objects;
    }
}