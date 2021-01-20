package pl.projekt.spaceproject.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.Meteor;

public class MeteorsController {
    public Array<Meteor> meteors = new Array<>();
    public MeteorsController(SpaceGame game, Stage stage) {
        deployMeteors(game, stage);
    }

    private void deployMeteors(SpaceGame game, Stage stage) {
        int amount = 30;
        for (int i = 1; i <= amount; ++i) {
            randomXPosition();
            randomYPosition();
            Meteor meteor = new Meteor(randomXPosition(), randomYPosition(), game);
            stage.addActor(meteor);
            meteors.add(meteor);
            meteor.fall();
        }
    }

    private int randomXPosition() {
        return MathUtils.random(0, SpaceGame.WIDTH - 40);
    }

    private int randomYPosition() {
        return MathUtils.random(SpaceGame.HEIGHT, 1500);
    }
}
