package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import pl.projekt.spaceproject.SpaceGame;

public class LossScreen extends ParentScreen {

    private Texture startButtonTexture, exitButtonTexture;
    private Button startButton, exitButton;
    private Label scoreLabel, pointsLabel;

    public LossScreen(final SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        initTextures();
        initButtons();
        initScoreLabel();
        initPointsLabel();
    }

    private void initPointsLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        pointsLabel = new Label("", labelStyle);
        pointsLabel.setPosition(280, 550);
        pointsLabel.setColor(Color.YELLOW);
        pointsLabel.setFontScale(4);
        stage.addActor(pointsLabel);

        pointsLabel.setText(game.getPoints());
    }

    private void initScoreLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        scoreLabel = new Label("", labelStyle);
        scoreLabel.setPosition(100, 700);
        scoreLabel.setColor(Color.YELLOW);
        scoreLabel.setFontScale(4);
        stage.addActor(scoreLabel);

        scoreLabel.setText("YOUR SCORE");
    }

    private void initButtons() {
        initStartButton();
        initExitButton();
    }

    private void initStartButton() {
        startButton = new Button(new ButtonStyle());
        startButton.setSize(200, 50);
        startButton.setPosition(200, 400);
        startButton.setDebug(false);

        stage.addActor(startButton);

        startButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.resetPoints();
                if (game.getMode())
                    game.setScreen(new MeteorScreen(game));
                else game.setScreen(new AlienScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initExitButton() {
        exitButton = new Button(new ButtonStyle());
        exitButton.setSize(200, 50);
        exitButton.setPosition(200, 200);
        exitButton.setDebug(true);

        stage.addActor(exitButton);

        exitButton.addListener(new ClickListener() {
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
