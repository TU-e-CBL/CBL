package CBL;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Rooms {

    private int screenWidth = Play.screenWidth;
    private int screenHeight = Play.screenHeight;
    private int wallThickness = screenWidth / 50;
    private List<GameObject> objects;
    private Color white = Color.WHITE.darker();
    private Color gray = Color.DARK_GRAY;
    private Color grass = new Color(20, 60, 20);
    private Color dark_gray = new Color(20, 20, 20);
    private Color wood = new Color(102,68,51);
    private Color light_brown = new Color(152, 120, 90);
    private Color backgroundColor;

    public Rooms() {
        objects = new ArrayList<>();
    }

    public void outside_1() {
        objects.clear();
        backgroundColor = grass;

        objects.add(new Wall(wallThickness, wallThickness * 3, 5, screenHeight - wallThickness * 6, gray));

        for (int x = wallThickness; x < screenWidth; x = x + 10) {
            objects.add(new Wall(x, wallThickness, 5, wallThickness * 2, gray));
            objects.add(new Wall(x, screenHeight - wallThickness * 3, 5, wallThickness * 2, gray));
        }
        objects.add(new Door(screenWidth + wallThickness, 0, 0, screenHeight, 2));
    }

    public void outside_2() {
        objects.clear();
        backgroundColor = grass;

        for (int x = 0; x < screenWidth - wallThickness; x = x + 10) {
            objects.add(new Wall(x, wallThickness, 5, wallThickness * 2, gray));
            objects.add(new Wall(x, screenHeight - wallThickness * 3, 5, wallThickness * 2, gray));
        }
        objects.add(new Wall(screenWidth - wallThickness, 0, wallThickness, wallThickness * 4, white));
        objects.add(new Wall(screenWidth - wallThickness, wallThickness * 16, wallThickness, screenHeight - wallThickness * 16, white));

        objects.add(new Door(-wallThickness, 0, 0, screenHeight, 1));
        objects.add(new Door(screenWidth - wallThickness / 2, wallThickness  * 4, wallThickness / 2, wallThickness * 12, 3));

        objects.add(new Fisherman(screenWidth - wallThickness * 3 / 2, wallThickness * 17, wallThickness / 2, wallThickness * 3, gray.darker(), "Miyazawa_residency.txt"));
    }

    public void floor1_entrance() {
        objects.clear();
        backgroundColor = dark_gray;

        objects.add(new Wall(0, 0, screenWidth, wallThickness, white));
        objects.add(new Wall(0, screenHeight - wallThickness, screenWidth, wallThickness, white));
        objects.add(new Wall(0, 0, wallThickness, wallThickness * 4, white));
        objects.add(new Wall(0, wallThickness * 16, wallThickness, screenHeight - wallThickness * 16, white));

        objects.add(new Wall(wallThickness * 24, screenHeight - wallThickness * 11, wallThickness * 3, wallThickness * 3, light_brown));
        objects.add(new Wall(wallThickness * 39, screenHeight - wallThickness * 11, wallThickness * 3, wallThickness * 3, light_brown));
        objects.add(new Wall(wallThickness * 24, screenHeight - wallThickness * 34 / 3, wallThickness * 3, wallThickness / 2, light_brown.darker()));
        objects.add(new Wall(wallThickness * 39, screenHeight - wallThickness * 34 / 3, wallThickness * 3, wallThickness / 2, light_brown.darker()));
        objects.add(new Wall(wallThickness * 17, screenHeight - wallThickness * 7, wallThickness * 32, wallThickness * 6, wood));

        objects.add(new Door(0, wallThickness * 4, wallThickness / 2, wallThickness * 12, 2)); 
        objects.add(new Door(screenWidth + wallThickness, 0, 0, screenHeight, 4));

        objects.add(new LoadedObject(screenWidth / 5, wallThickness, screenHeight / 7, screenHeight / 7 * 4,"shoe_rack_1.png"));
        objects.add(new LoadedObject(screenWidth - wallThickness * 20, wallThickness, wallThickness * 20, wallThickness * 4, "Bookshelf.png"));

        objects.add(new NPC(wallThickness * 35, screenHeight - wallThickness * 14, wallThickness * 4, wallThickness * 6, "Mikio.png", "Its_past_your_bedtime"));
    }

    public void floor1_staircase() {
        objects.clear(); 
        backgroundColor = dark_gray;

        objects.add(new Wall(0, 0, screenWidth / 5 * 3, wallThickness, white));
        objects.add(new Wall(screenWidth / 5 * 4, 0, screenWidth / 5, wallThickness, white));
        objects.add(new Wall(0, screenHeight - wallThickness, screenWidth, wallThickness, white));
        objects.add(new Wall(screenWidth - wallThickness, 0, wallThickness, screenHeight, white));
        objects.add(new Wall(screenWidth / 5 * 4, 0, wallThickness, screenHeight - wallThickness * 9, white));
        objects.add(new Wall(screenWidth / 5 * 3, 0, wallThickness, wallThickness * 33 / 2, white));
        
        for (int y = 0; y < wallThickness * 16; y = y + wallThickness / 4 * 5) {
            objects.add(new Shape(screenWidth / 5 * 3 + wallThickness, y, screenWidth / 5 - wallThickness, wallThickness, wood, "rectangle"));
            objects.add(new Shape(screenWidth / 5 * 3 + wallThickness, y + wallThickness, screenWidth / 5 - wallThickness, wallThickness / 4, wood.darker(), "rectangle"));
        }
        objects.add(new Shape(screenWidth / 5 * 4 + wallThickness / 4, screenHeight - wallThickness * 9, wallThickness / 2, wallThickness * 8, wood, "rectangle"));
        objects.add(new Door(-wallThickness, 0, 0, screenHeight, 3));
        objects.add(new Door(screenWidth / 5 * 3 + wallThickness, -wallThickness, screenWidth / 5 - wallThickness, 0, 5));

        objects.add(new LoadedObject(-(wallThickness * 8), wallThickness, wallThickness * 20, wallThickness * 4, "Bookshelf.png"));
        objects.add(new Fisherman(screenWidth - wallThickness * 3 / 2, wallThickness * 3, wallThickness / 2, wallThickness * 3, gray.darker(), "Money.txt"));
    }

    public void floor2_bathroom() {
        objects.clear();
        backgroundColor = dark_gray;

        objects.add(new Wall(0, 0, screenWidth, wallThickness, white));
        objects.add(new Wall(0, screenHeight - wallThickness, screenWidth / 5 * 2 + wallThickness, wallThickness, white));
        objects.add(new Wall(screenWidth / 5 * 3, screenHeight - wallThickness, wallThickness, wallThickness, white));
        objects.add(new Wall(screenWidth / 5 * 4, screenHeight - wallThickness, wallThickness, wallThickness, white));
        objects.add(new Wall(0, 0, wallThickness, screenHeight - wallThickness * 9, white));
        //objects.add(new Wall(screenWidth - wallThickness, 0, wallThickness, screenHeight, white));

        objects.add(new Shape(screenWidth / 2 + wallThickness * 9 / 2, 0, wallThickness * 4, wallThickness * 7 / 2, white, "roundrect"));
        objects.add(new Wall(screenWidth / 2 + wallThickness * 5, wallThickness * 5 / 4, wallThickness * 3, wallThickness * 2, white.darker()));
        objects.add(new Shape(screenWidth / 2 + wallThickness * 19 / 3, wallThickness * 5 / 4, wallThickness / 3, wallThickness * 3 / 2, white, "rectangle"));
        
        objects.add(new Wall(screenWidth - wallThickness * 10, wallThickness * 2, wallThickness * 8, screenHeight - wallThickness * 15, white));
        objects.add(new Shape(screenWidth - wallThickness * 21 / 2, wallThickness * 3 / 2, wallThickness * 9, screenHeight - wallThickness * 14, white, "roundrect"));
        objects.add(new Shape(screenWidth - wallThickness * 10, wallThickness * 2, wallThickness * 8, screenHeight - wallThickness * 15, white.darker(), "roundrect"));

        objects.add(new Wall((screenWidth - wallThickness) / 2, wallThickness, wallThickness, screenHeight - wallThickness * 12, white));
        objects.add(new Wall((screenWidth - wallThickness) / 2, screenHeight - wallThickness * 12, wallThickness * 3, wallThickness + wallThickness / 7, white));
        objects.add(new Wall((screenWidth - wallThickness) / 2 + wallThickness * 11, screenHeight - wallThickness * 12, (screenWidth - wallThickness) / 2 - wallThickness * 10, wallThickness + wallThickness / 7, white));
        objects.add(new Shape((screenWidth - wallThickness) / 2 + wallThickness * 3, screenHeight - wallThickness * 47 / 4, wallThickness * 8, wallThickness / 2, wood, "rectangle"));

        int tempWidth = (screenWidth - wallThickness) / 4 - wallThickness * 8 / 10;
        objects.add(new Wall(wallThickness * 6 / 5, wallThickness * 6 / 5, tempWidth, wallThickness * 6, light_brown));
        objects.add(new Wall((screenWidth - wallThickness) / 4 + wallThickness * 6 / 10, wallThickness * 6 / 5, tempWidth, wallThickness * 6, light_brown));
        for (int i = 1; i < 4; i++) {
            objects.add(new Shape((wallThickness * 6 / 5 + tempWidth) / 4 * i + wallThickness / 2, wallThickness * 36 / 5, wallThickness / 2, wallThickness / 4, new Color(240,230, 140), "rectangle"));
        }
        for (int i = 5; i < 8; i++) {
            objects.add(new Shape((wallThickness * 6 / 5 + tempWidth) / 4 * i - wallThickness * 3 / 4, wallThickness * 36 / 5, wallThickness / 2, wallThickness / 4, new Color(240,230, 140), "rectangle"));
        }

        objects.add(new Wall(screenWidth - wallThickness, 0, wallThickness, screenHeight - wallThickness * 10, white));
        objects.add(new Wall(screenWidth - wallThickness, screenHeight - wallThickness * 5, wallThickness, wallThickness * 5, white));

        objects.add(new Wall(screenWidth - wallThickness * 8, screenHeight - wallThickness * 10, wallThickness * 8, wallThickness / 2, wood));
        objects.add(new Wall(screenWidth - wallThickness * 8, screenHeight - wallThickness * 5, wallThickness * 8, wallThickness / 2, wood));
        for (int x = screenWidth - wallThickness * 15 / 2; x < screenWidth; x = x + wallThickness * 3 / 2) {
            objects.add(new Shape(x, screenHeight - wallThickness * 10, wallThickness / 2, wallThickness * 11 / 2, wood.brighter(), "rectangle"));
        }
        objects.add(new Door(screenWidth + wallThickness, screenHeight - wallThickness * 19 / 2, 0, wallThickness * 9 / 2, 10));

        objects.add(new Door(screenWidth / 5 * 3 + wallThickness, screenHeight + wallThickness, screenWidth / 5 - wallThickness, 0, 4));
        objects.add(new Door(0, screenHeight - wallThickness * 9, wallThickness / 2, wallThickness * 8, 6));
        objects.add(new Door(screenWidth / 5 * 2 + wallThickness, screenHeight + wallThickness, screenWidth / 5 - wallThickness, 0, 7));
        objects.add(new Door(screenWidth / 5 * 4 + wallThickness, screenHeight - wallThickness / 2, screenWidth / 5 - wallThickness * 2, wallThickness / 2, 7));
    }

    public void floor2_rei() {
        objects.clear();
        backgroundColor = dark_gray;

        objects.add(new Wall(0, 0, screenWidth, wallThickness, white));
        objects.add(new Wall(0, screenHeight - wallThickness, screenWidth, wallThickness, white));
        objects.add(new Wall(0, 0, wallThickness, screenHeight / 2 - wallThickness * 4, white));
        objects.add(new Wall(0, screenHeight / 2 + wallThickness * 4, wallThickness, screenHeight / 2 - wallThickness * 4, white));
        objects.add(new Wall(screenWidth - wallThickness, 0, wallThickness, screenHeight - wallThickness * 9, white));

        objects.add(new Wall(wallThickness * 12, wallThickness, wallThickness * 20, wallThickness * 7, wood));
        objects.add(new Wall(wallThickness * 31 / 2, wallThickness * 9, wallThickness * 3, wallThickness * 3, light_brown));
        objects.add(new Wall(wallThickness * 51 / 2, wallThickness * 9, wallThickness * 3, wallThickness * 3, light_brown));
        objects.add(new Wall(wallThickness * 31 / 2, wallThickness * 12, wallThickness * 3, wallThickness / 2, light_brown.darker()));
        objects.add(new Wall(wallThickness * 51 / 2, wallThickness * 12, wallThickness * 3, wallThickness / 2, light_brown.darker()));

        objects.add(new Wall(screenWidth - wallThickness * 41 / 4, wallThickness * 5 / 4, wallThickness * 9, screenHeight - wallThickness * 11, new Color(95, 144, 168)));
        objects.add(new Shape(screenWidth - wallThickness * 17 / 2, wallThickness * 3 / 2, wallThickness * 11 / 2, wallThickness * 3, white, "rectangle"));

        objects.add(new Door(screenWidth - wallThickness / 2, screenHeight - wallThickness * 9, wallThickness / 2, wallThickness * 8, 5));
        objects.add(new Door(-wallThickness, screenHeight / 2 - wallThickness * 4, 0, wallThickness * 8, 9));
    }

    public void floor2_kitchen() {
        objects.clear();
        backgroundColor = Color.BLACK;

        objects.add(new Shape(screenWidth / 5 * 2, 0, screenWidth / 5 * 3, screenHeight, dark_gray, "rectangle"));
        objects.add(new Shape(0, screenHeight / 5 * 3 - wallThickness / 5 * 3, screenWidth / 5 * 3, screenHeight / 5 * 2, dark_gray, "rectangle"));

        objects.add(new Wall(0, 0, screenWidth / 5 * 2, wallThickness, white));
        objects.add(new Wall(0, screenHeight - wallThickness, screenWidth, wallThickness, white));
        objects.add(new Wall(0, 0, wallThickness, screenHeight / 5 * 3, white));
        objects.add(new Wall(screenWidth - wallThickness, 0, wallThickness, screenHeight, white));
        objects.add(new Wall(screenWidth / 5 * 2, 0, wallThickness, screenHeight / 5 * 3, white));
        objects.add(new Wall(screenWidth / 5 * 3, 0, wallThickness, wallThickness * 33 / 2, white));
        objects.add(new Wall(screenWidth / 5 * 4, 0, wallThickness, wallThickness * 33 / 2, white));
        objects.add(new Wall(screenWidth / 5 * 3, wallThickness * 33 / 2, screenWidth / 5 * 2, wallThickness - wallThickness / 10, white));

        objects.add(new Wall(screenWidth / 10 * 9 - wallThickness * 2, wallThickness * 61 / 4, wallThickness * 4, wallThickness, white));
        objects.add(new Wall(screenWidth / 10 * 9 - wallThickness * 3 / 2, wallThickness * 45 / 4, wallThickness * 3, wallThickness * 4, white.darker()));
        objects.add(new Shape(screenWidth / 10 * 9 - wallThickness * 7 / 4, wallThickness * 21 / 2, wallThickness * 7 / 2, wallThickness * 9 / 2, white, "oval"));

        objects.add(new Wall(wallThickness, wallThickness, wallThickness * 5, screenHeight / 5 * 3 - wallThickness * 2, gray));;
        objects.add(new Wall(screenWidth / 5 * 2 - wallThickness * 5, wallThickness, wallThickness * 5, screenHeight / 5 * 3 - wallThickness * 2, gray));
        objects.add(new Shape(wallThickness, screenHeight / 5, wallThickness * 5, wallThickness / 7, dark_gray, "rectangle"));
        objects.add(new Shape(wallThickness, screenHeight / 5 * 2, wallThickness * 5, wallThickness / 10, dark_gray, "rectangle"));
        objects.add(new Shape(screenWidth / 5 * 2 - wallThickness * 5, screenHeight / 5, wallThickness * 5, wallThickness / 7, dark_gray, "rectangle"));
        objects.add(new Shape(screenWidth / 5 * 2 - wallThickness * 5, screenHeight / 5 * 2, wallThickness * 5, wallThickness / 10, dark_gray, "rectangle"));

        objects.add(new Wall(wallThickness, screenHeight / 5 * 3 - wallThickness, screenWidth / 5 - wallThickness * 9 / 2, wallThickness, white));
        objects.add(new Wall(screenWidth / 5 + wallThickness * 9 / 2, screenHeight / 5 * 3 - wallThickness, screenWidth / 5 - wallThickness * 9 / 2, wallThickness, white));

        for (int y = 0; y < wallThickness * 16; y = y + wallThickness / 4 * 5) {
            objects.add(new Shape(screenWidth / 5 * 3 + wallThickness, y, screenWidth / 5 - wallThickness, wallThickness, wood, "rectangle"));
            objects.add(new Shape(screenWidth / 5 * 3 + wallThickness, y + wallThickness, screenWidth / 5 - wallThickness, wallThickness / 4, wood.darker(), "rectangle"));
        }
        for (int y = wallThickness * 3; y < wallThickness * 9; y = y + wallThickness / 4 * 5) {
            objects.add(new Shape(screenWidth / 5 * 2 + wallThickness, y, screenWidth / 5 - wallThickness, wallThickness / 4, wood.darker(), "rectangle"));
            objects.add(new Shape(screenWidth / 5 * 2 + wallThickness, y + wallThickness / 5, screenWidth / 5 - wallThickness, wallThickness, wood, "rectangle"));
        }

        objects.add(new Shape(screenWidth / 5 - wallThickness * 7 / 2, screenHeight / 5 * 3 - wallThickness * 3 / 4, wallThickness * 8, wallThickness / 2, wood, "rectangle"));
        objects.add(new Shape(screenWidth / 5 * 3 + wallThickness / 4, wallThickness * 35 / 2 - wallThickness / 10, wallThickness / 2, screenHeight - wallThickness * 37 / 2 + wallThickness / 10, wood, "rectangle"));
        objects.add(new Door(screenWidth / 5 * 2 + wallThickness, -wallThickness, screenWidth / 5 - wallThickness, 0, 5));
        objects.add(new Door(screenWidth / 5 * 4 + wallThickness, 0, screenWidth / 5 - wallThickness * 2, wallThickness / 2, 5));
        objects.add(new Door(-wallThickness, screenHeight / 5 * 3, 0, screenHeight / 5 * 2 - wallThickness, 8));
    }

    public void floor2_living_room() {
        objects.clear();
        backgroundColor = dark_gray;

        objects.add(new Wall(0, 0, screenWidth, wallThickness, white));
        objects.add(new Wall(0, screenHeight - wallThickness, screenWidth, wallThickness, white));
        objects.add(new Wall(0, 0, wallThickness, screenHeight, white));
        objects.add(new Wall(screenWidth - wallThickness, 0, wallThickness, screenHeight / 5 * 3, white));

        objects.add(new Wall(screenWidth - wallThickness * 7, wallThickness * 5 / 4, wallThickness * 6, wallThickness * 14, light_brown));
        for (int i = 1; i < 4; i++) {
            objects.add(new Shape(screenWidth - wallThickness * 29 / 4, wallThickness * 14 / 3 * i - wallThickness * 3 / 2, wallThickness / 4, wallThickness / 2, new Color(240,230, 140), "rectangle"));
        }

        objects.add(new Wall(screenWidth - wallThickness * 23, wallThickness * 2, wallThickness * 3, wallThickness * 3, light_brown));
        objects.add(new Wall(screenWidth - wallThickness * 23, wallThickness * 7, wallThickness * 3, wallThickness * 3, light_brown));
        objects.add(new Wall(screenWidth - wallThickness * 16, wallThickness * 2, wallThickness * 3, wallThickness * 3, light_brown));
        objects.add(new Wall(screenWidth - wallThickness * 16, wallThickness * 7, wallThickness * 3, wallThickness * 3, light_brown));
        objects.add(new Wall(screenWidth - wallThickness * 47 / 2, wallThickness * 2, wallThickness / 2, wallThickness * 3, light_brown.darker()));
        objects.add(new Wall(screenWidth - wallThickness * 47 / 2, wallThickness * 7, wallThickness / 2, wallThickness * 3, light_brown.darker()));
        objects.add(new Wall(screenWidth - wallThickness * 13, wallThickness * 2, wallThickness / 2, wallThickness * 3, light_brown.darker()));
        objects.add(new Wall(screenWidth - wallThickness * 13, wallThickness * 7, wallThickness / 2, wallThickness * 3, light_brown.darker()));
        objects.add(new Wall(screenWidth - wallThickness * 22, wallThickness, wallThickness * 8, wallThickness * 10, wood));

        objects.add(new Wall(wallThickness * 2, wallThickness * 5 / 4, wallThickness * 18, wallThickness * 6, light_brown));
        objects.add(new Shape(wallThickness * 8, wallThickness * 3, wallThickness * 6, wallThickness * 5 / 2, gray.darker(), "roundrect"));
        objects.add(new Shape(wallThickness * 15 / 2, wallThickness * 5, wallThickness * 7, wallThickness / 2, dark_gray, "rectangle"));

        objects.add(new Shape(wallThickness * 5 / 4, screenHeight - wallThickness * 33 / 4, wallThickness * 21, wallThickness * 7, new Color(30, 20, 100), "roundrect"));
        objects.add(new Wall(wallThickness * 5 / 4, screenHeight - wallThickness * 13 / 4, wallThickness * 21, wallThickness * 2, new Color(21, 14, 70)));

        objects.add(new Door(screenWidth + wallThickness, screenHeight / 5 * 3, 0, screenHeight / 5 * 2, 7));
    }

    public void floor2_balcony() {
        objects.clear();
        backgroundColor = grass;

        for (int x = 0; x < screenWidth - wallThickness * 9; x = x + 10) {
            objects.add(new Wall(x, wallThickness, 5, wallThickness * 2, gray));
            objects.add(new Wall(x, screenHeight - wallThickness * 3, 5, wallThickness * 2, gray));
        }

        objects.add(new Shape(screenWidth - wallThickness * 9, 0, wallThickness * 9, screenHeight, dark_gray, "rectangle"));
        objects.add(new Wall(screenWidth - wallThickness * 9, 0, wallThickness * 8, wallThickness, white));
        objects.add(new Wall(screenWidth - wallThickness * 9, screenHeight - wallThickness, wallThickness * 8, wallThickness, white));
        objects.add(new Wall(screenWidth - wallThickness * 9, 0, wallThickness, screenHeight, white));
        objects.add(new Wall(screenWidth - wallThickness, 0, wallThickness, screenHeight / 2 - wallThickness * 4, white));
        objects.add(new Wall(screenWidth - wallThickness, screenHeight / 2 + wallThickness * 4, wallThickness, screenHeight / 2 - wallThickness * 4, white));

        objects.add(new Door(screenWidth + wallThickness, screenHeight / 2 - wallThickness * 4, 0, wallThickness * 8, 6));
    }

    public void floor3_attic() {
        objects.clear();
        backgroundColor = dark_gray;

        objects.add(new Wall(0, 0, screenWidth, wallThickness, white));
        objects.add(new Wall(0, screenHeight - wallThickness, screenWidth, wallThickness, white));
        objects.add(new Wall(0, 0, wallThickness, screenHeight, white));
        objects.add(new Wall(screenWidth - wallThickness, 0, wallThickness, screenHeight, white));

        objects.add(new Wall(wallThickness * 5 / 4, screenHeight - wallThickness * 57 / 4, wallThickness * 20, wallThickness * 13, new Color(115, 50, 50)));
        objects.add(new Shape(wallThickness * 3 / 2, screenHeight - wallThickness * 27 / 2, wallThickness * 3, wallThickness * 11 / 2, white, "rectangle"));
        objects.add(new Shape(wallThickness * 3 / 2, screenHeight - wallThickness * 15 / 2, wallThickness * 3, wallThickness * 11 / 2, white, "rectangle"));

        objects.add(new Wall(screenWidth - wallThickness * 29 / 2, wallThickness * 6, wallThickness / 2, wallThickness * 11 / 2, wood.darker()));
        objects.add(new Wall(screenWidth - wallThickness * 14, wallThickness * 6, wallThickness * 5, wallThickness / 2, wood));
        objects.add(new Wall(screenWidth - wallThickness * 14, wallThickness * 11, wallThickness * 5, wallThickness / 2, wood));
        for (int x = screenWidth - wallThickness * 27 / 2; x < screenWidth - wallThickness * 10; x = x + wallThickness * 3 / 2) {
            objects.add(new Shape(x, wallThickness * 6, wallThickness / 2, wallThickness * 11 / 2, wood.brighter(), "rectangle"));
        }
        objects.add(new Door(screenWidth - wallThickness * 55 / 4, wallThickness * 13 / 2 , 0, wallThickness * 9 / 2, 5));

        objects.add(new NPC(wallThickness * 22, screenHeight - wallThickness * 10, wallThickness * 3, wallThickness * 9 / 2, "Niina.png", "You_look_so_pale"));
    }

    public void drawObjects(Graphics g) {
        for (GameObject object : objects) {
            object.draw(g); 
        }
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public List<GameObject> getObjects() {
        return objects;
    }
}