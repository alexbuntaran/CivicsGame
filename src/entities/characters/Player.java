package entities.characters;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class Player extends Character {

    public Player(Game game, double x, double y) {
        super(game, x, y, DEFAULT_CHARACTER_WIDTH, DEFAULT_CHARACTER_HEIGHT);
    }

    private void getInput() {
        xMove = 0.0;
        yMove = 0.0;

        if (game.getKeyManager().up) {
            yMove = -speed;
        }

        if (game.getKeyManager().down) {
            yMove = speed;
        }

        if (game.getKeyManager().left) {
            xMove = -speed;
        }

        if (game.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void update() {
        getInput();
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int) x, (int) y, width, height);
        g.setColor(Color.RED);
        g.drawRect((int) x + bounds.x, (int) y + bounds.y, width, height);
    }
    
}
