package worlds;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import utils.Constants;
import utils.Line;
import utils.Updater;
import utils.displayers.ImageLoader;

public class World implements Updater {

    private BufferedImage image;
    private ArrayList<Line> lines;
    private Line exit;
    private Color status;
    
    public World() {
        image = ImageLoader.loadImage("images/map.png");
        exit = new Line(Constants.FRAME_WIDTH - 50, 100, Constants.FRAME_WIDTH - 50, 100 + space);
        status = Color.RED;
        lines = new ArrayList<Line>();
        addLines();
    }

    final int space = 150;

    private void addLines() {
        lines.add(new Line(50, Constants.FRAME_HEIGHT - 100, Constants.FRAME_WIDTH - 50, Constants.FRAME_HEIGHT - 100));
        lines.add(new Line(50, 100, Constants.FRAME_WIDTH - 50, 100));
        lines.add(new Line(50, 100, 50, Constants.FRAME_HEIGHT - 100 - space));
        lines.add(new Line(Constants.FRAME_WIDTH - 50, 100 + space, Constants.FRAME_WIDTH - 50, Constants.FRAME_HEIGHT - 100));
        lines.add(new Line(50 + Constants.FRAME_WIDTH / 3, Constants.FRAME_HEIGHT - 100 - space * 2, 50 + Constants.FRAME_WIDTH / 3, Constants.FRAME_HEIGHT - 100));
        lines.add(new Line(50 + space, Constants.FRAME_HEIGHT - 100 - space, 50 + Constants.FRAME_WIDTH / 3, Constants.FRAME_HEIGHT - 100 - space));
        lines.add(new Line(50 + space, Constants.FRAME_HEIGHT - 100 - space * 2, 50 + space, Constants.FRAME_HEIGHT - 100 - space));
        lines.add(new Line(50 + space, Constants.FRAME_HEIGHT - 100 - space * 3, 50 + Constants.FRAME_WIDTH / 3 * 2, Constants.FRAME_HEIGHT - 100 - space * 3));
        lines.add(new Line(50 + space, Constants.FRAME_HEIGHT - 100 - space * 4, 50 + Constants.FRAME_WIDTH / 3 * 2, Constants.FRAME_HEIGHT - 100 - space * 4));
        lines.add(new Line(50 + space * 2, Constants.FRAME_HEIGHT - 100 - space * 3, 50 + space * 2, Constants.FRAME_HEIGHT - 100 - space * 2));
        lines.add(new Line(50 + space * 2, 100, 50 + space * 2, 57 + space));
        lines.add(new Line(50 + Constants.FRAME_WIDTH / 3 + space, Constants.FRAME_HEIGHT - 100 - space * 3, 50 + Constants.FRAME_WIDTH / 3 + space, Constants.FRAME_HEIGHT - 100 - space));
        lines.add(new Line(50 + Constants.FRAME_WIDTH / 3 + space, Constants.FRAME_HEIGHT - 100 - space * 2, Constants.FRAME_WIDTH - 50 - space, Constants.FRAME_HEIGHT - 100 - space * 2));
        lines.add(new Line(50 + Constants.FRAME_WIDTH / 3 * 2, Constants.FRAME_HEIGHT - 100 - space, Constants.FRAME_WIDTH - 50, Constants.FRAME_HEIGHT - 100 - space));
        lines.add(new Line(50 + Constants.FRAME_WIDTH / 3 + space * 2, Constants.FRAME_HEIGHT - 100 - space, 50 + Constants.FRAME_WIDTH / 3 + space * 2, Constants.FRAME_HEIGHT - 100));
        lines.add(new Line(Constants.FRAME_WIDTH - 50 - space, Constants.FRAME_HEIGHT - 100 - space * 3, Constants.FRAME_WIDTH - 50, Constants.FRAME_HEIGHT - 100 - space * 3));
        lines.add(new Line(Constants.FRAME_WIDTH - 50 - space, 100, Constants.FRAME_WIDTH - 50 - space, 100 + space));
        lines.add(new Line(50 + Constants.FRAME_WIDTH / 3, Constants.FRAME_HEIGHT - 100 - space * 4, 50 + Constants.FRAME_WIDTH / 3, Constants.FRAME_HEIGHT - 100 - space * 3));
        lines.add(exit);
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setExitStatus(Color status) {
        this.status = status;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, 0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT, null);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g.setColor(Color.BLACK);
        for (Line line : lines) {
            g.drawLine(line.getX0(), line.getY0(), line.getX1(), line.getY1());
        }

        g.setColor(status);
        g.drawLine(exit.getX0(), exit.getY0(), exit.getX1(), exit.getY1());
    }

}
