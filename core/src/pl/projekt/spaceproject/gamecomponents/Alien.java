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

        Action first = Actions.moveBy(path * -100, 0, 3);
        Action second = Actions.moveBy(0, -175, 3);
        Action third = Actions.moveBy(path * 200, 0, 6);
        Action fourth = Actions.moveBy(path * -100, 0, 2);
        Action fifth = Actions.moveBy(0, -175, 2);
        Action sixth = Actions.moveBy(path * -100, 0, 4);
        Action seventh = Actions.moveBy(path * 100, 0, 1);
        Action eighth = Actions.moveBy(0, -200, 1);
        Action ninth = Actions.moveBy(path * 100, 0, 2);
        Action tenth = Actions.moveBy(path * -200, 0, 2);
        Action eleventh = Actions.moveBy(0, -250, 1);

        addAction(Actions.sequence(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh));

    }

    protected void positionChanged() {
        bounds.setX((int) getX());
        bounds.setY((int) getY());
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
