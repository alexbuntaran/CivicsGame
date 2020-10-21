package states;

import java.awt.Graphics;

import entities.characters.Player;
import main.Game;
import worlds.World;

public class GameState extends State {

    private World world;
    private Player player;

    public GameState(Game game) {
        super(game);
        world = new World(game);
        player = new Player(game, 100, 100);
    }

    @Override
    public void update() {
        world.update();
        player.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
    
}
