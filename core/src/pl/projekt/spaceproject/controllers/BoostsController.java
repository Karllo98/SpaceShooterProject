package pl.projekt.spaceproject.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import jdk.dynalink.NamedOperation;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.Boost;

public class BoostsController {

    public BoostsController(SpaceGame game, Stage stage, int amount) {
        deployBoosts(game, stage, amount);
    }

    private void deployBoosts(SpaceGame game, Stage stage, int amount) {
        for (int i = 1; i <= amount; ++i) {
            randomXPosition();
            randomYPosition();
            Boost boost = new Boost(randomXPosition(), randomYPosition(), game);
            stage.addActor(boost);
            boost.fall();
        }
    }

    private int randomXPosition() {
        return MathUtils.random(0, SpaceGame.WIDTH - 40);
    }

    private int randomYPosition() {
        return MathUtils.random(SpaceGame.HEIGHT + 300, 3000);
    }
}
