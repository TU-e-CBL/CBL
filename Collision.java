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

    public boolean checkCollision(int charX, int charY, int charWidth, int charHeight, List<GameObject> objects) {
        for (GameObject object : objects) {
            if (object.collidesWith(charX, charY, charWidth, charHeight)) {
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

    public void resolveMovement(Character player, int prevX, int prevY, 
                                List<GameObject> objects, List<Door> doors,
                                boolean upPressed, boolean downPressed, 
                                boolean leftPressed, boolean rightPressed) {
        int currentX = player.getX();
        int currentY = player.getY();

        if (upPressed) {
            currentY -= player.getSpeed();
        } else if (downPressed) {
            currentY += player.getSpeed();
        }

        if((upPressed || downPressed) && checkCollision(currentX, currentY, player.getWidth(), player.getHeight(), objects)) {
            currentY = prevY;
        }

        if (leftPressed) {
            currentX -= player.getSpeed();
        } else if (rightPressed) {
            currentX += player.getSpeed();
        }

        if ((leftPressed || rightPressed) && checkCollision(currentX, currentY, player.getWidth(), player.getHeight(), objects)) {
            currentX = prevX;
        } 
        
        // Check if a door is entered and switch to the room associated with the door
        Door enteredDoor = enteredDoor(currentX, currentY, player.getWidth(), player.getHeight(), doors);
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

        player.setPosition(currentX, currentY);
    }
}