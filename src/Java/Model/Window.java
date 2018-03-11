package Java.Model;

public class Window {

    private int width;
    private int height;
    private String title;
    private Game game;

    public Window(int width, int height, String title, Game game) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.game = game;
    }
}
