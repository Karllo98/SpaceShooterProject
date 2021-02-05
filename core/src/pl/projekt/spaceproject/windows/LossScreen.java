package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import pl.projekt.spaceproject.SpaceGame;

public class LossScreen extends ParentScreen {

    private Label titleLabel, scoreLabel, pointsLabel, againLabel, exitLabel, modeLabel;
    private Button againButton, exitButton, modeButton;

    public LossScreen(final SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        initTitleLabel();
        initScoreLabel();
        initPointsLabel();
        initAgainLabel();
        initModeLabel();
        initExitLabel();
        initAgainButton();
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
        scoreLabel.setPosition(100, 550);
        scoreLabel.setColor(Color.RED);
        scoreLabel.setFontScale(4);
        stage.addActor(scoreLabel);

        scoreLabel.setText("YOUR SCORE");
    }

    private void initPointsLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        pointsLabel = new Label("", labelStyle);
        pointsLabel.setPosition(275, 450);
        pointsLabel.setColor(Color.RED);
        pointsLabel.setFontScale(4);
        stage.addActor(pointsLabel);
    }

    private void initAgainLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        againLabel = new Label("", labelStyle);
        againLabel.setPosition(175, 300);
        againLabel.setColor(Color.YELLOW);
        againLabel.setFontScale(3);
        stage.addActor(againLabel);

        againLabel.setText("TRY AGAIN");
    }

    private void initModeLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        modeLabel = new Label("", labelStyle);
        modeLabel.setPosition(150, 200);
        modeLabel.setColor(Color.YELLOW);
        modeLabel.setFontScale(3);
        stage.addActor(modeLabel);

        if(game.getMode()){
            modeLabel.setText("ALIENS MODE");
        }
        else modeLabel.setText("METEOR MODE");
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

    private void initAgainButton() {
        againButton = new Button(new ButtonStyle());
        againButton.setSize(225,50);
        againButton.setPosition(175,275);
        againButton.setDebug(false);

        stage.addActor(againButton);

        againButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(game.getMode())
                    game.setScreen(new MeteorScreen(game));
                else game.setScreen(new AlienScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initModeButton() {
        modeButton = new Button(new ButtonStyle());
        modeButton.setSize(300,50);
        modeButton.setPosition(150,175);
        modeButton.setDebug(false);

        stage.addActor(modeButton);

        modeButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setMode(!game.getMode());
                if (game.getMode())
                    game.setScreen(new MeteorScreen(game));
                else game.setScreen(new AlienScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initExitButton() {
        exitButton = new Button(new ButtonStyle());
        exitButton.setSize(100,50);
        exitButton.setPosition(250,75);
        exitButton.setDebug(false);

        stage.addActor(exitButton);

        exitButton.addListener(new ClickListener(){
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