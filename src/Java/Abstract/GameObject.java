package Java.Abstract;

import Java.Enums.ID;
import Java.Model.SpriteSheet;

import java.awt.*;

public abstract class GameObject {

        protected int x;
        protected int y;
        protected float velocityX = 0;
        protected float velocityY = 0;
        private SpriteSheet spriteSheet;

        protected ID id;

        public GameObject(int x, int y, ID id, SpriteSheet spriteSheet) {
                this.x = x;
                this.y = y;
                this.id = id;
                this.spriteSheet = spriteSheet;
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

        public ID getId() {
                return id;
        }

        public void setId(ID id) {
                this.id = id;
        }
}
