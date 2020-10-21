package worlds;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;

import main.Game;
import utils.ImageLoader;

public class World {

    private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    private Game game;
    private BufferedImage background;
    
    public World(Game game) {
        this.game = game;
        background = ImageLoader.loadImage("temp-pics/road.png");
    }

    public void update() {
        
    }

    public void render(Graphics g) {
        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
    }

}
