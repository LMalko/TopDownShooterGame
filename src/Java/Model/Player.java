package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{

        ObjectHandler handler;
        private Game game;
        private BufferedImage[] playerImage = new BufferedImage[3];
        private Animation anim;

        public Player(int x, int y, ID id, ObjectHandler handler, Game game, SpriteSheet spriteSheet) {
                super(x, y, id, spriteSheet);
                this.handler = handler;
                this.game = game;

                playerImage[0] = spriteSheet.grabImage(1,1,32,48);
                playerImage[1] = spriteSheet.grabImage(2,1,32,48);
                playerImage[2] = spriteSheet.grabImage(3,1,32,48);
                anim = new Animation(3, playerImage[0], playerImage[1], playerImage[2]);
        }

        public void tick(){
                x += velocityX;
                y += velocityY;

                collision();

                if(handler.isUp()){
                        velocityY = -5;
                }else if(!handler.isDown()){
                        velocityY = 0;
                }

                if(handler.isDown()){
                        velocityY = 5;
                }else if(!handler.isUp()){
                        velocityY = 0;
                }

                if(handler.isLeft()){
                        velocityX = -5;
                }else if(!handler.isRight()){
                        velocityX = 0;
                }

                if(handler.isRight()){
                        velocityX = 5;
                }else if(!handler.isLeft()){
                        velocityX = 0;
                }

                anim.runAnimation();

        }

        private void collision(){
                for(int i = 0; i < handler.objectsCollection.size(); i++){
                        GameObject tempObject = handler.objectsCollection.get(i);

                        if(tempObject.getId() == ID.Block){

                                if(getBounds().intersects(tempObject.getBounds())){
                                        x += velocityX * -1;
                                        y += velocityY * -1;
                                }
                        }
                        if(tempObject.getId() == ID.Crate){

                                if(getBounds().intersects(tempObject.getBounds())){
                                        game.reduceAmmo(-30);
                                        handler.removeGameObject(tempObject);
                                }
                        }
                        if(tempObject.getId() == ID.Enemy){

                                if(getBounds().intersects(tempObject.getBounds())){
                                        game.reduceHealth((1));
                                }
                        }
                        if(game.getHp() <= 0){
                                System.exit(0);
                        }
                }
        }

        @Override
        public void render(Graphics graphics) {
                if(velocityX == 0 && velocityY == 0){
                        graphics.drawImage(playerImage[0],x,y,null);
                }else{
                        anim.drawAnimation(graphics,x,y,0);
                }

        }

        @Override
        public Rectangle getBounds() {
                return new Rectangle(this.x, this.y,32,48);
        }


}
