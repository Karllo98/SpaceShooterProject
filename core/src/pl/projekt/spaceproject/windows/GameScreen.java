package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.controllers.BoostsController;
import pl.projekt.spaceproject.controllers.BulletsController;
import pl.projekt.spaceproject.controllers.MeteorsController;
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

        for (int i=0; i < stage.getActors().size; i++){
            Actor actorA = stage.getActors().get(i);
            if (actorA instanceof Bullet) {
                Bullet bullet = (Bullet) actorA;
                for (Actor actorB:stage.getActors()){
                    if (actorB instanceof Meteor) {
                        Meteor meteor  = (Meteor) actorB;
                        if(bullet.getBounds().overlaps(meteor.getBounds())){
                            meteor.remove();
                            game.addPoint();
                        }
                    }
                }
            }
        }

//        Bullet bullet = null;
//        Meteor meteor = null;

//        for (int i = meteorsController.meteors.size-1; i >= 0; i--){
//            meteor = meteorsController.meteors.get(i);
//            meteor.getBounds().y;
//        }

//        for (Actor actor:stage.getActors()){
//            if (actor instanceof Bullet) {
//                bullet  = (Bullet) actor;
//            }
//        }
//
//        for (Actor actor:stage.getActors()){
//            if (actor instanceof Meteor) {
//                meteor  = (Meteor) actor;
//            }
//        }
//
//        assert meteor != null;
//        assert bullet != null;
//        if(meteor.getBounds().overlaps(bullet.getBounds()))
//            System.out.println("kolizja");

//        for (Actor actorA:stage.getActors()) {
//            for (Actor actorB:stage.getActors()){
//                if (actorB instanceof Bullet) {
//                    bullet  = (Bullet) actorB;
//                }
//                if (actorA instanceof Meteor) {
//                    meteor = (Meteor) actorA;
//                }
//                assert meteor != null;
//                assert bullet != null;
//                if(meteor.getBounds().overlaps(bullet.getBounds())){
//                    System.out.println("kolizja");
//                }
//            }
//        }


//         {
//            if (actorB instanceof Meteor) {
//                float b = ((Meteor) actorB).getBounds().y;
//                System.out.println(b);
//
//            }
//        }
        shipMovement();
        bulletMovement();
    }
}
