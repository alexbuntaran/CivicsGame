package entities.characters;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;
import utils.displayers.Prompt;

public class NonPlayer extends Character {

    private Player player;
    private Prompt prompt;
    private String[] data;
    private boolean displayed;

    public NonPlayer(Game game, double x, double y, Player player, Prompt prompt, String[] data) {
        super(game, x, y, DEFAULT_CHARACTER_WIDTH, DEFAULT_CHARACTER_HEIGHT);
        this.player = player;
        this.prompt = prompt;
        this.data = data;
        displayed = false;
    }

    private boolean collision() {
        return player.getX() + player.getWidth() >= this.x &&
               player.getX() <= this.x + this.width &&
               player.getY() + player.getHeight() >= this.y &&
               player.getY() <= this.y + this.height;
    }

    @Override
    public void update() {
        player.canMove = prompt.isClosed();
        if (collision()) {
            if (!displayed) {
                game.getKeyManager().reset();
                prompt.displayFrame(data);
                displayed = true;
            }
        } else {
            displayed = false;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, width, height);
    }
    
}
