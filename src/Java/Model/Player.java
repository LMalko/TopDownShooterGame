package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.*;

public class Player extends GameObject{

        ObjectHandler handler;
        private Game game;

        public Player(int x, int y, ID id, ObjectHandler handler, Game game, SpriteSheet spriteSheet) {
                super(x, y, id, spriteSheet);
                this.handler = handler;
                this.game = game;
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
                }
        }

        @Override
        public void render(Graphics graphics) {
                graphics.setColor(Color.blue);
                graphics.fillRect(this.x, this.y, 32, 48);
        }

        @Override
        public Rectangle getBounds() {
                return new Rectangle(this.x, this.y,32,48);
        }


}
