package entities.characters;

import entities.Entity;
import main.Game;

public abstract class Character extends Entity {

    public static final double DEFAULT_SPEED = 3.0;
    public static final int DEFAULT_CHARACTER_WIDTH = 50;
    public static final int DEFAULT_CHARACTER_HEIGHT = 50;

    protected double speed;
    protected double xMove;
    protected double yMove;

    public Character(Game game, double x, double y, int width, int height) {
        super(game, x, y, width, height);
        speed = DEFAULT_SPEED;
        xMove = 0.0;
        yMove = 0.0;
    }

    public void move() {
        x += xMove;
        y += yMove;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
}
