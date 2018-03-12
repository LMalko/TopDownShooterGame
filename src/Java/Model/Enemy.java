package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject {

        private ObjectHandler handler;
        Random random = new Random();
        int choose = 0;
        int hp = 100;

        public Enemy(int x, int y, ID id, ObjectHandler handler) {
                super(x, y, id);
                this.handler = handler;
        }

        @Override
        public void tick() {
                x += velocityX;
                y += velocityY;

                choose = random.nextInt(10);

                for(int i = 0; i < handler.objectsCollection.size(); i++){
                        GameObject tempObject = handler.objectsCollection.get(i);
                        if(tempObject.getId() == ID.Block){
                                if(getBoundsBig().intersects(tempObject.getBounds())){
                                        velocityX += (velocityX*2) * -1;
                                        velocityY += (velocityY*2) * -1;
                                }else if(choose == 0){
                                        velocityX = (random.nextInt( 4 - -4) + -4);
                                        velocityY = (random.nextInt( 4 - -4) + -4);
                                }
                        }
                        if(tempObject.getId() == ID.Bullet){
                                if(getBoundsBig().intersects(tempObject.getBounds())) {
                                        hp -= 50;
                                        handler.removeGameObject(tempObject);
                                }
                        }
                        if(hp == 0){
                                handler.removeGameObject(this);
                        }
                }
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

        public Rectangle getBoundsBig(){
                return new Rectangle(x -16, y -16, 64, 64);
        }
}