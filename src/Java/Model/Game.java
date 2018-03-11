package Java.Model;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

    public void startApp(){
        Window window = new Window(1000, 563, "Wizard game", this);
    }

    @Override
    public void run() {

    }
}
