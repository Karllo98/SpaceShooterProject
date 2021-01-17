package pl.projekt.spaceproject.windows;

import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.SpaceShip;

public class GameScreen extends ParentScreen {

    private SpaceShip ship;

    public GameScreen(SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        initShip();
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
