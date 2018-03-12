package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

        private ObjectHandler handler;
        private Camera camera;

        public MouseInput(ObjectHandler handler, Camera camera){
                this.handler = handler;
                this.camera = camera;
        }
        public void mousePressed (MouseEvent event){
                int mouseX = (int) (event.getX() + camera.getX());
                int mouseY = (int) (event.getY() + camera.getY());

                for(int i = 0; i < handler.objectsCollection.size(); i++){
                        GameObject tempObject = handler.objectsCollection.get(i);

                        if(tempObject.getId() == ID.Player){
                                handler.addGameObject(new Bullet(tempObject.getX()+ 16, tempObject.getY() + 24, ID.Bullet, handler, mouseX, mouseY));
                        }
                }
        }
}
