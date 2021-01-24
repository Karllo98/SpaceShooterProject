package pl.projekt.spaceproject;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import pl.projekt.spaceproject.windows.WelcomeScreen;

public class SpaceGame extends Game {

    public final static String TITLE = "Space Invaders - Shooter Project";
    public final static int WIDTH = 600;
    public final static int HEIGHT = 800;
    private boolean paused;
    private int points;

    @Override
    public void create() {
        setScreen(new WelcomeScreen(this));
    }

    public void addPoint(int value) {
        points +=value;
    }

    public void setPaused() {
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public int getPoints() {
        return points;
    }

}
