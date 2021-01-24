package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import pl.projekt.spaceproject.SpaceGame;

public class MenuScreen extends ParentScreen{

    private Texture startButtonTexture, exitButtonTexture;
    private Button startButton, exitButton;

    public MenuScreen(final SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        initTextures();
        initButtons();
    }

    private void initButtons() {
        initStartButton();
        initExitButton();
    }

    private void initStartButton() {
        startButton = new Button(new ButtonStyle());
        startButton.setSize(200,50);
        startButton.setPosition(200,400);
        startButton.setDebug(false);

        stage.addActor(startButton);

        startButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initExitButton() {
        exitButton = new Button(new ButtonStyle());
        exitButton.setSize(200,50);
        exitButton.setPosition(200,200);
        exitButton.setDebug(true);

        stage.addActor(exitButton);

        exitButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initTextures() {
        startButtonTexture = new Texture("start.png");
        exitButtonTexture = new Texture("exit.png");
    }

    private void drawTextures() {
        spriteBatch.draw(startButtonTexture, 200, 400, 200, 50);
        spriteBatch.draw(exitButtonTexture, 200, 200, 200, 50);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act();
        spriteBatch.begin();
        drawTextures();
        stage.draw();
        spriteBatch.end();
    }
}
