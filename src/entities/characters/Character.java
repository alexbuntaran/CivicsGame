package entities.characters;

import entities.Entity;

public abstract class Character extends Entity {

    protected int health;

    public Character(double x, double y) {
        super(x, y);
        health = 10;
    }

    public int getHealth() {
        return health;
    }
    
}
