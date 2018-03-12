package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.*;

public class Bullet extends GameObject{

        private ObjectHandler handler;

        public Bullet(int x, int y, ID id, ObjectHandler handler, int mouseX, int mouseY) {
                super(x, y, id);
                this.handler = handler;
//                Velocity.
                velocityX = (mouseX - x) / 10;
                velocityY = (mouseY - y) / 10;
        }

        @Override
        public void tick() {
                x += velocityX;
                y += velocityY;


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