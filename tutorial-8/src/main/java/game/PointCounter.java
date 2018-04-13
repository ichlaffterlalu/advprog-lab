package game;

import java.util.Observable;
import java.util.Observer;

public class PointCounter implements Observer {
    public static final double INITIAL_SCORE = 100;
    private double score = INITIAL_SCORE;

    @Override
    public void update(Observable o, Object arg) {
        score -= 1;
    }

    public void correctOnTime() {
        score *= 1.1;
    }

    public void correctLate() {
        score *= 1.05;
    }

    public double getScore() {
        return score;
    }

    public void resetScore() {
        score = INITIAL_SCORE;
    }
}
