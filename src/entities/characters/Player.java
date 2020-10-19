package entities.characters;

import java.awt.Graphics;

public class Player extends Character {

    public Player(double x, double y) {
        super(x, y);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawRect((int) x, (int) y, 100, 100);
    }
    
}
