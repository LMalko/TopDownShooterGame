package Java.Model;

import javax.swing.*;
import java.awt.*;

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

        JFrame frame = new JFrame(this.title);
        frame.setPreferredSize(new Dimension(this.width, this.height));
        frame.setMaximumSize(new Dimension(this.width, this.height));
        frame.setMinimumSize(new Dimension(this.width, this.height));
    }
}
