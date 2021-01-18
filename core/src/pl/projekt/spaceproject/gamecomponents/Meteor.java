package pl.projekt.spaceproject.gamecomponents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import pl.projekt.spaceproject.SpaceGame;

public class Meteor extends Image {

    public final static String METEOR = "meteor.png";
    private final static int WIDTH = 40;
    private final static int HEIGHT = 40;
    private SpaceGame game;


    public Meteor(int x, int y, SpaceGame game) {
        super(new Texture(METEOR));
        this.game = game;
        setOrigin(WIDTH / 2, HEIGHT / 2);
        setSize(WIDTH, HEIGHT);
        setPosition(x, y);
    }

    public void fall(){
        //simple movement
        Action first = Actions.parallel(Actions.moveBy(0,-400, 10),
                Actions.rotateBy(360, 10));

        Action second = Actions.parallel(Actions.moveBy(0,-400, 10),
                Actions.rotateBy(-360, 10));

//        Action runAction = Actions.run(new Runnable() {
//            @Override
//            public void run() {
//                Meteor.this.remove();
//            }
//        });

        addAction(Actions.sequence(first, second));

    }
}