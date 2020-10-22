package entities.characters;

import java.awt.Graphics;

import main.Game;
import utils.displayers.Prompt;

public class NonPlayer extends Character {

    private Prompt prompt;

    public NonPlayer(Game game, double x, double y, Prompt prompt) {
        super(game, x, y, DEFAULT_CHARACTER_WIDTH, DEFAULT_CHARACTER_HEIGHT);
        this.prompt = prompt;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
    
}
