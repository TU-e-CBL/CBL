package CBL;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Rooms {

    private int screenWidth = Play.screenWidth;
    private int screenHeight = Play.screenHeight;
    private List<GameObject> objects;

    public Rooms() {
        objects = new ArrayList<>();
    }


    public void initRoom1() {
        objects.clear();

        objects.add(new Wall(0, 0, screenWidth, 100));
        objects.add(new Wall(0, screenHeight - 100, screenWidth, 100));
        objects.add(new Wall(0, 0, 100, screenHeight)); 
        objects.add(new Wall(screenWidth - 100, 0, 100, screenHeight));

        Door door_2 = new Door(100, screenHeight / 2 - 25, 10, 50, 2);
        Door door_3 = new Door(screenWidth / 2 - 25, 100, 50, 10, 3);
        // door_targetRoomId
        objects.add(door_2); 
        objects.add(door_3);
        objects.add(new Table(800, 800, 200, 100));
    }

    public void initRoom2() {
        objects.clear(); 

        objects.add(new Wall(0, 0, screenWidth, 250)); 
        objects.add(new Wall(0, screenHeight - 50, screenWidth, 50));
        objects.add(new Wall(0, 0, 50, screenHeight)); 
        objects.add(new Wall(screenWidth - 50, 0, 50, screenHeight));
        objects.add(new Door(screenWidth-65, 500, 15, 60, 1)); 
    }

    public void initRoom3() {
        objects.clear();

        objects.add(new Wall(0, 0, screenWidth, 100)); 
        objects.add(new Door(200, 200, 50, 10, 1)); 
        objects.add(new Fisherman(800, 800));
    }

    // Draws walls and doors for the current room
    public void drawObjects(Graphics g) {
        g.setColor(Color.WHITE); 
        for (GameObject object : objects) {
            object.draw(g); 
        }
    }

    public List<GameObject> getObjects() {
        return objects;
    }
}