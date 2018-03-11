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
}
