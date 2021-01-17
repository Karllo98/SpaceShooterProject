package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.projekt.spaceproject.SpaceGame;

public abstract class ParentScreen implements Screen {

    protected SpaceGame game;
    private OrthographicCamera camera;
    protected Stage stage;
    protected SpriteBatch spriteBatch;

    public ParentScreen(SpaceGame game){

        this.game = game;
        createCamera();

    }

    private void createCamera(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SpaceGame.WIDTH, SpaceGame.HEIGHT);
        camera.update();
    }
}
