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
    private Prompt prompt;
    private Player player;
    private ArrayList<NonPlayer> nonPlayers;

    public CharacterManager(Game game) {
        this.game = game;
        prompt = new Prompt();
        player = new Player(game, 100, 100);
        nonPlayers = new ArrayList<NonPlayer>();
        addNonPlayers();
    }

    private void addNonPlayers() {
        try {
            Scanner reader = new Scanner(new File("src/utils/managers/prompts/prompts.txt"));
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(",");
                nonPlayers.add(new NonPlayer(game, 500, 500, player, prompt, data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
