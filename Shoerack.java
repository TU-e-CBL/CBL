package CBL;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Shoerack extends GameObject {
    private Image image;

    public Shoerack(int x, int y, String imagePath) {
        super(x, y, 50, 200);  
        loadImage(imagePath);
    }

    private void loadImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
            // Optional: Set width and height based on image size
            width = image.getWidth(null);
            height = image.getHeight(null);
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
