package Java.Abstract;

import java.awt.*;

public abstract class GameObject {

        protected int x;
        protected int y;
        protected float velocityX = 0;
        protected float velocityY = 0;

        public GameObject(int x, int y) {
                this.x = x;
                this.y = y;
        }

        public abstract void tick();
        public abstract void render(Graphics graphics);
        public abstract Rectangle getBounds();

        public int getX() {
                return x;
        }

        public void setX(int x) {
                this.x = x;
        }

        public int getY() {
                return y;
        }

        public void setY(int y) {
                this.y = y;
        }

        public float getVelocityX() {
                return velocityX;
        }

        public void setVelocityX(float velocityX) {
                this.velocityX = velocityX;
        }

        public float getVelocityY() {
                return velocityY;
        }

        public void setVelocityY(float velocityY) {
                this.velocityY = velocityY;
        }
}
