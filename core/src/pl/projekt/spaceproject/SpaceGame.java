package pl.projekt.spaceproject;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceGame extends Game {

	public final static String TITLE = "Space Invaders - Shooter Project";
	public final static int WIDTH = 600;
	public final static int HEIGHT = 800;
	private boolean paused;
	
	@Override
	public void create () {

	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
