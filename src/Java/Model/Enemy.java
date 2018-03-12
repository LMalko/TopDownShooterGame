package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject {

        private ObjectHandler handler;
        private Random random = new Random();
        private int choose = 0;
        private int hp = 100;
        private BufferedImage[] enemyImage = new BufferedImage[3];
        private Animation anim;

        Enemy(int x, int y, ID id, ObjectHandler handler, SpriteSheet spriteSheet) {
                super(x, y, id, spriteSheet);
                this.handler = handler;
                enemyImage[0] = spriteSheet.grabImage(4,1,32,32);
                enemyImage[1] = spriteSheet.grabImage(5,1,32,32);
                enemyImage[2] = spriteSheet.grabImage(6,1,32,32);
                anim = new Animation(3, enemyImage[0], enemyImage[1], enemyImage[2]);
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
                anim.runAnimation();
        }

        @Override
        public void render(Graphics graphics) {
                if(velocityX == 0 && velocityY == 0){
                        graphics.drawImage(enemyImage[0],x,y,null);
                }else{
                        anim.drawAnimation(graphics,x,y,0);
                }

        }

        @Override
        public Rectangle getBounds() {
                return new Rectangle(x, y, 32, 32);
        }

        private Rectangle getBoundsBig(){
                return new Rectangle(x -16, y -16, 64, 64);
        }
}
