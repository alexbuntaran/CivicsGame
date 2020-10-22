package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import states.State;
import states.GameState;
import utils.Constants;
import utils.displayers.Display;
import utils.managers.KeyManager;

public class Game implements Runnable {

    private Thread thread;
    private boolean running;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    // private State menuState;
    private State gameState;

    private KeyManager keyManager;

    public Game() {
        display = new Display();
        // menuState = new MenuState(this);
        gameState = new GameState(this);
        keyManager = new KeyManager();
        running = false;
    }

    private void init() {
        display.initialize();
        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().createBufferStrategy(3);
        bs = display.getCanvas().getBufferStrategy();
        State.setState(gameState);
    }

    private void update() {
        keyManager.update();
        State.getState().update();
    }
    
    private void render() {
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        State.getState().render(g);
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

    public KeyManager getKeyManager() {
        return keyManager;
    }

}
