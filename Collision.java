package CBL;

import java.awt.*;
import java.util.List;

public class Collision {
    private Rooms rooms;
    private Runnable repaintCallback;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();

    public Collision(Rooms rooms, Runnable repaintCallback) {
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

    public Door enteredDoor(int charX, int charY, int charWidth, int charHeight, List<Door> doors) {
        for (Door door : doors) {
            if (door.enteredDoor(charX, charY, charWidth, charHeight)) {
                return door;
            }
        }
        return null;
    }

    public void resolveMovement(Movement movement, int prevX, int prevY, 
                                List<Wall> walls, List<Door> doors,
                                boolean upPressed, boolean downPressed, 
                                boolean leftPressed, boolean rightPressed) {
        int currentX = movement.getX();
        int currentY = movement.getY();

        if (upPressed) {
            currentY -= movement.getSpeed();
        } else if (downPressed) {
            currentY += movement.getSpeed();
        }

        if (leftPressed) {
            currentX -= movement.getSpeed();
        } else if (rightPressed) {
            currentX += movement.getSpeed();
        }

        if (checkCollision(currentX, currentY, movement.getWidth(), movement.getHeight(), walls)) {
            // Revert to previous position if collision occurs
            currentX = prevX;
            currentY = prevY;
        }

        // Check if a door is entered and switch to the room associated with the door
        Door enteredDoor = enteredDoor(currentX, currentY, movement.getWidth(), movement.getHeight(), doors);
        if (enteredDoor != null) {
            int targetRoomId = enteredDoor.getTargetRoomId();
            switch (targetRoomId) {
                case 1:
                    rooms.initRoom1(screenWidth, screenHeight);
                    break;
                case 2:
                    rooms.initRoom2(screenWidth, screenHeight);
                    break;
                case 3:
                    rooms.initRoom3(screenWidth, screenHeight);
                    break;
            }
            repaintCallback.run();
        }

        movement.setPosition(currentX, currentY);
    }
}