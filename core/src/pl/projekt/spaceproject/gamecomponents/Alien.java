package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.projekt.spaceproject.SpaceGame;

public class Alien extends Image {

    private final static int WIDTH = 40;
    private final static int HEIGHT = 40;
    private final SpaceGame game;
    private Rectangle bounds = new Rectangle((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());

    public Alien(int x, int y, String type, SpaceGame game) {
        super(new Texture(type));
        this.game = game;
        setOrigin(WIDTH / 2f, HEIGHT / 2f);
        setSize(WIDTH, HEIGHT);
        setPosition(x, y);
    }

    public void move(boolean dice) {
        int path;

        if (dice)
            path = 1;
        else path = -1;

        Action actions = Actions.sequence(
                Actions.moveBy(path * -100, 0, 3),
                Actions.moveBy(0, -175, 3),
                Actions.moveBy(path * 200, 0, 6),
                Actions.moveBy(path * -100, 0, 2),
                Actions.moveBy(0, -175, 2),
                Actions.moveBy(path * -100, 0, 4),
                Actions.moveBy(path * 100, 0, 1),
                Actions.moveBy(0, -200, 1),
                Actions.moveBy(path * 100, 0, 2),
                Actions.moveBy(path * -200, 0, 2),
                Actions.moveBy(0, -250, 1)
                );

        addAction(Actions.sequence(actions));

    }

    protected void positionChanged() {
        bounds.setX((int) getX());
        bounds.setY((int) getY());
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
