package main;

import utils.Display;

public class Game implements Runnable {

    private Display display;
    private Thread thread;
    private boolean running;

    public Game() {
        running = false;
    }

    private void init() {
        display = new Display();
        display.initialize();
    }

    private void update() {
        System.out.println("updating");
    }

    private void render() {
        System.out.println();
    }

    @Override
    public void run() {
        init();
        while (running) {
            update();
            render();
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
