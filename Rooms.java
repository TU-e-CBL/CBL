package CBL;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Rooms {
    private List<Wall> walls;
    private List<Door> doors;

    public Rooms() {
        walls = new ArrayList<>();
        doors = new ArrayList<>();
    }

    public void initRoom1(int screenWidth, int screenHeight) {
        walls.clear();
        doors.clear(); 

        walls.add(new Wall(0, 0, screenWidth, 100));
        walls.add(new Wall(0, screenHeight - 100, screenWidth, 100));
        walls.add(new Wall(0, 0, 100, screenHeight)); 
        walls.add(new Wall(screenWidth - 100, 0, 100, screenHeight));

        Door door_2 = new Door(100, screenHeight / 2 - 25, 10, 50, 2);
        Door door_3 = new Door(screenWidth / 2 - 25, 100, 50, 10, 3);
        // door_targetRoomId
        doors.add(door_2); 
        doors.add(door_3);
    }

    public void initRoom2(int screenWidth, int screenHeight) {
        walls.clear(); 
        doors.clear();

        walls.add(new Wall(0, 0, screenWidth, 250)); 
        walls.add(new Wall(0, screenHeight - 50, screenWidth, 50));
        walls.add(new Wall(0, 0, 50, screenHeight)); 
        walls.add(new Wall(screenWidth - 50, 0, 50, screenHeight));

        doors.add(new Door(500, 500, 60, 15, 1)); 

    }
    public void initRoom3(int screenWidth, int screenHeight) {
        walls.clear();
        doors.clear();

        walls.add(new Wall(0, 0, screenWidth, 100)); 
        doors.add(new Door(200, 200, 50, 10, 1)); 
    }

    // Draws walls and doors for the current room
    public void drawObjects(Graphics g) {
        
        g.setColor(Color.WHITE); 
        for (Wall wall : walls) {
            wall.draw(g); 
        }
        for (Door door : doors) {
            door.draw(g); 
        }
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Door> getDoors() {
        return doors;
    }
}