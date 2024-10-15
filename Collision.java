package CBLPROTOTYPE.src;

import java.util.List;

public class Collision {
    public boolean checkCollision(int charX, int charY, int charWidth, int charHeight, List<Wall> walls) {
        for (Wall wall : walls) {
            if (wall.collidesWith(charX, charY, charWidth, charHeight)) {
                return true;
            }
        }
        return false;
    }

    public void resolveMovement(Movement movement, int prevX, int prevY, List<Wall> walls, 
                                boolean upPressed, boolean downPressed, boolean leftPressed, boolean rightPressed) {
        int currentX = movement.getX();
        int currentY = movement.getY();

        if (upPressed) {
            currentY -= movement.getSpeed(); // Move up
            if (checkCollision(currentX, currentY, movement.getWidth(), movement.getHeight(), walls)) {
                currentY = prevY; // Revert to previous position if collision occurs
            }
        }

        if (downPressed) {
            currentY += movement.getSpeed(); // Move down
            if (checkCollision(currentX, currentY, movement.getWidth(), movement.getHeight(), walls)) {
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
