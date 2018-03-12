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
    private SpriteSheet spriteSheet;
    private BufferedImage floor = null;


    private BufferedImage image = null;
    private BufferedImage bufferedImage= null;

    private int ammo = 30;

    public static Game getGame() {
                return new Game();
    }

        public int getAmmo() {
                return ammo;
        }

        public void startApp(){
        window = new Window(1020, 600, "Player Shooter", this);
        start();
        objectHandler = new ObjectHandler();
        camera = new Camera(0, 0);

        this.addKeyListener(new KeyInput(objectHandler));


        BufferedImageLoader loader = new BufferedImageLoader();
        this.image = loader.loadImage("res/World.png");
        this.bufferedImage = loader.loadImage("res/Sprites.png");

        this.spriteSheet = new SpriteSheet(this.bufferedImage);

        floor = this.spriteSheet.grabImage(4,2, 32, 32);

        this.addMouseListener((new MouseInput(objectHandler, camera, this, this.spriteSheet)));

        loadLevel(this.image);

    }

    public void reduceAmmo(int difference){
            this.ammo -= difference;
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

        graphics2d.translate(-camera.getX(), -camera.getY());

        for(int xx = 0; xx < 30 * 72; xx += 32){
                for(int yy = 0; yy < 30 *72; yy += 32){
                        graphics.drawImage(floor, xx, yy, null);
                }
        }

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
                                    objectHandler.addGameObject(new Block(xx*32, yy*32, ID.Block, this.spriteSheet));
                            }
                            if (blue == 255 && green == 0){
                                    objectHandler.addGameObject(new Player(xx*32, yy*32, ID.Player, objectHandler, this, this.spriteSheet));
                            }
                            if (green == 255 && blue == 0){
                                    objectHandler.addGameObject(new Enemy(xx*32, yy*32, ID.Enemy, objectHandler, this.spriteSheet));
                            }
                            if (blue == 255 && green == 255){
                                    objectHandler.addGameObject(new Crate(xx*32, yy*32, ID.Crate, this.spriteSheet));
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
