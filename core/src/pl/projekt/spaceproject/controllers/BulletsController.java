package pl.projekt.spaceproject.controllers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.Bullet;
import pl.projekt.spaceproject.gamecomponents.SpaceShip;

public class BulletsController {

    public BulletsController(SpaceGame game, Stage stage, SpaceShip ship, String whose, int x, int y) {
        shotBullet(game, stage, ship, whose, x, y);
    }

    private void shotBullet(SpaceGame game, Stage stage, SpaceShip ship, String whose, int x, int y) {
        switch(whose) {
            case "alien":
                Bullet alienBullet = new Bullet(x,y, Bullet.Type.ALIEN ,"alienbullet.png", game);
                stage.addActor(alienBullet);
                alienBullet.alienShot();
                break;
            case "ship":
                Bullet bullet = new Bullet(x, y, Bullet.Type.SHIP,"shipbullet.png", game);
                stage.addActor(bullet);
                bullet.shipShot();
                break;
        }
    }
}
