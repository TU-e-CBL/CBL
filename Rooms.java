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

    // Method to initialize walls for Room 1
    public void initRoom1(int screenWidth, int screenHeight) {
        walls.clear(); // Clear any previous walls
        doors.clear(); // Clear any previous doors

        walls.add(new Wall(0, 0, screenWidth, 100)); // Top wall
        walls.add(new Wall(0, screenHeight - 100, screenWidth, 100)); // Bottom wall
        walls.add(new Wall(0, 0, 100, screenHeight)); // Left wall
        walls.add(new Wall(screenWidth - 100, 0, 100, screenHeight)); // Right wall

        // Initialize doors for Room 1
        doors.add(new Door(300, 100, 50, 10)); // Example door in Room 1
    }

    // Method to initialize walls for Room 2
    public void initRoom2(int screenWidth, int screenHeight) {
        walls.clear(); // Clear any previous walls
        doors.clear(); // Clear any previous doors

        // Room 2 layout - different walls
        walls.add(new Wall(0, 0, screenWidth, 50)); // Thinner top wall
        walls.add(new Wall(0, screenHeight - 50, screenWidth, 50)); // Thinner bottom wall
        walls.add(new Wall(0, 0, 50, screenHeight)); // Thinner left wall
        walls.add(new Wall(screenWidth - 50, 0, 50, screenHeight)); // Thinner right wall

        // Initialize doors for Room 2
        doors.add(new Door(screenWidth - 600, 50, 60, 15)); // Example door in Room 2
    }

    // Method to draw walls and doors for the current room
    public void drawObjects(Graphics g) {
        
        g.setColor(Color.WHITE); // Change wall color to white
        for (Wall wall : walls) {
            wall.draw(g); // Draw each wall
        }
        for (Door door : doors) {
            door.draw(g); // Draw each door
        }
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Door> getDoors() {
        return doors;
    }
}
