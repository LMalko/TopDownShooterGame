package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Crate extends GameObject{

        private BufferedImage crateImage;

        Crate(int x, int y, ID id, SpriteSheet spriteSheet) {
                super(x, y, id, spriteSheet);
                crateImage = spriteSheet.grabImage(6,2,32,32);
        }

        @Override
        public void tick() {

        }

        @Override
        public void render(Graphics graphics) {
                graphics.drawImage(crateImage,x,y,null);

        }

        @Override
        public Rectangle getBounds() {
                return new Rectangle(x,y,32,32);
        }
}
