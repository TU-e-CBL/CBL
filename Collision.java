package CBL;

import java.awt.*;
import java.util.List;

public class Collision {
    private Rooms rooms;
    private Runnable repaintCallback;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int) screenSize.getWidth();
    int screenHeight = (int) screenSize.getHeight();
    int oldRoomId = 1;

    public Collision(Rooms rooms, Runnable repaintCallback) {
        this.rooms = rooms;
        this.repaintCallback = repaintCallback;
    }

    public boolean checkCollision(int charX, int charY, int charWidth, int charHeight, List<GameObject> objects) {
        for (GameObject object : objects) {
            if (object.collidesWith(charX, charY, charWidth, charHeight) && !(object instanceof Door)) {
                return true;
            } 
        }
        return false;
    }

    public Door enteredDoor(int charX, int charY, int charWidth, int charHeight, List<GameObject> objects) {
        for (GameObject object : objects) {
            if (object instanceof Door) {
                Door door = (Door) object;
                if (door.collidesWith(charX, charY, charWidth, charHeight)) {
                    return door;
                }
            }
        }
        return null;
    }
    
    public void resolveMovement(Character player, int prevX, int prevY, 
                                List<GameObject> objects,
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

        player.setPosition(currentX, currentY);
        // Check if a door is entered and switch to the room associated with the door
        Door enteredDoor = enteredDoor(currentX, currentY, player.getWidth(), player.getHeight(), objects);
        if (enteredDoor != null) {
            int targetRoomId = enteredDoor.getTargetRoomId();
            switch (targetRoomId) {
                case 1:
                    if (oldRoomId == 2) {
                        player.setPosition(150, screenHeight / 2 - 45);
                    } else {
                        player.setPosition(screenWidth / 2 - 40, 150);
                    }
                    rooms.initRoom1(screenWidth, screenHeight);
                    break;
                case 2:
                    rooms.initRoom2(screenWidth, screenHeight);
                    player.setPosition(screenWidth / 2, screenHeight / 2);
                    break;
                case 3:
                    rooms.initRoom3(screenWidth, screenHeight);
                    player.setPosition(screenWidth / 2, screenHeight / 2);
                    break;
            }
            oldRoomId = targetRoomId;
            repaintCallback.run();
        }
    }
}