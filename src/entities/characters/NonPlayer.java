package entities.characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.displayers.ImageLoader;
import utils.displayers.Prompt;

public class NonPlayer extends Character {

    private Player player;
    private Prompt prompt;
    private String[] data;
    private boolean displayed;
    private BufferedImage image;
    private boolean isAlive;

    public NonPlayer(Game game, double x, double y, Player player, Prompt prompt, String imagePath) {
        super(game, x, y, DEFAULT_CHARACTER_WIDTH, DEFAULT_CHARACTER_HEIGHT);
        this.player = player;
        this.prompt = prompt;
        displayed = false;
        isAlive = true;
        image = ImageLoader.loadImage(imagePath);
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public void kill() {
        isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    private boolean collision() {
        return player.getX() + player.getWidth() >= this.x &&
               player.getX() <= this.x + this.width &&
               player.getY() + player.getHeight() >= this.y &&
               player.getY() <= this.y + this.height;
    }

    @Override
    public void update() {
        player.setCanMove(prompt.isClosed());
        if (collision()) {
            if (!displayed) {
                game.getKeyManager().reset();
                prompt.displayFrame(data, this);
                displayed = true;
            }

            if (player.getHealth() <= 0) {
                prompt.closeFrame();
            }
        } else {
            displayed = false;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) x, (int) y, width, height, null);
    }
    
}
