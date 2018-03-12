package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.*;

public class Bullet extends GameObject{

        private ObjectHandler handler;

        public Bullet(int x, int y, ID id) {
                super(x, y, id);
        }

        @Override
        public void tick() {
                x += velX;
                y += velY;


        }

        @Override
        public void render(Graphics graphics) {

                graphics.setColor(Color.blue);
                graphics.fillOval(x, y, 8, 8);
        }

        @Override
        public Rectangle getBounds() {
                return new Rectangle(x, y, 8,8);
        }
}
