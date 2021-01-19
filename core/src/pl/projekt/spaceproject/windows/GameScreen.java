package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.controllers.BoostsController;
import pl.projekt.spaceproject.controllers.BulletsController;
import pl.projekt.spaceproject.controllers.MeteorsController;
import pl.projekt.spaceproject.gamecomponents.SpaceShip;

public class GameScreen extends ParentScreen {

    private float counter;
    private SpaceShip ship;
    private Image backgroundImage;
    private MeteorsController meteorsController;
    private BoostsController boostsController;
    private BulletsController bulletsController;

    public GameScreen(SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        initBackground();
        initShip();
        initMeteorsController();
        initBoostController();
    }

    private void bulletMovement() {
        counter += Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && counter > 0.25){
            initBulletController();
            counter = 0;
        }
    }

    private void shipMovement() {
        float leftBoundary = 0;
        float rightBoundary = SpaceGame.WIDTH - ship.getWidth();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && ship.getX() > leftBoundary) {
            ship.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && ship.getX() < rightBoundary) {
            ship.moveRight();
        }
    }

    private void initBulletController() {bulletsController = new BulletsController(game, stage, ship);
    }
    private void initMeteorsController() {
        meteorsController = new MeteorsController(game, stage);
    }

    private void initBoostController() {
        boostsController = new BoostsController(game, stage);
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
        shipMovement();
        bulletMovement();
    }


}
