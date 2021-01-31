package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SpaceShip extends Image {

    public final static String SHIP = "images/ship.png";
    private final static int WIDTH = 70;
    private final static int HEIGHT = 70;
    private final static int STARTINGX = 270;
    private final static int STARTINGY = 0;
    private Rectangle bounds = new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    public int health;

    public SpaceShip() {
        super(new Texture(SHIP));
        setOrigin(WIDTH / 2f, HEIGHT / 2f);
        setSize(WIDTH, HEIGHT);
        setPosition(STARTINGX, STARTINGY);
    }

    public SpaceShip(int health) {
        super(new Texture(SHIP));
        setOrigin(WIDTH / 2f, HEIGHT / 2f);
        setSize(WIDTH, HEIGHT);
        setPosition(STARTINGX, STARTINGY);
        this.health = health;
    }

    public void moveLeft() {
        Action moveAction = Actions.moveBy(-5, 0);
        addAction(moveAction);
    }

    public void moveRight(){
        Action moveAction = Actions.moveBy(5, 0);
        addAction(moveAction);
    }

    protected void positionChanged() {
        bounds.setX((int) getX());
        bounds.setY((int) getY());
    }

    public Rectangle getBounds() {
        return bounds;
    }

}
