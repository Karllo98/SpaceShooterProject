package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Meteor extends Image {

    public final static String METEOR = "meteor.png";
    private final static int WIDTH = 40;
    private final static int HEIGHT = 40;
    private final static int STARTINGX = 280;
    private final static int STARTINGY = 800;

    public Meteor() {
        super(new Texture(METEOR));
        setOrigin(WIDTH / 2, HEIGHT / 2);
        setSize(WIDTH, HEIGHT);
        setPosition(STARTINGX, STARTINGY);
    }

    public void fall(){
        //dummy
        //not working as planned
        Action a = Actions.parallel(Actions.moveBy(0,-400, 10),
                Actions.rotateBy(360, 10));

        Action b = Actions.parallel(Actions.moveBy(0,-400, 10),
                Actions.rotateBy(-360, 10));

        Action runAction = Actions.run(new Runnable() {
            @Override
            public void run() {
                Meteor.this.remove();
            }
        });

        addAction(Actions.sequence(a, b, runAction));

    }
}
