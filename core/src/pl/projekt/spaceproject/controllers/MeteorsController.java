package pl.projekt.spaceproject.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.Meteor;

public class MeteorsController {

    public MeteorsController(SpaceGame game, Stage stage) {
        initialize(game, stage);
    }

    private void initialize(SpaceGame game, Stage stage) {
        deployMeteors(game, stage);
    }


    private void deployMeteors(SpaceGame game, Stage stage) {
        Meteor meteor;

        int amount = 30;
        for (int i = 1; i <= amount; ++i) {
            randomXPosition();
            randomYPosition();
            meteor = new Meteor(randomXPosition(), randomYPosition(), game);
            stage.addActor(meteor);
            meteor.fall();
        }
    }


    private int randomXPosition() {
        return MathUtils.random(0, SpaceGame.WIDTH - 40);
    }

    private int randomYPosition() {
        return MathUtils.random(SpaceGame.HEIGHT, 1000);
    }
}
