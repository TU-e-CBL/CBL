package CBL;

import java.awt.*;
import java.util.List;

import java.util.ArrayList;

public class Collision {

    private Rooms rooms;
    private Runnable repaintCallback;
    private Door enteredDoor;
    private int screenWidth = Play.screenWidth;
    private int screenHeight = Play.screenHeight;

    public Collision(Rooms rooms, Runnable repaintCallback) {
        this.rooms = rooms;
        this.repaintCallback = repaintCallback;
    }

    public boolean checkCollision(int charX, int charY, int charWidth, int charHeight, List<GameObject> objects) {
        for (GameObject object : objects) {
            if (object.collidesWith(charX, charY, charWidth, charHeight)) {
                if (object instanceof Door) {
                    enteredDoor = (Door) object;
                } else if (object instanceof Fisherman) {
                    if (!((Fisherman)object).spoken) {
                        ((Fisherman)object).interact();
                    }
                    return false;
                }
                return true;
            } 
        }
        return false;
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
        if (enteredDoor != null) {
            int targetRoomId = enteredDoor.getTargetRoomId();
            if (enteredDoor.top()) {
                player.setPosition(currentX, screenHeight - enteredDoor.getY());
            } else if (enteredDoor.bottom()) {
                player.setPosition(currentX, screenHeight - enteredDoor.getY() - 90);
            } else if (enteredDoor.right()) {
                player.setPosition(screenWidth - enteredDoor.getX(), currentY);
            } else {
                player.setPosition(screenWidth - enteredDoor.getX() - 80, currentY);
            }
            switch (targetRoomId) {
                case 1:
                    rooms.outside_1();
                    break;
                case 2:
                    rooms.outside_2();
                    break;
                case 3:
                    rooms.initRoom1();
                    break;
                case 4:
                    rooms.initRoom2();
                    break;
                case 5:
                    rooms.initRoom3();
                    break;
            }
            repaintCallback.run();
            enteredDoor = null;
        }
    }
}