package entities.characters;

import entities.Entity;
import main.Game;

public abstract class Character extends Entity {

    public static final double DEFAULT_SPEED = 3.0;
    public static final int DEFAULT_CHARACTER_WIDTH = 50;
    public static final int DEFAULT_CHARACTER_HEIGHT = 100;
    public static final int DEFAULT_HEALTH = 3;

    protected double speed;
    protected double xMove;
    protected double yMove;
    protected int health;

    public Character(Game game, double x, double y, int width, int height) {
        super(game, x, y, width, height);
        health = DEFAULT_HEALTH;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
}
