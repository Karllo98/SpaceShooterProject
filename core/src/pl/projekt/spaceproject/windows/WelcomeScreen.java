package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import pl.projekt.spaceproject.SpaceGame;

public class WelcomeScreen extends ParentScreen {

    private Texture welcomeTexture;

    public WelcomeScreen(final SpaceGame game) {
        super(game);
        initialize();

        Timer.schedule(new Timer.Task() {

            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, 1); //delay in seconds (1s for debug)
    }

    private void initialize() {
        welcomeTexture = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(welcomeTexture, 0, 0);
        spriteBatch.end();
    }
}
