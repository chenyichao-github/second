package awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ZoomImage {
    private final int WIDTH = 80;
    private final int HEIGHT = 60;
    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();

    public static void main(String[] args) throws IOException {
        new ZoomImage().zoom();
    }

    public void zoom() throws IOException {
        Image srcImage = ImageIO.read(new File("image/board.jpg"));
        g.drawImage(srcImage, 0, 0, WIDTH, HEIGHT, null);
        ImageIO.write(image, "jpeg", new File(System.currentTimeMillis() + ".jpg"));
    }
}
