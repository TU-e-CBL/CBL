package CBL;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadedObject extends GameObject {
    private Image image;

    public LoadedObject(int x, int y, int width, int height, String imagePath) {
        super(x, y, width, height);  
        loadImage(imagePath);
    }

    private void loadImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
            image.getScaledInstance(width, height, image.SCALE_SMOOTH);
            // Optional: Set width and height based on image size
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, x, y, width, height, null);
        } else {
            g.setColor(Color.GRAY); 
            g.fillRect(x, y, width, height);
        }
    }
}
