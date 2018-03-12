package Java.Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedImageLoader {

        private BufferedImage image;

        private BufferedImage loadImage(String path){

                try {
                        image = ImageIO.read(getClass().getResource(path));
                } catch (IOException e) {
                        e.printStackTrace();
                }

        }
        

}
