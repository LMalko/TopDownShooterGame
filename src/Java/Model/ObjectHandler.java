package Java.Model;

import Java.Abstract.GameObject;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ObjectHandler {

        List<GameObject> objectsCollection = new LinkedList<>();

        public void tick(){
                for (int i = 0; i < objectsCollection.size(); i++){
                        GameObject temporaryObject = objectsCollection.get(i);
                        temporaryObject.tick();
                }
        }

        public void render(Graphics graphics){
                for (int i = 0; i < objectsCollection.size(); i++){
                        GameObject temporaryObject = objectsCollection.get(i);
                        temporaryObject.render(graphics);
                }
        }

        public void addGameObject(GameObject gameObject){
                objectsCollection.add(gameObject);
        }

        public void removeGameObject(GameObject gameObject){
                objectsCollection.remove(gameObject);
        }
}
