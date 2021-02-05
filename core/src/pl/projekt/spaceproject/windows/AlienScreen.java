package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.controllers.AliensController;
import pl.projekt.spaceproject.controllers.BulletsController;
import pl.projekt.spaceproject.gamecomponents.*;

public class AlienScreen extends ParentScreen{

    private SpaceShip ship;
    private Image backgroundImage;
    private float shipBulletCounter;
    private float alienBulletCounter;
    private BulletsController bulletsController;
    private AliensController aliensController;
    private Label pointsLabel, healthLabel;

    public AlienScreen(SpaceGame game) {
        super(game);
        initialize();
    }

    private void initialize() {
        initBackground();
        initShip();
        initAliensController();
        initPointsLabel();
        initHealthLabel();
    }

    private void referee() {
        for (int i=0; i < stage.getActors().size; i++){
            Actor actor = stage.getActors().get(i);

            if (actor instanceof Alien) {
                Alien alien = (Alien) actor;
                if (alien.getY() <= 0 || ship.health <= 0){
                    game.setScreen(new LossScreen(game));
                }
            }
        }
    }

    private void shipCollision() {
        for (int i=0; i < stage.getActors().size; i++){
            Actor actorA = stage.getActors().get(i);
            if (actorA instanceof Bullet) {
                Bullet bullet = (Bullet) actorA;
                if(bullet.getBounds().overlaps(ship.getBounds()) && bullet.type == Bullet.Type.ALIEN){
                    bullet.remove();
                    --ship.health;
                }
            }
        }
    }

    private void aliensCollision() {
        for (int i=0; i < stage.getActors().size; i++){
            Actor actorA = stage.getActors().get(i);
            if (actorA instanceof Bullet) {
                Bullet bullet = (Bullet) actorA;
                for (Actor actorB:stage.getActors()){
                    if (actorB instanceof Alien) {
                        Alien alien  = (Alien) actorB;
                        if(bullet.getBounds().overlaps(alien.getBounds()) && bullet.getBounds().getY() < 800
                                && bullet.type == Bullet.Type.SHIP){
                            bullet.remove();
                            alien.remove();
                            Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/collision.mp3"));
                            sound.play(0.5f);
                            game.addPoint(1);
                        }
                    }
                }
            }
        }
    }

    private void shotAlienBullet() {
        alienBulletCounter+= Gdx.graphics.getDeltaTime();
        int dice = MathUtils.random(stage.getActors().size - 1);
        Actor actor = stage.getActors().get(dice);
        if (actor instanceof Alien && alienBulletCounter > 2) {
            initBulletController("alien", (int) (actor.getX() + actor.getWidth() / 2),(int) actor.getY());
            alienBulletCounter = 0;
        }

    }

    private void initPointsLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        pointsLabel = new Label("", labelStyle);
        pointsLabel.setPosition(20,775);
        pointsLabel.setColor(Color.YELLOW);
        pointsLabel.setFontScale(2);
        stage.addActor(pointsLabel);
    }

    private void initHealthLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        healthLabel = new Label("", labelStyle);
        healthLabel.setPosition(SpaceGame.WIDTH - 25,775);
        healthLabel.setColor(Color.RED);
        healthLabel.setFontScale(2);
        stage.addActor(healthLabel);
    }

    private void shotShipBullet() {
        shipBulletCounter += Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && shipBulletCounter > 0.25){
            initBulletController("ship", (int) (ship.getX() + ship.getWidth() / 2), 50);
            shipBulletCounter = 0;
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

    private void initBulletController(String whose, int x, int y) {
        bulletsController = new BulletsController(game, stage, ship, whose, x, y);
    }

    private void initAliensController() {
        aliensController = new AliensController(game, stage, 5);
    }

    private void initBackground() {
        backgroundImage = new Image(new Texture("images/background.jpg"));
        stage.addActor(backgroundImage);
    }

    private void initShip() {
        ship = new SpaceShip(2);
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
        pointsLabel.setText(game.getPoints());
        healthLabel.setText(ship.health);
        shipMovement();
        shotShipBullet();
        shotAlienBullet();
        aliensCollision();
        shipCollision();
        referee();
    }
}
