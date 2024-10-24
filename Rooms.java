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
    private Color gray = Color.GRAY;

    public Rooms() {
        objects = new ArrayList<>();
    }


    public void initRoom1() {
        objects.clear();

        objects.add(new Wall(0, 0, screenWidth, 100, white));
        objects.add(new Wall(0, screenHeight - 100, screenWidth, 100, white));
        objects.add(new Wall(0, 0, 100, screenHeight, white)); 
        objects.add(new Wall(screenWidth - 100, 0, 100, screenHeight, white));

        Door door_2 = new Door(100, screenHeight / 2 - 25, 10, 50, 2, gray);
        Door door_3 = new Door(screenWidth / 2 - 25, 100, 50, 10, 3, gray);
        // door_targetRoomId
        objects.add(door_2); 
        objects.add(door_3);
        objects.add(new Table(800, 800, 200, 100, gray));
    }

    public void initRoom2() {
        objects.clear(); 

        objects.add(new Wall(0, 0, screenWidth, 250, white)); 
        objects.add(new Wall(0, screenHeight - 50, screenWidth, 50, white));
        objects.add(new Wall(0, 0, 50, screenHeight, white)); 
        objects.add(new Wall(screenWidth - 50, 0, 50, screenHeight, white));
        objects.add(new Door(screenWidth-65, 500, 15, 60, 1, gray)); 
    }

    public void initRoom3() {
        objects.clear();

        objects.add(new Wall(0, 0, screenWidth, 100, white)); 
        objects.add(new Door(200, 200, 50, 10, 1, gray)); 

        Fisherman fisherman = new Fisherman(800, 800, "Hello_there.txt");
        objects.add(fisherman);
    }

    // Draws walls and doors for the current room
    public void drawObjects(Graphics g) {
        for (GameObject object : objects) {
            object.draw(g); 
        }
    }

    public List<GameObject> getObjects() {
        return objects;
    }
}