package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.Meteor;
import pl.projekt.spaceproject.gamecomponents.SpaceShip;

public class GameScreen extends ParentScreen {

    private SpaceShip ship;
    private Image backgroundImage;
    private Meteor meteor; //temporary

    public GameScreen(SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        initBackground();
        initShip();
        initMeteors();
    }

    private void initMeteors() {
        meteor = new Meteor();
        stage.addActor(meteor);
        meteor.fall();
    }

    private void initBackground() {
        backgroundImage = new Image(new Texture("background.jpg"));
        stage.addActor(backgroundImage);
    }

    private void initShip() {
        ship = new SpaceShip();
        stage.addActor(ship);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        stage.act();
    }
}
