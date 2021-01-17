package pl.projekt.spaceproject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.projekt.spaceproject.SpaceGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = SpaceGame.TITLE;
        config.width = SpaceGame.WIDTH;
        config.height = SpaceGame.HEIGHT;
        config.resizable = false;

        new LwjglApplication(new SpaceGame(), config);
    }
}
