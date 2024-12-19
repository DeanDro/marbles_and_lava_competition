package marbles_and_lava_compeition.git.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

// Custom classes
import marbles_and_lava_compeition.git.Main;
import marbles_and_lava_compeition.git.utilities.DashboardUtilities;


public class Dashboard1 extends ScreenAdapter {

    public static final String BACKGROUND_IMAGES_KIDS_CHEERING_4_PNG = "background_images/kids_cheering4.png";
    public Main game;
    public String[] countriesGroups;
    public String[] winners;
    public Stage stage = new Stage();
    public BitmapFont font = new BitmapFont();
    public Skin skin = new Skin(Gdx.files.internal("data/comic/skin/comic-ui.json"));
    public String gamer;
    public float timeLapsed;
    public float timeRemaining;
    public int previousTime;
    public int ballsCounter;

    // Helper classes
    DashboardUtilities utilities = new DashboardUtilities();

    // Background Graphics
    private Texture peopleTexture;
    private Sprite peopleSprite;
    private Texture netTexture;
    private Sprite netSprite;
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
    private Texture pointsTexture;
    private Sprite pointsSprite;
    private Sprite pointsSprite2;
    private Sprite pointsSprite3;
    private Texture trambolineTexture;
    private Sprite trambolineSprite;

    // Moving elements
    private Texture pipeTexture;
    private Sprite pipeSprite;
    private Texture ballTexture1;
    private Sprite ballSprite1;
    private Texture ballTexture2;
    private Sprite ballSprite2;
    private Texture ballTexture3;
    private Sprite ballSprite3;
    private Texture ballTexture4;
    private Sprite ballSprite4;
    private Texture goalieTexture;
    private Sprite goalieSprite;

    // Movement components elements
    private int goalieSpeed = 1;
    private int goalieY;
    private int pipeSpeed;
    private int pipeRotation;


    public Dashboard1(Main game, String[] groups, String gamer){
        this.game = game;
        this.countriesGroups = groups;
        this.winners = new String[(groups.length)/2];  // Only half of the marbles will be making it to the next round
        this.gamer = gamer;
        this.ballsCounter = 0;
    }

    // Creates the dashboard according to the player
    public void populatePlayerGraphics(float timeRemaining, float timeLapsed){

        // Elements for everyone
        this.grassTexture1 = new Texture(Gdx.files.internal("background_images/grass.png"));
        this.trambolineTexture = new Texture(Gdx.files.internal("background_images/tranpolin.png"));
        this.trambolineSprite = new Sprite(this.trambolineTexture);

        if (this.gamer.equals("Anastasia")){
            this.peopleTexture = new Texture(Gdx.files.internal(BACKGROUND_IMAGES_KIDS_CHEERING_4_PNG));
            this.waterLavaTexture = new Texture(Gdx.files.internal("background_images/water.png"));
            this.waterLavaSprite = new Sprite(this.waterLavaTexture);
            this.utilities.setSpritePosSizeDraw(this.game, this.waterLavaSprite, 250, 0, 200, 50);

            this.grassSprite1 = new Sprite(this.grassTexture1);
            this.utilities.setSpritePosSizeDraw(this.game, this.grassSprite1, 450, 0, 1170, 50);

            this.netTexture = new Texture(Gdx.files.internal("background_images/nett.png"));
            this.netSprite = new Sprite(this.netTexture);
            this.utilities.setSpritePosSizeDraw(this.game, this.netSprite, 1570, 50, 50, 300);

            this.utilities.setSpritePosSizeDraw(this.game, this.trambolineSprite, 0, 0, 250, 100);

        } else {

            this.peopleTexture = new Texture(Gdx.files.internal("background_images/dinosaur.png"));
            this.waterLavaTexture = new Texture(Gdx.files.internal("background_images/laval.png"));

            this.waterLavaSprite = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite2 = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite3 = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite4 = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite5 = new Sprite(this.waterLavaTexture);
            this.waterLavaSprite6 = new Sprite(this.waterLavaTexture);

            this.grassSprite1 = new Sprite(this.grassTexture1);
            this.grassSprite2 = new Sprite(this.grassTexture1);
            this.grassSprite3 = new Sprite(this.grassTexture1);

            this.utilities.setSpritePosSizeDraw(this.game, this.waterLavaSprite, 400, 0, 300, 50);
            this.utilities.setSpritePosSizeDraw(this.game, this.waterLavaSprite2, 900, 0, 200, 50);
            this.utilities.setSpritePosSizeDraw(this.game, this.waterLavaSprite3, 1300, 0, 320, 50);
            this.utilities.setSpritePosSizeDraw(this.game, this.waterLavaSprite4,1570, 200, 50, 150);
            this.utilities.setSpritePosSizeDraw(this.game, this.waterLavaSprite5, 1570, 450, 50, 150);
            this.utilities.setSpritePosSizeDraw(this.game, this.waterLavaSprite6, 1570, 750, 50, 160);

            this.utilities.setSpritePosSizeDraw(this.game, this.grassSprite1, 200, 0, 200, 50);
            this.utilities.setSpritePosSizeDraw(this.game, this.grassSprite2, 700, 0, 200, 50);
            this.utilities.setSpritePosSizeDraw(this.game, this.grassSprite3, 1100, 0, 200, 50);

            this.utilities.setSpritePosSizeDraw(this.game, this.trambolineSprite, 0, 0, 200, 100);

            this.pointsTexture = new Texture(Gdx.files.internal("background_images/points.png"));
            this.pointsSprite = new Sprite(this.pointsTexture);
            this.pointsSprite2 = new Sprite(this.pointsTexture);
            this.pointsSprite3 = new Sprite(this.pointsTexture);
            this.utilities.setSpritePosSizeDraw(this.game, this.pointsSprite, 1570, 50, 50, 150);
            this.utilities.setSpritePosSizeDraw(this.game, this.pointsSprite2, 1570, 350, 50, 150);
            this.utilities.setSpritePosSizeDraw(this.game, this.pointsSprite3, 1570, 600, 50, 150);

        }


        this.peopleSprite = new Sprite(this.peopleTexture);
        this.utilities.setSpritePosSizeDraw(this.game, this.peopleSprite, 600, 200, 400, 400);

    }

    // Dispose textures handling each player differently
    public void disposeTextures(){

        if (this.gamer.equals("Anastasia")){
            this.netTexture.dispose();

        } else {
            this.pointsTexture.dispose();
        }

        this.waterLavaTexture.dispose();
        this.peopleTexture.dispose();
        this.grassTexture1.dispose();
        this.trambolineTexture.dispose();
        this.goalieTexture.dispose();
        this.pipeTexture.dispose();

    }

    // manage moving elements
    public void movingElements(){

        // Check user
        if (this.gamer.equals("Anastasia")){
            this.goalieTexture = new Texture(Gdx.files.internal("background_images/unicorn.png"));
            this.pipeTexture = new Texture(Gdx.files.internal("background_images/pipe.png"));
        } else {
            this.goalieTexture = new Texture(Gdx.files.internal("background_images/red_ball.png"));
            this.pipeTexture = new Texture(Gdx.files.internal("background_images/blue_pipe.png"));
        }
        this.goalieSprite = new Sprite(this.goalieTexture);
        this.pipeSprite = new Sprite(this.pipeTexture);

        if (this.pipeRotation > 70 || this.pipeRotation < -70){
            this.pipeSpeed *= -1;
        }
        this.pipeRotation += this.pipeSpeed;
        this.pipeSprite.setRotation(this.pipeRotation);
        this.utilities.setSpritePosSizeDraw(this.game, this.pipeSprite, 300, 830, 50, 250);


        // Different goalie move
        if (this.gamer.equals("Anastasia")){
            this.utilities.setSpritePosSizeDraw(this.game, this.goalieSprite, 1400, this.goalieY, 150, 100);

            if (this.goalieY > 300 || this.goalieY < 50){
                this.goalieSpeed *= -1;
            }


        } else {
            this.utilities.setSpritePosSizeDraw(this.game, this.goalieSprite, 1400, this.goalieY, 160, 160);
            if (this.goalieY > 800 || this.goalieY < 50){
                this.goalieSpeed *= -1;
            }

        }

        this.goalieY += this.goalieSpeed;

    }

    @Override
    public void show(){

        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // Two minutes per game
        this.timeRemaining = 2 * 60;
        this.timeLapsed = 0;
        this.previousTime = 0;

        // Moving elements initial positions
        this.goalieY = 50;
        this.pipeRotation = 0;
        this.pipeSpeed = 1;

        if (this.gamer.equals("William")){
            this.goalieSpeed = 15;
        }

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

        if (timeRemaining > 0){
            timeLapsed += Gdx.graphics.getDeltaTime();
            timeRemaining -= Gdx.graphics.getDeltaTime();
        }

        this.game.batch.begin();

        // Populate Graphics
        this.populatePlayerGraphics(timeRemaining, timeLapsed);

        int remMin = (int) (timeRemaining/60);
        int remSec = (int) (timeRemaining % 60);
        font.getData().setScale(2f);
        font.draw(game.batch, String.format("%02d:%02d", remMin, remSec), 1000, 800);

        // Moving elements
        this.movingElements();

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
