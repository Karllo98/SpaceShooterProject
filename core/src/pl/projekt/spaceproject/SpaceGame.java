package pl.projekt.spaceproject;

import com.badlogic.gdx.Game;
import pl.projekt.spaceproject.windows.WelcomeScreen;

public class SpaceGame extends Game {

    public final static String TITLE = "Space Project";
    public final static int WIDTH = 600;
    public final static int HEIGHT = 800;
    private boolean paused;
    private int points;
    private int level = 1;
    private boolean meteorsMode = true;

    @Override
    public void create() {
        setScreen(new WelcomeScreen(this));
    }

    public void addPoint(int value) {
        points += value;
    }

    public void resetPoints() {
        points = 0;
    }

    public void setPaused() {

    }

    public boolean isPaused() {
        return paused;
    }

    public boolean getMode() {
        return meteorsMode;
    }

    public void setMode(boolean meteorsMode) {
        this.meteorsMode = meteorsMode;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public int getPoints() {
        return points;
    }

    public int getLevel() {
        return level;
    }

    public void nextLevel() {
        ++level;
    }

    public void resetLevel() {
        level = 1;
    }
}