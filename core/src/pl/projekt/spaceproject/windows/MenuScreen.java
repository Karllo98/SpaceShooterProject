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

public class MenuScreen extends ParentScreen{

    private Label titleLabel, startLabel, modeLabel, exitLabel, meteorsModeLabel, enemiesModeLabel;
    private Button startButton, modeButton, exitButton, meteorsModeButton, enemiesModeButton;

    public MenuScreen(final SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        initTitleLabel();
        initStartLabel();
        initStartButton();
        initModeLabel();
        initModeButton();
        initExitLabel();
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

    private void initStartLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        startLabel = new Label("", labelStyle);
        startLabel.setPosition(215, 525);
        startLabel.setColor(Color.YELLOW);
        startLabel.setFontScale(4);
        stage.addActor(startLabel);

        startLabel.setText("START");
    }

    private void initModeLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        modeLabel = new Label("", labelStyle);
        modeLabel.setPosition(225, 375);
        modeLabel.setColor(Color.YELLOW);
        modeLabel.setFontScale(4);
        stage.addActor(modeLabel);

        modeLabel.setText("MODE");
    }

    private void initExitLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        exitLabel = new Label("", labelStyle);
        exitLabel.setPosition(250, 225);
        exitLabel.setColor(Color.YELLOW);
        exitLabel.setFontScale(4);
        stage.addActor(exitLabel);

        exitLabel.setText("EXIT");
    }

    private void initStartButton() {
        startButton = new Button(new ButtonStyle());
        startButton.setSize(150,50);
        startButton.setPosition(225,500);
        startButton.setDebug(false);

        stage.addActor(startButton);

        startButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(game.getMode()){
                    game.setScreen(new MeteorScreen(game));
                }
                else game.setScreen(new AlienScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initModeButton() {
        modeButton = new Button(new ButtonStyle());
        modeButton.setSize(150,50);
        modeButton.setPosition(225,350);
        modeButton.setDebug(false);

        stage.addActor(modeButton);

        modeButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                initMeteorsModeLabel();
                initMeteorsModeButton();
                initEnemiesModeLabel();
                initEnemiesModeButton();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initMeteorsModeLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        meteorsModeLabel = new Label("", labelStyle);
        meteorsModeLabel.setPosition(50, 300);
        meteorsModeLabel.setColor(Color.RED);
        meteorsModeLabel.setFontScale(3);
        stage.addActor(meteorsModeLabel);

        meteorsModeLabel.setText("METEORS");

    }

    private void initMeteorsModeButton() {
        meteorsModeButton = new Button(new ButtonStyle());
        meteorsModeButton.setSize(200,50);
        meteorsModeButton.setPosition(50,275);
        meteorsModeButton.setDebug(false);

        stage.addActor(meteorsModeButton);

        meteorsModeButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setMode(true);
                meteorsModeLabel.setColor(Color.RED);
                enemiesModeLabel.setColor(Color.YELLOW);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initEnemiesModeLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        enemiesModeLabel = new Label("", labelStyle);
        enemiesModeLabel.setPosition(400, 300);
        enemiesModeLabel.setColor(Color.YELLOW);
        enemiesModeLabel.setFontScale(3);
        stage.addActor(enemiesModeLabel);

        enemiesModeLabel.setText("ALIENS");
    }

    private void initEnemiesModeButton() {
        enemiesModeButton = new Button(new ButtonStyle());
        enemiesModeButton.setSize(150,50);
        enemiesModeButton.setPosition(400,275);
        enemiesModeButton.setDebug(false);

        stage.addActor(enemiesModeButton);

        enemiesModeButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setMode(false);
                meteorsModeLabel.setColor(Color.YELLOW);
                enemiesModeLabel.setColor(Color.RED);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void initExitButton() {
        exitButton = new Button(new ButtonStyle());
        exitButton.setSize(150,50);
        exitButton.setPosition(225,200);
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
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }
}
