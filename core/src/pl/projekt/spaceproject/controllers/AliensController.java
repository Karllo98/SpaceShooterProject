package pl.projekt.spaceproject.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.Alien;

public class AliensController {

    private final static int INROW = 8;
    private int aliens;

    public AliensController(SpaceGame game, Stage stage, int amount) {
        aliens = amount * INROW;
        deployAliens(game, stage, amount);
    }

    private void deployAliens(SpaceGame game, Stage stage, int amount) {
        boolean dice = MathUtils.randomBoolean();
        int moveLeft = -100;
        int moveRight = 100;
        for (int y = 1; y <= amount; ++y) {
            for (int x = 1; x <= INROW; ++x) {
                Alien alien = new Alien(50 + 50 * x, 800 - 50 * y, randomType(), game);
                stage.addActor(alien);
                alien.move(dice);
            }
        }
    }

    private String randomType() {
        String type = null;
        int dice = MathUtils.random(0, 2);
        switch (dice) {
            case 0:
                type = "images/alien_a.png";
                break;
            case 1:
                type = "images/alien_b.png";
                break;
            case 2:
                type = "images/alien_c.png";
                break;
        }
        return type;
    }

    public int getAmount() {
        return aliens;
    }

    public void reduceAmount() {
        --aliens;
    }
}
