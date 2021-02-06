package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import pl.projekt.spaceproject.SpaceGame;

public class WinScreen extends ParentScreen {

    private Label titleLabel, scoreLabel, pointsLabel, nextLabel, exitLabel, modeLabel;
    private Button nextButton, exitButton, modeButton;
    private Sound lossSound = Gdx.audio.newSound(Gdx.files.internal("sounds/win.mp3"));

    public WinScreen(final SpaceGame game) {
        super(game);
        initialize();
        lossSound.play(0.5f);
    }

    private void initialize() {
        initTitleLabel();
        initScoreLabel();
        initPointsLabel();
        initNextLabel();
        initModeLabel();
        initExitLabel();
        initNextButton();
        initModeButton();
        initExitButton();
    }

    private void initTitleLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        titleLabel = new Label("", labelStyle);
        titleLabel.setPosition(50, 700);
        titleLabel.setColor(Color.YELLOW);
        titleLabel.setFontScale(4);
        stage.addActor(titleLabel);

        titleLabel.setText("SPACE PROJECT");
    }

    private void initScoreLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        scoreLabel = new Label("", labelStyle);
        scoreLabel.setPosition(150, 550);
        scoreLabel.setColor(Color.BLUE);
        scoreLabel.setFontScale(4);
        stage.addActor(scoreLabel);

        scoreLabel.setText("YOU WON!");
    }

    private void initPointsLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        pointsLabel = new Label("", labelStyle);
        pointsLabel.setPosition(275, 450);
        pointsLabel.setColor(Color.BLUE);
        pointsLabel.setFontScale(4);
        stage.addActor(pointsLabel);
    }

    private void initNextLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        nextLabel = new Label("", labelStyle);
        nextLabel.setPosition(175, 300);
        nextLabel.setColor(Color.YELLOW);
        nextLabel.setFontScale(3);
        stage.addActor(nextLabel);

        nextLabel.setText("NEXT LEVEL");
    }

    private void initModeLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        modeLabel = new Label("", labelStyle);
        modeLabel.setPosition(150, 200);
        modeLabel.setColor(Color.YELLOW);
        modeLabel.setFontScale(3);
        stage.addActor(modeLabel);

        if (game.getMode()) {
            modeLabel.setText("ALIENS MODE");
        } else modeLabel.setText("METEOR MODE");
    }

    private void initExitLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        exitLabel = new Label("", labelStyle);
        exitLabel.setPosition(250, 100);
        exitLabel.setColor(Color.YELLOW);
        exitLabel.setFontScale(3);
        stage.addActor(exitLabel);

        exitLabel.setText("EXIT");
    }

    private void initNextButton() {
        nextButton = new Button(new ButtonStyle());
        nextButton.setSize(250, 50);
        nextButton.setPosition(175, 275);
        nextButton.setDebug(false);

        stage.addActor(nextButton);

        nextButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.nextLevel();
                if (game.getMode())
                    game.setScreen(new MeteorScreen(game));
                else game.setScreen(new AlienScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initModeButton() {
        modeButton = new Button(new ButtonStyle());
        modeButton.setSize(300, 50);
        modeButton.setPosition(150, 175);
        modeButton.setDebug(false);

        stage.addActor(modeButton);

        modeButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setMode(!game.getMode());
                game.resetPoints();
                game.resetLevel();
                if (game.getMode())
                    game.setScreen(new MeteorScreen(game));
                else game.setScreen(new AlienScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initExitButton() {
        exitButton = new Button(new ButtonStyle());
        exitButton.setSize(100, 50);
        exitButton.setPosition(250, 75);
        exitButton.setDebug(false);

        stage.addActor(exitButton);

        exitButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act();
        pointsLabel.setText(game.getPoints());
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }
}