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
        }, 2);
    }

    private void initialize() {
        welcomeTexture = new Texture("images/welcome.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(welcomeTexture, 0, 0);
        spriteBatch.end();
    }
}