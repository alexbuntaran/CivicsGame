package states;

import java.awt.Font;
import java.awt.Graphics;

import main.Game;
import utils.Constants;

public class EndState extends State {

    private String message;
    private boolean won;

    public EndState(Game game) {
        super(game);
        message = "";
        won = false;
    }

    @Override
    public void update() {
        message = won ? "You Won" : "Game Over";
    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font("", Font.PLAIN, 100));
        g.drawString(message, Constants.FRAME_WIDTH / 2 - 250, Constants.FRAME_HEIGHT / 2);
    }
    
}
