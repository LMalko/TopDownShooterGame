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

        public int getY() {
                return y;
        }


        public ID getId() {
                return id;
        }

}
