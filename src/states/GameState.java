package states;

import java.awt.Graphics;

public class GameState extends State {

    public GameState() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawRect(10, 10, 100, 100);
    }
    
}
