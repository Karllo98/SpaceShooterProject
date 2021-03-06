package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.projekt.spaceproject.SpaceGame;

public class Meteor extends Image {

    private final static String METEOR = "images/meteor.png";
    private final static int WIDTH = 40;
    private final static int HEIGHT = 40;
    private final SpaceGame game;
    private Rectangle bounds = new Rectangle((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());

    public Meteor(int x, int y, SpaceGame game) {
        super(new Texture(METEOR));
        this.game = game;
        setOrigin(WIDTH / 2f, HEIGHT / 2f);
        setSize(WIDTH, HEIGHT);
        setPosition(x, y);
    }

    public void fall() {
        //simple movement
        Action first = Actions.parallel(Actions.moveBy(0, -400, 5),
                Actions.rotateBy(360, 5));

        Action second = Actions.parallel(Actions.moveBy(0, -400, 5),
                Actions.rotateBy(-360, 5));

        Action third = Actions.parallel(Actions.moveBy(0, -400, 5),
                Actions.rotateBy(180, 5));

        Action fourth = Actions.parallel(Actions.moveBy(0, -400, 5),
                Actions.rotateBy(-180, 5));

        addAction(Actions.sequence(first, second, third, fourth));
    }

    public Rectangle getBounds() {
        return bounds;
    }

    protected void positionChanged() {
        bounds.setX((int) getX());
        bounds.setY((int) getY());
    }
}
