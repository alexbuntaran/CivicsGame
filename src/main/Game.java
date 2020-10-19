package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Toolkit;

import states.State;
import states.GameState;

import utils.Display;

public class Game implements Runnable {

    private Thread thread;
    private boolean running;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    private State gameState;

    public Game() {
        display = new Display();
        gameState = new GameState();
        running = false;
    }

    private void init() {
        display.initialize();
        display.getCanvas().createBufferStrategy(3);
        bs = display.getCanvas().getBufferStrategy();
        State.setState(gameState);
    }

    private void update() {
        if (State.getState() != null) {
            State.getState().update();
        }
    }

    private void render() {
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        if (State.getState() != null) {
            State.getState().render(g);
        }

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
