package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;

import utils.Display;
import utils.ImageLoader;

public class Game implements Runnable {

    private Thread thread;
    private boolean running;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    public Game() {
        running = false;
    }

    private void init() {
        display = new Display();
        display.initialize();
        display.getCanvas().createBufferStrategy(3);
        bs = display.getCanvas().getBufferStrategy();
    }

    int x = 0;
    private void update() {
        x += 1;
    }

    private void render() {
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        g.drawRect(x, 50, 100, 100);

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now = 0;
        long lastTime = System.nanoTime();

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            
            if (delta >= 1) {
                update();
                render();
                delta--;
            }
        }

        stop();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
