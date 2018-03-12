package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.*;

public class Enemy extends GameObject {

        private ObjectHandler handler;

        public Enemy(int x, int y, ID id, ObjectHandler handler) {
                super(x, y, id);
                this.handler = handler;
        }

        @Override
        public void tick() {
                x += velocityX;
                y += velocityY;
        }

        @Override
        public void render(Graphics graphics) {
                graphics.setColor(Color.green);
                graphics.fillRect(x, y, 32, 32);

        }

        @Override
        public Rectangle getBounds() {
                return new Rectangle(x, y, 32, 32);
        }
}
