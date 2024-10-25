package CBL;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Rooms {

    private int screenWidth = Play.screenWidth;
    private int screenHeight = Play.screenHeight;
    private List<GameObject> objects;
    private Color white = Color.WHITE;
    private Color backgroundColor;

    public Rooms() {
        objects = new ArrayList<>();
    }

    public void outside_1() {
        objects.clear();
        backgroundColor = new Color(0, 100, 0);

        objects.add(new Wall(200, 200, 5, screenHeight - 400, Color.DARK_GRAY));

        for (int x = 200; x < screenWidth; x = x + 10) {
            objects.add(new Wall(x, 100, 5, 100, Color.DARK_GRAY));
            objects.add(new Wall(x, screenHeight - 200, 5, 100, Color.DARK_GRAY));
        }
        objects.add(new Door(screenWidth, 0, 0, screenHeight, 2));
    }

    public void outside_2() {
        objects.clear();
        backgroundColor = new Color(0, 100, 0);

        for (int x = 0; x < screenWidth - 200; x = x + 10) {
            objects.add(new Wall(x, 100, 5, 100, Color.DARK_GRAY));
            objects.add(new Wall(x, screenHeight - 200, 5, 100, Color.DARK_GRAY));
        }
        objects.add(new Wall(screenWidth - 100, 0, 100, screenHeight, white));
        objects.add(new Door(0, 0, 0, screenHeight, 1));
        objects.add(new Door(screenWidth - 110, screenHeight / 2 - 50, 10, 100, 3));
    }

    public void initRoom1() {
        objects.clear();
        backgroundColor = new Color(20, 20, 20);

        objects.add(new Wall(0, 0, screenWidth, 100, white));
        objects.add(new Wall(0, screenHeight - 100, screenWidth, 100, white));
        objects.add(new Wall(0, 0, 100, screenHeight, white)); 
        objects.add(new Wall(screenWidth - 100, 0, 100, screenHeight, white));
        objects.add(new Shoerack(400, 400, "shoe_rack_1.png"));

        Door door_2 = new Door(100, screenHeight / 2 - 25, 10, 50, 4);
        Door door_3 = new Door(screenWidth / 2 - 25, 100, 50, 10, 5);

        objects.add(door_2); 
        objects.add(door_3);
        objects.add(new Table(800, 800, 200, 100));
    }

    public void initRoom2() {
        objects.clear(); 
        backgroundColor = Color.BLACK;

        objects.add(new Wall(0, 0, screenWidth, 250, white)); 
        objects.add(new Wall(0, screenHeight - 50, screenWidth, 50, white));
        objects.add(new Wall(0, 0, 50, screenHeight, white)); 
        objects.add(new Wall(screenWidth - 50, 0, 50, screenHeight, white));
        objects.add(new Door(screenWidth-65, 500, 15, 60, 3)); 
    }

    public void initRoom3() {
        objects.clear();
        backgroundColor = Color.DARK_GRAY;

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