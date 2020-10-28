package entities.characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.displayers.ImageLoader;

public class Player extends Character {

    protected boolean canMove;

    private int score;

    private BufferedImage image;

    public Player(Game game, double x, double y) {
        super(game, x, y, DEFAULT_CHARACTER_WIDTH, DEFAULT_CHARACTER_HEIGHT);
        canMove = true;
        score = 0;
        image = ImageLoader.loadImage("images/mc.png");
    }

    private void getInput() {
        xMove = 0.0;
        yMove = 0.0;

        if (game.getKeyManager().up) {
            yMove = -speed;
        }

        if (game.getKeyManager().down) {
            yMove = speed;
        }

        if (game.getKeyManager().left) {
            xMove = -speed;
        }

        if (game.getKeyManager().right) {
            xMove = speed;
        }
    }

    public void correct() {
        score += 150;
    }

    public void incorrect() {
        health--;
    }

    @Override
    public void update() {
        if (canMove) {
            getInput();
            move();
        }
    }

    final int startX = 5;
    final int startY = 5;
    final int progressWidth = 600;
    final int progressHeight = 30;
    final int healthWidth = 30;
    final int healthHeight = 30;

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(startX, startY, progressWidth, progressHeight);
        g.setColor(Color.GREEN);
        g.fillRect(startX, startY, score, progressHeight);

        g.setColor(Color.BLACK);
        g.drawRect(startX + progressWidth + 500, startY, healthWidth, healthHeight);
        g.drawRect(startX + progressWidth + 600, startY, healthWidth, healthHeight);
        g.drawRect(startX + progressWidth + 700, startY, healthWidth, healthHeight);
        g.setColor(Color.RED);
        g.fillRect(startX + progressWidth + 500, startY, health >= 1 ? healthWidth : 0, healthHeight);
        g.fillRect(startX + progressWidth + 600, startY, health >= 2 ? healthWidth : 0, healthHeight);
        g.fillRect(startX + progressWidth + 700, startY, health >= 3 ? healthWidth : 0, healthHeight);

        g.drawImage(image, (int) x, (int) y, width, height, null);
    }
    
}
