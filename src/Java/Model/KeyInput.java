package Java.Model;

import Java.Abstract.GameObject;
import Java.Enums.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

        ObjectHandler handler;

        public KeyInput(ObjectHandler handler) {
                this.handler = handler;
        }

        public void keyPressed(KeyEvent keyEvent){

                int key = keyEvent.getKeyCode();

                for (int i = 0; i < handler.objectsCollection.size(); i++){
                        GameObject tempObject = handler.objectsCollection.get(i);
                        if (tempObject.getId() == ID.Player){
                                switch (key){
                                        case KeyEvent.VK_W:
                                                handler.setUp(true);
                                                break;
                                        case KeyEvent.VK_S:
                                                handler.setDown(true);
                                                break;
                                        case KeyEvent.VK_A:
                                                handler.setLeft(true);
                                                break;
                                        case KeyEvent.VK_D:
                                                handler.setRight(true);
                                                break;
                                }
                        }
                }

        }
        public void keyReleased(KeyEvent keyEvent){

                int key = keyEvent.getKeyCode();

                for (int i = 0; i < handler.objectsCollection.size(); i++){
                        GameObject tempObject = handler.objectsCollection.get(i);
                        if (tempObject.getId() == ID.Player) {
                                switch (key) {
                                        case KeyEvent.VK_W:
                                                handler.setUp(false);
                                                break;
                                        case KeyEvent.VK_S:
                                                handler.setDown(false);
                                                break;
                                        case KeyEvent.VK_A:
                                                handler.setLeft(false);
                                                break;
                                        case KeyEvent.VK_D:
                                                handler.setRight(false);
                                                break;
                                        }
                        }
                }
        }

}
