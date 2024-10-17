package CBL;

import java.awt.*;
import java.util.List;



public class Collision {
    private Rooms rooms;
    private Runnable repaintCallback;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    public Collision(Rooms rooms, Runnable repaintCallback) {  // Pass the Rooms instance
        this.rooms = rooms;
        this.repaintCallback = repaintCallback;
    }

    public boolean checkCollision(int charX, int charY, int charWidth, int charHeight, List<Wall> walls) {
        for (Wall wall : walls) {
            if (wall.collidesWith(charX, charY, charWidth, charHeight)) {
                return true;
            }
        }
        return false;
    }
    public boolean enteredDoor(int charX, int charY, int charWidth, int charHeight, List<Door> doors) {
        for (Door door : doors) {
            if (door.enteredDoor(charX, charY, charWidth, charHeight)) {
                return true;
            }
        }
        return false;
    }

    public void resolveMovement(Movement movement, int prevX, int prevY, 
                                List<Wall> walls, List<Door> doors,
                                boolean upPressed, boolean downPressed, 
                                boolean leftPressed, boolean rightPressed) {
        int currentX = movement.getX();
        int currentY = movement.getY();
        
        if (upPressed) {
            currentY -= movement.getSpeed(); // Move up
            if (checkCollision(currentX, currentY, movement.getWidth(), 
                            movement.getHeight(), walls)) {
                currentY = prevY; // Revert to previous position if collision occurs
            } else if (enteredDoor(currentX, currentY, movement.getWidth(), 
                            movement.getHeight(), doors)) {
                rooms.initRoom2(screenWidth, screenHeight);
                repaintCallback.run();  
            }
            
        }

        if (downPressed) {
            currentY += movement.getSpeed(); // Move down
            if (checkCollision(currentX, currentY, movement.getWidth(), 
                        movement.getHeight(), walls)) {
                currentY = prevY; // Revert to previous position if collision occurs
            }
        }

        if (leftPressed) {
            currentX -= movement.getSpeed(); // Move left
            if (checkCollision(currentX, currentY, movement.getWidth(), movement.getHeight(), walls)) {
                currentX = prevX; // Revert to previous position if collision occurs
            }
        }

        if (rightPressed) {
            currentX += movement.getSpeed(); // Move right
            if (checkCollision(currentX, currentY, movement.getWidth(), movement.getHeight(), walls)) {
                currentX = prevX; // Revert to previous position if collision occurs
            }
        }

        movement.setPosition(currentX, currentY);
    }
}
