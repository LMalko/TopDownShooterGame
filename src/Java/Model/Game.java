package Java.Model;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;

    public void startApp(){
        Window window = new Window(1000, 563, "Wizard game", this);
    }

    @Override
    public void run() {

    }
}
