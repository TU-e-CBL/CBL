package CBL;

import java.awt.*;

public class Room{

    Wall walls[] = new Wall[4];

    public Room(Graphics g) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
    
        walls[0] = new Wall(0, 0, screenWidth, 100); 
        walls[1] = new Wall(0, screenHeight - 100, screenWidth, 100); 
        walls[2] = new Wall(0, 0, 100, screenHeight); 
        walls[3] = new Wall(screenWidth - 100, 0, 100, screenHeight); 
    }

    public Wall[] getWalls() {
        return walls;
    }

    public void draw(Graphics g) {
        for(Wall wall : walls) {
            wall.draw(g);
        }
    }
}
