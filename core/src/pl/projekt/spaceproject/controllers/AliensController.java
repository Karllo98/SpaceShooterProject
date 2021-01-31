package pl.projekt.spaceproject.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.Alien;

public class AliensController {
    public AliensController(SpaceGame game, Stage stage, int amount) {
        deployAliens(game, stage, amount);
    }

    private void deployAliens(SpaceGame game, Stage stage, int amount) {
        int dice, counter = 1;
        for (int y = 1; y <= amount; ++y) {
            for (int x = 1; x <= 8; ++x) {
//                dice = MathUtils.random(2);
//                if(dice != 1){
//                    ++counter;
                    Alien alien = new Alien(50 + 50 * x, 800 - 50 * y, randomType(), game);
                    stage.addActor(alien);
                    alien.move();
//                } else --x;
            }
        }
    }

    private String randomType() {
        String type = null;
        int dice = MathUtils.random(0, 2);
        switch(dice) {
            case 0:
                type = "alien_a.png";
                break;
            case 1:
                type = "alien_b.png";
                break;
            case 2:
                type = "alien_c.png";
                break;
        }
        return type;
    }
}
