package pl.projekt.spaceproject.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.projekt.spaceproject.SpaceGame;
import pl.projekt.spaceproject.gamecomponents.Meteor;

public class MeteorsController {

    private int amount;

    public MeteorsController(SpaceGame game, Stage stage, int amount) {
        this.amount = amount;
        deployMeteors(game, stage, amount);
    }

    private void deployMeteors(SpaceGame game, Stage stage, int amount) {
        for (int i = 1; i <= amount; ++i) {
            Meteor meteor = new Meteor(randomXPosition(), randomYPosition(), game);
            stage.addActor(meteor);
            meteor.fall();
        }
    }

    private int randomXPosition() {
        return MathUtils.random(0, SpaceGame.WIDTH - 40);
    }

    private int randomYPosition() {
        return MathUtils.random(SpaceGame.HEIGHT, 1500);
    }

    public int getAmount() {
        return amount;
    }

    public void reduceAmount() {
        --amount;
    }
}
