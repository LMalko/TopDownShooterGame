package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

        private ObjectHandler handler;
        private Camera camera;
        private Game game;

        public MouseInput(ObjectHandler handler, Camera camera, Game game){
                this.handler = handler;
                this.camera = camera;
                this.game = game;
        }
        public void mousePressed (MouseEvent event){
                int mouseX = (int) (event.getX() + camera.getX());
                int mouseY = (int) (event.getY() + camera.getY());

                for(int i = 0; i < handler.objectsCollection.size(); i++){
                        GameObject tempObject = handler.objectsCollection.get(i);

                        if(tempObject.getId() == ID.Player && game.getAmmo() >= 1){
                                handler.addGameObject(new Bullet(tempObject.getX()+ 16, tempObject.getY() + 24, ID.Bullet, handler, mouseX, mouseY));
                                game.reduceAmmo(1);
                        }
                }
        }
}
