package CBL;

import java.awt.*;
import java.util.List;

public class Collision {

    private Rooms rooms;
    private Runnable repaintCallback;
    private Door enteredDoor;
    private int screenWidth = Play.screenWidth;
    private int screenHeight = Play.screenHeight;
    private int wallThickness = screenWidth / 50;
    private int roomId = 1;
    private boolean ladderDoor = false;

    public Collision(Rooms rooms, Runnable repaintCallback) {
        this.rooms = rooms;
        this.repaintCallback = repaintCallback;
    }

    public boolean checkCollision(int charX, int charY, int charWidth, int charHeight, List<GameObject> objects) {
        for (GameObject object : objects) {
            if (object.collidesWith(charX, charY, charWidth, charHeight)) {
                if (object instanceof Door) {
                    enteredDoor = (Door) object;
                } else if(object instanceof Fisherman && !((Fisherman)object).spoken) {
                     ((Fisherman)object).interact();
                     return false;
                } else if (object instanceof NPC && !((NPC)object).spoken) {
                    ((NPC)object).interact();
                    return false;
                } 
                return true;
            } 
        }
        return false;
    }
    
    public void resolveMovement(Character player, int prevX, int prevY, List<GameObject> objects, 
                                boolean upPressed, boolean downPressed, boolean leftPressed, boolean rightPressed) {
                                    
        int currentX = player.x;
        int currentY = player.y;
        int width = player.width;
        int height = player.height;
        int speed = player.speed;

        Rectangle stairs_1 = new Rectangle(screenWidth / 5 * 3 + wallThickness - width, -height, screenWidth / 5 - wallThickness + width, wallThickness * 16 + height);
        Rectangle stairs_2 = new Rectangle(screenWidth / 5 * 2 + wallThickness - width, wallThickness * 3 - height, screenWidth / 5 - wallThickness + width, wallThickness * 7 + height);
        Rectangle ladder_1 = new Rectangle(screenWidth - wallThickness * 15 / 2 - width, screenHeight - wallThickness * 10 - height, wallThickness * 15 / 2 + width, wallThickness * 11 / 2 + height);
        Rectangle ladder_2 = new Rectangle(screenWidth - wallThickness * 27 / 2 - width, wallThickness * 6 - height, wallThickness * 4 + width, wallThickness * 11 / 2 + height);

        boolean[] onStairsOrLadder = new boolean[4];
        onStairsOrLadder[0] = (roomId == 4 && stairs_1.contains(currentX, currentY));  
        onStairsOrLadder[1] = (roomId == 5 && ladder_1.contains(currentX, currentY));  
        onStairsOrLadder[2] = (roomId == 7 && stairs_2.contains(currentX, currentY));
        onStairsOrLadder[3] = (roomId == 10 && ladder_2.contains(currentX, currentY));  
        
        boolean isOnStairsOrLadder = false;
        for (boolean condition : onStairsOrLadder) {
            if (condition) {
                isOnStairsOrLadder = true; 
                break; 
            }
        }
    
        if (isOnStairsOrLadder) {
            speed = player.speed * 3 / 4;
        }

        if (upPressed || downPressed || leftPressed ||rightPressed) {
            Play.playSound("kick.wav");
        }

        if (upPressed) {
            currentY -= speed;
        } else if (downPressed) {
            currentY += speed;
        }

        if((upPressed || downPressed) && checkCollision(currentX, currentY, width, height, objects)) {
            currentY = prevY;
        }

        if (leftPressed) {
            currentX -= speed;
        } else if (rightPressed) {
            currentX += speed;
        }

        if ((leftPressed || rightPressed) && checkCollision(currentX, currentY, width, height, objects)) {
            currentX = prevX;
        } 

        player.setPosition(currentX, currentY);
        
        if (enteredDoor != null) {
            int targetRoomId = enteredDoor.getTargetRoomId();
            if (enteredDoor.bottom()) {
                player.setPosition(currentX, screenHeight - enteredDoor.y);
            } else if (enteredDoor.top()) {
                player.setPosition(currentX, screenHeight - enteredDoor.y - enteredDoor.height - height);
            } else if (enteredDoor.right()) {
                player.setPosition(screenWidth - enteredDoor.x, currentY);
            } else {
                player.setPosition(screenWidth - enteredDoor.x - enteredDoor.width - width, currentY);
            }
            switch (targetRoomId) {
                case 1:
                    rooms.outside_1();
                    break;
                case 2:
                    rooms.outside_2();
                    break;
                case 3:
                    rooms.floor1_entrance();
                    break;
                case 4:
                    rooms.floor1_staircase();
                    break;
                case 5:
                    if (ladderDoor) {
                        player.setPosition(screenWidth + wallThickness - width, currentY + screenHeight - wallThickness * 16);
                        ladderDoor = false;
                    }
                    rooms.floor2_bathroom();
                    break;
                case 6:
                    rooms.floor2_rei();
                    break;
                case 7:
                    rooms.floor2_kitchen();
                    break;
                case 8:
                    rooms.floor2_living_room();
                    break;
                case 9:
                    rooms.floor2_balcony();
                    break;
                case 10:
                    player.setPosition(screenWidth - wallThickness * 27 / 2, currentY - screenHeight + wallThickness * 16);
                    ladderDoor = true;
                    rooms.floor3_attic();
                    break;
            }
            repaintCallback.run();
            enteredDoor = null;
            roomId = targetRoomId;
        }
    }
}