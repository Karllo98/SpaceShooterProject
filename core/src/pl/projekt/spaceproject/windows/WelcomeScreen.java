package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.graphics.Texture;
import pl.projekt.spaceproject.SpaceGame;

public class WelcomeScreen extends ParentScreen{

    private Texture welcomeTexture;

    public WelcomeScreen(SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        welcomeTexture = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        spriteBatch.draw(welcomeTexture,0,0);
        spriteBatch.end();
    }
}
