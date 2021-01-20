package pl.projekt.spaceproject.controllers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.Bullet;
import pl.projekt.spaceproject.gamecomponents.SpaceShip;

public class BulletsController {

    public BulletsController(SpaceGame game, Stage stage, SpaceShip ship) {
        shootBullet(game, stage, ship);
    }

    private void shootBullet(SpaceGame game, Stage stage, SpaceShip ship) {
        Bullet bullet = new Bullet(ship.getX() + ship.getWidth() / 2, game);
        stage.addActor(bullet);
        System.out.println(bullet.getBounds());
        bullet.fly();
    }
}
