package worlds;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Game;
import utils.Constants;
import utils.Line;
import utils.Updater;
import utils.Line.Side;
import utils.displayers.ImageLoader;

public class World implements Updater {

    private Game game;
    private BufferedImage map;
    private ArrayList<Line> lines;
    
    public World(Game game) {
        this.game = game;
        map = ImageLoader.loadImage("images/map.png");
        lines = new ArrayList<Line>();
        addLines();
    }

    private void addLines() {
        lines.add(new Line(100, 100, 500, 100, Side.UP));
        lines.add(new Line(100, 100, 100, 500, Side.LEFT));
        lines.add(new Line(100, 500, 500, 500, Side.DOWN));
        lines.add(new Line(500, 100, 500, 500, Side.RIGHT));
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(map, 0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT, null);
        for (Line line : lines) {
            g.drawLine(line.getX0(), line.getY0(), line.getX1(), line.getY1());
        }
    }

}
