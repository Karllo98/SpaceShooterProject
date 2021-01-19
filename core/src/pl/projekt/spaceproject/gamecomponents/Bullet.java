package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.projekt.spaceproject.SpaceGame;

public class Bullet extends Image {

    public final static String BULLET = "bullet.png";
    public final static int WIDTH = 40;
    private final static int HEIGHT = 40;
    private final SpaceGame game;

    public Bullet(int x, int y, SpaceGame game) {
        super(new Texture(BULLET));
        this.game = game;
        setOrigin(WIDTH / 2, HEIGHT / 2);
        setSize(WIDTH, HEIGHT);
        setPosition(x, y);
    }

    public void fly() {
        Action moveAction = Actions.moveBy(0, 5);
        addAction(moveAction);
    }
}
