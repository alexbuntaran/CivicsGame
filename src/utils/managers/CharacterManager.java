package utils.managers;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entities.characters.NonPlayer;
import entities.characters.Player;
import main.Game;
import utils.Updater;
import utils.displayers.Prompt;
import worlds.World;

public class CharacterManager implements Updater {

    private Game game;
    private Prompt prompt;
    private Player player;
    private ArrayList<NonPlayer> nonPlayers;

    public CharacterManager(Game game, World world) {
        this.game = game;
        player = new Player(game, 100, 100, world);
        prompt = new Prompt(player);
        nonPlayers = new ArrayList<NonPlayer>();
        addNonPlayers();
    }

    private void addNonPlayers() {
        try {
            Scanner reader = new Scanner(new File("src/utils/managers/prompts/prompts.txt"));
            Random rand = new Random();
            int index = 0;
            // TODO: set the current positions of each npc
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(",");
                int x = rand.nextInt(100) + index;
                int y = rand.nextInt(100) + index;
                index += 200;
                nonPlayers.add(new NonPlayer(game, x, y, player, prompt, data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isAlive() {
        return player.getHealth() > 0;
    }

    @Override
    public void update() {
        player.update();
        for (NonPlayer np : nonPlayers) {
            np.update();
        }
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        for (NonPlayer np : nonPlayers) {
            np.render(g);
        }
    }
    
}
