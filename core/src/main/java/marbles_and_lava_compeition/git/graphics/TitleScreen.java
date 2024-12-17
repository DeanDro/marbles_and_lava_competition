package marbles_and_lava_compeition.git.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.graphics.Texture;

// Custom classes
import marbles_and_lava_compeition.git.Main;

public class TitleScreen extends ScreenAdapter {

    Main game;
    public Stage stage = new Stage();
    public BitmapFont font = new BitmapFont();
    public Skin skin = new Skin(Gdx.files.internal("data/comic/skin/comic-ui.json"));

    public TitleScreen(Main game){
        this.game = game;
    }

    @Override
    public void show(){
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // Label
        Label title = new Label("Marbles Competition", this.skin);
        title.setFontScale(5f);
        title.setPosition(100, 800);

        TextButton button = new TextButton("Anastasia Game", skin);
        button.setPosition(200, 400);
        button.setSize(300, 100);
        button.setColor(Color.BLUE);

        // Add a listener to handle button clicks
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new IntroPage(game, "Anastasia"));
            }
        });

        TextButton williamGame = new TextButton("William Game", skin);
        williamGame.setPosition(200, 200);
        williamGame.setSize(300, 100);
        williamGame.setColor(Color.GREEN);

        // Add a listener to handle button clicks
        williamGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new IntroPage(game, "William"));
            }
        });



        this.stage.addActor(button);
        this.stage.addActor(williamGame);
        this.stage.addActor(title);

    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(.1f, .1f, .4f, 1);  // This is for Blue
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.game.batch.begin();
        this.stage.draw();
        this.game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
        this.stage.dispose();
    }
}
