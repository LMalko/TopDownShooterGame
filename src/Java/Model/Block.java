package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block extends GameObject{

        private BufferedImage blockImage;

        public Block(int x, int y, ID id, SpriteSheet spriteSheet) {
                super(x, y, id, spriteSheet);
                blockImage = spriteSheet.grabImage(5,2,32,32);
        }

        @Override
        public void tick() {

        }

        @Override
        public void render(Graphics graphics) {
                graphics.drawImage(blockImage,x,y,null);
        }

        @Override
        public Rectangle getBounds() {
                return new Rectangle(x, y, 32, 32);
        }
}
