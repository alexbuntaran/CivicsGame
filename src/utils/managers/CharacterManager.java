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
import utils.Constants;
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
        player = new Player(game, 50, Constants.FRAME_HEIGHT - 215, world);
        prompt = new Prompt(player);
        nonPlayers = new ArrayList<NonPlayer>();
        addNonPlayers();
    }

    private void addNonPlayers() {
        try {
            Scanner reader = new Scanner(new File("src/utils/managers/prompts/prompts.txt"));
            ArrayList<String[]> datas = new ArrayList<String[]>();
            while (reader.hasNextLine()) {
                datas.add(reader.nextLine().split(","));
            }

            nonPlayers.add(new NonPlayer(game, 270, 100, player, prompt, "images/npc1.png"));
            nonPlayers.add(new NonPlayer(game, 400, 100, player, prompt, "images/npc2.png"));
            nonPlayers.add(new NonPlayer(game, 400, 250, player, prompt, "images/npc3.png"));
            nonPlayers.add(new NonPlayer(game, 550, 250, player, prompt, "images/npc4.png"));
            nonPlayers.add(new NonPlayer(game, 700, 400, player, prompt, "images/npc5.png"));
            nonPlayers.add(new NonPlayer(game, 1225, 400, player, prompt, "images/npc1.png"));
            nonPlayers.add(new NonPlayer(game, 1225, 550, player, prompt, "images/npc2.png"));
            nonPlayers.add(new NonPlayer(game, 700, 550, player, prompt, "images/npc3.png"));
            nonPlayers.add(new NonPlayer(game, 600, 400, player, prompt, "images/npc4.png"));
            nonPlayers.add(new NonPlayer(game, 1225, 700, player, prompt, "images/npc5.png"));
            nonPlayers.add(new NonPlayer(game, 375, 400, player, prompt, "images/npc1.png"));
            nonPlayers.add(new NonPlayer(game, 400, 700, player, prompt, "images/npc2.png"));
            nonPlayers.add(new NonPlayer(game, 800, 100, player, prompt, "images/npc3.png"));
            nonPlayers.add(new NonPlayer(game, 850, 250, player, prompt, "images/npc4.png"));
            nonPlayers.add(new NonPlayer(game, 1215, 150, player, prompt, "images/npc5.png"));

            Random rand = new Random();
            for (NonPlayer np : nonPlayers) {
                int index = rand.nextInt(datas.size());
                np.setData(datas.get(index));
                datas.remove(index);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isAlive() {
        return player.getHealth() > 0;
    }

    public boolean won() {
        return player.won();
    }

    @Override
    public void update() {
        player.update();
        for (int i = 0; i < nonPlayers.size(); i++) {
            if (nonPlayers.get(i).isAlive()) {
                nonPlayers.get(i).update();
            } else {
                nonPlayers.remove(i);
                player.setCanMove(true);
            }
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
