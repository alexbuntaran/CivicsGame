package entities.characters;

import entities.Entity;
import main.Game;

public abstract class Character extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final double DEFAULT_SPEED = 3.0;
    public static final int DEFAULT_CHARACTER_WIDTH = 50;
    public static final int DEFAULT_CHARACTER_HEIGHT = 50;

    protected int health;
    protected double speed;
    protected double xMove;
    protected double yMove;

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

    // public boolean collision() {

    // }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
}
