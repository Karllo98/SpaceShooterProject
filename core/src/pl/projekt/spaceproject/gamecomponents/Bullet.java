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
    private static final int YPOSITION = 50;
    private final SpaceGame game;

    public Bullet(float x, SpaceGame game) {
        super(new Texture(BULLET));
        this.game = game;
        setOrigin(WIDTH / 2, HEIGHT / 2);
        setSize(WIDTH, HEIGHT);
        setPosition(x, YPOSITION);
    }

    public void fly() {
        Action first = Actions.parallel(Actions.moveBy(0, SpaceGame.HEIGHT, 2));
        Action second = Actions.run(new Runnable() {
            @Override
            public void run() {
                Bullet.this.remove();
            }
        });

        addAction(Actions.sequence(first, second));
    }


}
