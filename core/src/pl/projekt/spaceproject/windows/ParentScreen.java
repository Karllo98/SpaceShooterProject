package pl.projekt.spaceproject.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import pl.projekt.spaceproject.SpaceGame;

public abstract class ParentScreen implements Screen {

    protected SpaceGame game;
    private OrthographicCamera camera;
    protected Stage stage;
    protected SpriteBatch spriteBatch;

    public ParentScreen(SpaceGame game) {
        this.game = game;
        createCamera();
        stage = new Stage(new FitViewport(SpaceGame.WIDTH, SpaceGame.HEIGHT, camera));
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
    }

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SpaceGame.WIDTH, SpaceGame.HEIGHT);
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
    }

    @Override
    public void show() {

    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }
}

