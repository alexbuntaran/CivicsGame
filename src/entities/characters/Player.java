package entities.characters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.Game;
import utils.Constants;
import utils.Line;
import utils.displayers.ImageLoader;
import worlds.World;

public class Player extends Character {

    private World world;
    private int score;
    private BufferedImage image;
    private int centerX;
    private int centerY;
    private boolean canMove;
    private boolean won;

    public Player(Game game, double x, double y, World world) {
        super(game, x, y, DEFAULT_CHARACTER_WIDTH, DEFAULT_CHARACTER_HEIGHT);
        canMove = true;
        score = 0;
        image = ImageLoader.loadImage("images/mc.png");
        this.world = world;
        centerX = 0;
        centerY = 0;
        won = false;
    }

    private void getInput() {
        xMove = 0.0;
        yMove = 0.0;

        if (game.getKeyManager().up) {
            yMove = upSpeed;
        }

        if (game.getKeyManager().down) {
            yMove = downSpeed;
        }

        if (game.getKeyManager().left) {
            xMove = leftSpeed;
        }

        if (game.getKeyManager().right) {
            xMove = rightSpeed;
        }
    }

    private void updatePose() {
        centerX = ((int) x + (int) x + width) / 2;
        centerY = ((int) y + (int) y + height) / 2;
    }

    private void checkBounds() {
        for (Line line : world.getLines()) {
            if (line.getX1() < centerX) {
                if (x <= line.getX1() && y + height >= line.getY0() && y <= line.getY1()) {
                    line.setCollision(Line.LEFT, true);
                } else {
                    line.setCollision(Line.LEFT, false);
                }
            }

            if (line.getX0() > centerX) {
                if (x + width >= line.getX0() && y + height >= line.getY0() && y <= line.getY1()) {
                    line.setCollision(Line.RIGHT, true);
                } else {
                    line.setCollision(Line.RIGHT, false);
                }
            }

            if (line.getY1() < centerY) {
                if (y <= line.getY1() && x + width >= line.getX0() && x <= line.getX1()) {
                    line.setCollision(Line.UP, true);
                } else {
                    line.setCollision(Line.UP, false);
                }
            }

            if (line.getY0() > centerY) {
                if (y + height >= line.getY0() && x + width >= line.getX0() && x <= line.getX1()) {
                    line.setCollision(Line.DOWN, true);
                } else {
                    line.setCollision(Line.DOWN, false);
                }
            }
        }

        upSpeed = -DEFAULT_SPEED;
        downSpeed = DEFAULT_SPEED;
        leftSpeed = -DEFAULT_SPEED;
        rightSpeed = DEFAULT_SPEED;

        for (Line line : world.getLines()) {
            if (line.getCollision(Line.UP)) {
                upSpeed = 0;
            }

            if (line.getCollision(Line.DOWN)) {
                downSpeed = 0;
            }

            if (line.getCollision(Line.LEFT)) {
                leftSpeed = 0;
            }

            if (line.getCollision(Line.RIGHT)) {
                rightSpeed = 0;
            }
        }

        if (score >= progressWidth) {
            world.setExitStatus(Color.GREEN);
            if (world.getLines().get(world.getLines().size() - 1).getCollision(Line.RIGHT)) {
                won = true;
            }
        }
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void correct() {
        if (score < progressWidth) {
            score += 40;
        }
    }

    public void incorrect() {
        health--;
    }

    public boolean won() {
        return won;
    }

    @Override
    public void update() {
        if (canMove) {
            getInput();
            move();
            updatePose();
            checkBounds();
        }
    }

    final int progressWidth = 600;
    final int progressHeight = 30;
    final int healthWidth = 30;
    final int healthHeight = 30;

    @Override
    public void render(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(3));

        g.setColor(Color.BLACK);
        g.drawRect(10, 10, progressWidth, progressHeight);
        g.setColor(Color.GREEN);
        g.fillRect(10, 10, score, progressHeight);

        g.setColor(Color.BLACK);
        g.drawRect(Constants.FRAME_WIDTH - healthWidth - 210, 10, healthWidth, healthHeight);
        g.drawRect(Constants.FRAME_WIDTH - healthWidth - 110, 10, healthWidth, healthHeight);
        g.drawRect(Constants.FRAME_WIDTH - healthWidth - 10, 10, healthWidth, healthHeight);
        g.setColor(Color.RED);
        g.fillRect(Constants.FRAME_WIDTH - healthWidth - 210, 10, health >= 1 ? healthWidth : 0, healthHeight);
        g.fillRect(Constants.FRAME_WIDTH - healthWidth - 110, 10, health >= 2 ? healthWidth : 0, healthHeight);
        g.fillRect(Constants.FRAME_WIDTH - healthWidth - 10, 10, health >= 3 ? healthWidth : 0, healthHeight);

        g.drawImage(image, (int) x, (int) y, width, height, null);
    }
    
}
