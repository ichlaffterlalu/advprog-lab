package game;

import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

public class Timer extends Observable implements Runnable {
    private static int SLEEP_TIME = 100;
    private AtomicBoolean running = new AtomicBoolean();
    private Thread thread;
    private long startTime;
    private long currentTime;
    private int counter;

    public Timer() {
        this.counter = 0;
        this.currentTime = 0;
    }

    public void mulai() {
        if (thread == null) {
            thread = new Thread(this, "Timer");
            this.startTime = System.currentTimeMillis();
            this.currentTime = startTime;
            counter = (int) (currentTime - startTime) / 1000;
            running.set(true);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
            while (running.get()) {
                Thread.sleep(SLEEP_TIME);
                currentTime = System.currentTimeMillis();
                if ((currentTime - startTime) / 1000 > counter) {
                    counter++;
                    // Tell the observers that counter has changed
                    this.setChanged();
                    notifyObservers();
                }
            }
        } catch (InterruptedException e) {}
    }

    public void stop() {
        running.set(false);
        thread = null;
    }

    public synchronized long getCurrentTime() {
        return currentTime - startTime;
    }

    public synchronized void reset() {
        this.startTime = System.currentTimeMillis();
        this.currentTime = startTime;
    }
}
