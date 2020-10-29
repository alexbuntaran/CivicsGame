package states;

import java.awt.Graphics;

import main.Game;
import utils.managers.CharacterManager;
import worlds.World;

public class GameState extends State {

    private World world;
    private CharacterManager cm;

    public GameState(Game game) {
        super(game);
        world = new World();
        cm = new CharacterManager(game, world);
    }

    @Override
    public void update() {
        world.update();
        cm.update();
        if (!cm.isAlive()) {
            State.setState(new EndState(game, cm.won()));
        } else if (cm.won()) {
            State.setState(new EndState(game, cm.won()));
        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        cm.render(g);
    }
    
}
