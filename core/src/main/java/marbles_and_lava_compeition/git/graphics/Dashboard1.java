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

    public static final String BACKGROUND_IMAGES_KIDS_CHEERING_4_PNG = "background_images/kids_cheering4.png";
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
    private Texture grassTexture1;
    private Sprite grassSprite1;
    private Sprite grassSprite2;
    private Sprite grassSprite3;
    private Texture waterLavaTexture;
    private Sprite waterLavaSprite;
    private Sprite waterLavaSprite2;
    private Sprite waterLavaSprite3;
    private Sprite waterLavaSprite4;
    private Sprite waterLavaSprite5;
    private Sprite waterLavaSprite6;
    private Texture pointsTexture1;
    private Sprite pointsSprite1;
    private Texture pointsTexture2;
    private Sprite pointsSprite2;
    private Texture pointsTexture3;
    private Sprite pointsSprite3;
    private Texture pointsTexture4;
    private Sprite pointsSprite4;


    public Dashboard1(Main game, String[] groups, String gamer){
        this.game = game;
        this.countriesGroups = groups;
        this.winners = new String[(groups.length)/2];  // Only half of the marbles will be making it to the next round
        this.gamer = gamer;
    }

    // Creates the dashboard according to the player
    public void populatePlayerGraphics(){

        if (this.gamer.equals("Anastasia")){
            this.peopleTexture = new Texture(Gdx.files.internal(BACKGROUND_IMAGES_KIDS_CHEERING_4_PNG));
            this.waterLavaTexture = new Texture(Gdx.files.internal("background_images/water.png"));

            this.goalieTexture = new Texture(Gdx.files.internal("background_images/unicorn.png"));
            this.goalieSprite = new Sprite(this.goalieTexture);

            this.grassTexture1 = new Texture(Gdx.files.internal("background_images/grass.png"));
            this.grassSprite1 = new Sprite(this.grassTexture1);
            this.grassSprite1.setSize(1170, 50);
            this.grassSprite1.setPosition(450, 0);
            this.grassSprite1.draw(this.game.batch);

            this.netTexture = new Texture(Gdx.files.internal("background_images/nett.png"));
            this.netSprite = new Sprite(this.netTexture);
            this.netSprite.setSize(50, 300);
            this.netSprite.setPosition(1570, 50);
            netSprite.draw(this.game.batch);

        } else {
            this.goalieTexture = new Texture(Gdx.files.internal("background_images/red_ball.png"));
            this.peopleTexture = new Texture(Gdx.files.internal("background_images/dinosaur.png"));
            this.waterLavaTexture = new Texture(Gdx.files.internal("background_images/laval.png"));
            this.waterLavaSprite = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite2 = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite3 = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite4 = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite5 = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite6 = new Sprite(this.waterLavaTexture);

            this.waterLavaSprite.setSize(300, 50);
            this.waterLavaSprite2.setSize(200, 50);
            this.waterLavaSprite3.setSize(200, 50);
            this.waterLavaSprite4.setSize(50, 150);
            this.waterLavaSprite5.setSize(50, 150);
            this.waterLavaSprite6.setSize(50, 150);

            this.waterLavaSprite.setPosition(400, 0);
            this.waterLavaSprite2.setPosition(900, 0);
            this.waterLavaSprite3.setPosition(1300, 0);
            this.waterLavaSprite4.setPosition(1570, 200);
            this.waterLavaSprite5.setPosition(1570, 450);
            this.waterLavaSprite6.setPosition(1570, 800);

            this.waterLavaSprite.draw(this.game.batch);
            this.waterLavaSprite2.draw(this.game.batch);
            this.waterLavaSprite3.draw(this.game.batch);
            this.waterLavaSprite4.draw(this.game.batch);
            this.waterLavaSprite5.draw(this.game.batch);
            this.waterLavaSprite6.draw(this.game.batch);

        }


        this.peopleSprite = new Sprite(this.peopleTexture);

        this.peopleSprite.setPosition(600, 200);
        this.peopleSprite.setSize(400, 400);
        this.peopleSprite.draw(this.game.batch);

    }

    // Dispose textures handling each player differently
    public void disposeTextures(){

        if (this.gamer.equals("Anastasia")){
            this.netTexture.dispose();
            this.grassTexture1.dispose();

        } else {

            this.waterLavaTexture.dispose();

        }

        this.peopleTexture.dispose();

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
        this.disposeTextures();

    }
}
