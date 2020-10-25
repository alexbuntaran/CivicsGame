package utils.managers;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.characters.NonPlayer;
import entities.characters.Player;
import main.Game;
import utils.Updater;
import utils.displayers.Prompt;

public class CharacterManager implements Updater {

    private Game game;
    private Player player;
    private NonPlayer[] nonPlayers;
    private ArrayList<Prompt> prompts;

    public CharacterManager(Game game) {
        this.game = game;
        player = new Player(game, 100, 100);
        prompts = new ArrayList<Prompt>();
        addPrompts();
        addNonPlayers();
    }

    private void addPrompts() {
        try {
            Scanner reader = new Scanner(new File("src/utils/managers/prompts.txt"));
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(",");
                prompts.add(new Prompt(data[0], data[1], data[2], data[3], data[4]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addNonPlayers() {
        nonPlayers = new NonPlayer[prompts.size()];
        for (int i = 0; i < nonPlayers.length; i++) {
            nonPlayers[i] = new NonPlayer(game, 500, 500, prompts.get(i));
        }
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
