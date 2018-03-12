package Java.Model;

import Java.Abstract.GameObject;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ObjectHandler {

        List<GameObject> objectsCollection = new LinkedList<>();

        private boolean up = false;
        private boolean down = false;
        private boolean right = false;
        private boolean left = false;

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

        public List<GameObject> getObjectsCollection() {
                return objectsCollection;
        }

        public void setObjectsCollection(List<GameObject> objectsCollection) {
                this.objectsCollection = objectsCollection;
        }

        public boolean isUp() {
                return up;
        }

        public void setUp(boolean up) {
                this.up = up;
        }

        public boolean isDown() {
                return down;
        }

        public void setDown(boolean down) {
                this.down = down;
        }

        public boolean isRight() {
                return right;
        }

        public void setRight(boolean right) {
                this.right = right;
        }

        public boolean isLeft() {
                return left;
        }

        public void setLeft(boolean left) {
                this.left = left;
        }
}