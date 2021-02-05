package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.projekt.spaceproject.SpaceGame;

public class Bullet extends Image {

    public enum Type {SHIP, ALIEN;}
    public final Type type;
    private final static int WIDTH = 3;
    private final static int HEIGHT = 20;
    private final SpaceGame game;
    private Sound bulletSound = Gdx.audio.newSound(Gdx.files.internal("sounds/shot.mp3"));
    private Rectangle bounds = new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());

    public Bullet(float x, float y, Type type, String texture, SpaceGame game) {
        super(new Texture(texture));
        this.type = type;
        this.game = game;
        setOrigin(WIDTH / 2f, HEIGHT / 2f);
        setSize(WIDTH, HEIGHT);
        setPosition(x, y);
        bulletSound.play(0.5f);
    }

    public void alienShot() {
        Action first = Actions.parallel(Actions.moveBy(0, -SpaceGame.HEIGHT, 2));
        Action second = Actions.run(new Runnable() {
            @Override
            public void run() {
                Bullet.this.remove();
            }
        });

        addAction(Actions.sequence(first, second));
    }

    public void shipShot() {
        Action first = Actions.parallel(Actions.moveBy(0, SpaceGame.HEIGHT, 2));
        Action second = Actions.run(new Runnable() {
            @Override
            public void run() {
                Bullet.this.remove();
            }
        });

        addAction(Actions.sequence(first, second));
    }

    public Rectangle getBounds() {
        return bounds;
    }

    protected void positionChanged() {
        bounds.setX((int)getX());
        bounds.setY((int)getY());
    }
}
