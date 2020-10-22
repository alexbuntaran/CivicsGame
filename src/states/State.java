package states;

import main.Game;
import utils.Updater;

public abstract class State implements Updater {

    private static State currentState;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    protected Game game;

    public State(Game game) {
        this.game = game;
    }
    
}
