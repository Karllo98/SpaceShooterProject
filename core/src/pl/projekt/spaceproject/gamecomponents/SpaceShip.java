package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SpaceShip extends Image {

    public final static String SHIP = "ship.png";
    private final static int WIDTH = 70;
    private final static int HEIGHT = 70;
    private final static int STARTINGX = 270;
    private final static int STARTINGY = 0;

    public SpaceShip() {
        super(new Texture(SHIP));
        setOrigin(WIDTH / 2, HEIGHT / 2);
        setSize(WIDTH, HEIGHT);
        setPosition(STARTINGX, STARTINGY);
    }
}
