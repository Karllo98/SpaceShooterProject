package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.controllers.BoostsController;
import pl.projekt.spaceproject.controllers.BulletsController;
import pl.projekt.spaceproject.controllers.MeteorsController;
import pl.projekt.spaceproject.gamecomponents.Boost;
import pl.projekt.spaceproject.gamecomponents.Bullet;
import pl.projekt.spaceproject.gamecomponents.Meteor;
import pl.projekt.spaceproject.gamecomponents.SpaceShip;

public class GameScreen extends ParentScreen {
  
    private SpaceShip ship;
    private Image backgroundImage;
    private float counter;
    private MeteorsController meteorsController;
    private BoostsController boostsController;
    private BulletsController bulletsController;
    private Label pointsLabel;

    public GameScreen(SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        initBackground();
        initShip();
        initMeteorsController();
        initBoostController();
        initPointsLabel();
    }

    private void initPointsLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        pointsLabel = new Label("", labelStyle);
        pointsLabel.setX(20);
        pointsLabel.setY(750);
        stage.addActor(pointsLabel);
    }

    private void boostsCollision() {
        for (int i=0; i < stage.getActors().size; i++){
            Actor actorA = stage.getActors().get(i);
            if (actorA instanceof Bullet) {
                Bullet bullet = (Bullet) actorA;
                for (Actor actorB:stage.getActors()){
                    if (actorB instanceof Boost) {
                        Boost boost  = (Boost) actorB;
                        if(bullet.getBounds().overlaps(boost.getBounds()) && bullet.getBounds().getY() < 800){
                            bullet.remove();
                            boost.remove();
                            game.addPoint();
                        }
                    }
                }
            }
        }
    }

    private void meteorsCollision() {
        for (int i=0; i < stage.getActors().size; i++){
            Actor actorA = stage.getActors().get(i);
            if (actorA instanceof Bullet) {
                Bullet bullet = (Bullet) actorA;
                for (Actor actorB:stage.getActors()){
                    if (actorB instanceof Meteor) {
                        Meteor meteor  = (Meteor) actorB;
                        if(bullet.getBounds().overlaps(meteor.getBounds()) && bullet.getBounds().getY() < 800){
                            bullet.remove();
                            meteor.remove();
                            game.addPoint();
                        }
                    }
                }
            }
        }
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
        pointsLabel.setText("Points: " + game.getPoints());
        shipMovement();
        bulletMovement();
        meteorsCollision();
        boostsCollision();
    }
}
