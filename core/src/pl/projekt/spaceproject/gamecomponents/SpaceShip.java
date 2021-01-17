package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SpaceShip extends Image {

    private final static int WIDTH = 60;
    private final static int HEIGHT = 100;
    private final static int STARTINGX = 200;
    private final static int STARTINGY = 200;

    public SpaceShip() {
        super(new Texture("badlogic.jpg"));
        setOrigin(WIDTH / 2, HEIGHT / 2);
        setSize(WIDTH, HEIGHT);
        setPosition(STARTINGX, STARTINGY);
    }
}
