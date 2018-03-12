package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

        private ObjectHandler handler;
        private Camera camera;
        private Game game;
        private SpriteSheet spriteSheet;

        MouseInput(ObjectHandler handler, Camera camera, Game game, SpriteSheet spriteSheet){
                this.handler = handler;
                this.camera = camera;
                this.game = game;
                this.spriteSheet = spriteSheet;

        }
        public void mousePressed (MouseEvent event){
                int mouseX = (int) (event.getX() + camera.getX());
                int mouseY = (int) (event.getY() + camera.getY());

                for(int i = 0; i < handler.objectsCollection.size(); i++){
                        GameObject tempObj = handler.objectsCollection.get(i);

                        if(tempObj.getId() == ID.Player && game.getAmmo() >= 1){
                                handler.addGameObject(new Bullet(tempObj.getX()+ 16, tempObj.getY() + 24, ID.Bullet, handler, mouseX, mouseY, this.spriteSheet ));
                                game.reduceAmmo(1);
                        }
                }
        }
}
