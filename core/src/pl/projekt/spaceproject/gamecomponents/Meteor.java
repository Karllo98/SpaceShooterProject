package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Meteor extends Image {

    public final static String METEOR = "meteor.png";
    private final static int WIDTH = 50;
    private final static int HEIGHT = 50;
    private final static int STARTINGX = 270;
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
        Action a = Actions.parallel(Actions.moveBy(0,-100),
                Actions.rotateBy(360));

        Action runAction = Actions.run(new Runnable() {
            @Override
            public void run() {
            }
        });

        addAction(Actions.sequence(a, runAction));

    }
}
