package marbles_and_lava_compeition.git.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Custom classes
import marbles_and_lava_compeition.git.Main;
import marbles_and_lava_compeition.git.utilities.Marbles;
import marbles_and_lava_compeition.git.utilities.CountriesPopulation;


public class Dashboard1 extends ScreenAdapter {

    public Main game;
    public String[] countriesGroups;
    public String[] winners;
    public Stage stage = new Stage();
    public BitmapFont font = new BitmapFont();
    public Skin skin = new Skin(Gdx.files.internal("data/comic/skin/comic-ui.json"));
    public String gamer;

    // Background Graphics
    private Texture peopleTexture;
    private Sprite peopleSprite;
    private Texture netTexture;
    private Sprite netSprite;
    private Texture goalieTexture;
    private Sprite goalieSprite;


    public Dashboard1(Main game, String[] groups, String gamer){
        this.game = game;
        this.countriesGroups = groups;
        this.winners = new String[(groups.length)/2];  // Only half of the marbles will be making it to the next round
        this.gamer = gamer;
    }

    // Creates the dashboard according to the player
    public void populatePlayerGraphics(){

        if (this.gamer.equals("Anastasia")){
            this.peopleTexture = new Texture(Gdx.files.internal("background_images/kids_cheering4.png"));
            this.goalieTexture = new Texture(Gdx.files.internal("background_images/unicorn.png"));
            this.netTexture = new Texture(Gdx.files.internal("background_images/nett.png"));
            this.netSprite = new Sprite(this.netTexture);

        } else {
            this.goalieTexture = new Texture(Gdx.files.internal("background_images/red_ball.png"));
            this.peopleTexture = new Texture(Gdx.files.internal("background_images/dinosaur.png"));
        }

        this.goalieSprite = new Sprite(this.goalieTexture);
        this.peopleSprite = new Sprite(this.peopleTexture);

        this.peopleSprite.setPosition(600, 200);
        this.peopleSprite.setSize(400, 400);
        this.peopleSprite.draw(this.game.batch);

    }

    @Override
    public void show(){

        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);


    }

    @Override
    public void render(float delta){

        if (this.gamer.equals("Anastasia")) {
            Gdx.gl.glClearColor(.1f, .1f, .8f, 1);  // This is for Blue
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        } else if (this.gamer.equals("William")){
            Gdx.gl.glClearColor(.1f, .6f, .4f, 1);  // This is for Blue
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }

        this.game.batch.begin();

        // Populate Graphics
        this.populatePlayerGraphics();

        this.stage.draw();
        this.game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
        this.stage.dispose();

        // Remove background graphics
        this.peopleTexture.dispose();

    }
}
