package Java.Model;

import Java.Enums.ID;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;

    private boolean isRunning = false;
    private Thread thread;
    private ObjectHandler objectHandler;
    private Window window;
    private Camera camera;

    private BufferedImage image = null;

    public void startApp(){
        window = new Window(1000, 563, "Player Shooter", this);
        start();
        objectHandler = new ObjectHandler();
        camera = new Camera(0, 0);
        this.addKeyListener(new KeyInput(objectHandler));

        BufferedImageLoader loader = new BufferedImageLoader();
        this.image = loader.loadImage("res/World.png");

        loadLevel(this.image);

    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                //updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                //updates = 0;
            }
        }
        stop();
    }

    public void tick(){
        /* Update everything in the game. */

        for(int i = 0; i < objectHandler.objectsCollection.size(); i++){
                if(objectHandler.objectsCollection.get(i).getId() == ID.Player){
                        camera.tick(objectHandler.objectsCollection.get(i));
                }
        }
        objectHandler.tick();
    }

    public void render(){
//        Render everything in the game.
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if(bufferStrategy == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        Graphics2D graphics2d = (Graphics2D) graphics;

        graphics.setColor(Color.red);
        graphics.fillRect(0, 0, 1000, 563);

        graphics2d.translate(-camera.getX(), -camera.getY());

        objectHandler.render(graphics);

        graphics2d.translate(camera.getX(), camera.getY());

        graphics.dispose();
        bufferStrategy.show();
    }

    private void loadLevel(BufferedImage image){
            int width = image.getWidth();
            int height = image.getHeight();

            for(int xx = 0; xx < width; xx++){
                    for(int yy = 0; yy < height; yy++){
                            int pixel = image.getRGB(xx, yy);
                            int red = (pixel >> 16) & 0xff;
                            int green = (pixel >> 8) & 0xff;
                            int blue = (pixel) & 0xff;

                            if (red == 255){
                                    objectHandler.addGameObject(new Block(xx*32, yy*32, ID.Block));
                            }
                            if (blue == 255){
                                    objectHandler.addGameObject(new Player(xx*32, yy*32, ID.Player, objectHandler));
                            }
                    }
            }
    }

    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
