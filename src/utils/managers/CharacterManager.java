package utils.managers;

import entities.characters.NonPlayer;
import entities.characters.Player;
import main.Game;
import utils.Constants;

public class CharacterManager {

    private Player player;
    private NonPlayer[] nonPlayers;

    public CharacterManager(Game game) {
        player = new Player(game, 100, 100);
        nonPlayers = new NonPlayer[Constants.NON_PLAYERS_AMOUNT];
    }

    private void addNonPlayers() {
        
    }
    
}
