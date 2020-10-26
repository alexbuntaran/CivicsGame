package worlds;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.Constants;
import utils.Updater;
import utils.displayers.ImageLoader;

public class World implements Updater {

    private Game game;
    private BufferedImage background;
    
    public World(Game game) {
        this.game = game;
        background = ImageLoader.loadImage("images/road.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(background, 0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT, null);
    }

}
