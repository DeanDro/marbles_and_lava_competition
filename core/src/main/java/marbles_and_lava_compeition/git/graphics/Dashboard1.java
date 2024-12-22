package marbles_and_lava_compeition.git.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
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
import marbles_and_lava_compeition.git.utilities.Marbles;

// Generic libs
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.Random;


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
    public int sessionTime;
    private int totalBalls;
    private int currentBallCounter;
    private int ballsInGame;
    private ArrayList<Sprite> elements;
    private boolean gameOn;

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
    private Marbles marble1;
    private Marbles marble2;
    private Marbles marble3;
    private Marbles marble4;

    // Movement components elements
    private int goalieSpeed = 1;
    private int goalieY;
    private int pipeSpeed;
    private int pipeRotation;

    // Session for each game
    // In String array element breakdown is -> 0: Country name, 1: Active/Inactive, 2: posX, 3: posY, 4: speedX, 5: speedY
    private String[] marblesGame = {"Off", "Off", "Off", "Off"};
    private int[] ballsSpeedX = {4, 4, 4, 4};
    private int[] ballsSpeedY = {4, 4, 4, 4};
    private int minY = 700;
    private int maxY = 900;
    private int minX = 200;
    private int maxX = 400;
    private Random random;



    public Dashboard1(Main game, String[] groups, String gamer){
        this.game = game;
        this.countriesGroups = groups;
        this.winners = new String[(groups.length)/2];  // Only half of the marbles will be making it to the next round
        this.gamer = gamer;
        this.currentBallCounter = 0;
        this.totalBalls = countriesGroups.length;
        this.elements = new ArrayList<>();
        this.gameOn = true;
        this.ballsInGame = 0;
        this.random = new Random();
    }

    // Creates the dashboard according to the player
    public void populatePlayerGraphics(){

        // Elements for everyone
        this.grassTexture1 = new Texture(Gdx.files.internal("background_images/grass.png"));
        this.trambolineTexture = new Texture(Gdx.files.internal("background_images/tranpolin.png"));
        this.trambolineSprite = new Sprite(this.trambolineTexture);

        if (this.gamer.equals("Anastasia")){
            this.peopleTexture = new Texture(Gdx.files.internal(BACKGROUND_IMAGES_KIDS_CHEERING_4_PNG));
            this.waterLavaTexture = new Texture(Gdx.files.internal("background_images/water.png"));
            this.waterLavaSprite = new Sprite(this.waterLavaTexture);
            this.utilities.setSpritePosSize(this.game, this.waterLavaSprite, 170, 0, 280, 50);
            this.elements.add(this.waterLavaSprite);

            this.grassSprite1 = new Sprite(this.grassTexture1);
            this.utilities.setSpritePosSize(this.game, this.grassSprite1, 450, 0, 1170, 50);
            this.elements.add(this.grassSprite1);

            this.netTexture = new Texture(Gdx.files.internal("background_images/nett.png"));
            this.netSprite = new Sprite(this.netTexture);
            this.utilities.setSpritePosSize(this.game, this.netSprite, 1570, 50, 50, 300);
            this.elements.add(this.netSprite);

            this.trambolineSprite.setRotation(-50f);
            this.utilities.setSpritePosSize(this.game, this.trambolineSprite, 25, 10, 300, 100);
            this.elements.add(this.trambolineSprite);

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

            this.utilities.setSpritePosSize(this.game, this.waterLavaSprite, 400, 0, 300, 50);
            this.utilities.setSpritePosSize(this.game, this.waterLavaSprite2, 900, 0, 200, 50);
            this.utilities.setSpritePosSize(this.game, this.waterLavaSprite3, 1300, 0, 320, 50);
            this.utilities.setSpritePosSize(this.game, this.waterLavaSprite4,1550, 200, 70, 150);
            this.utilities.setSpritePosSize(this.game, this.waterLavaSprite5, 1550, 500, 70, 150);
            this.utilities.setSpritePosSize(this.game, this.waterLavaSprite6, 1550, 800, 70, 160);
            this.elements.add(this.waterLavaSprite);
            this.elements.add(this.waterLavaSprite2);
            this.elements.add(this.waterLavaSprite3);
            this.elements.add(this.waterLavaSprite4);
            this.elements.add(this.waterLavaSprite5);
            this.elements.add(this.waterLavaSprite6);

            this.utilities.setSpritePosSize(this.game, this.grassSprite1, 170, 0, 230, 50);
            this.utilities.setSpritePosSize(this.game, this.grassSprite2, 700, 0, 200, 50);
            this.utilities.setSpritePosSize(this.game, this.grassSprite3, 1100, 0, 200, 50);
            this.elements.add(this.grassSprite1);
            this.elements.add(this.grassSprite2);
            this.elements.add(this.grassSprite3);

            this.trambolineSprite.setRotation(-50f);
            this.utilities.setSpritePosSize(this.game, this.trambolineSprite, 30, 30, 300, 120);
            this.elements.add(this.trambolineSprite);

            this.pointsTexture = new Texture(Gdx.files.internal("background_images/points.png"));
            this.pointsSprite = new Sprite(this.pointsTexture);
            this.pointsSprite2 = new Sprite(this.pointsTexture);
            this.pointsSprite3 = new Sprite(this.pointsTexture);
            this.utilities.setSpritePosSize(this.game, this.pointsSprite, 1550, 50, 70, 150);
            this.utilities.setSpritePosSize(this.game, this.pointsSprite2, 1550, 350, 70, 150);
            this.utilities.setSpritePosSize(this.game, this.pointsSprite3, 1550, 650, 70, 150);
            this.elements.add(this.pointsSprite);
            this.elements.add(this.pointsSprite2);
            this.elements.add(this.pointsSprite3);

            Label pointsMark1 = new Label("+2", this.skin);
            pointsMark1.setFontScale(3f);
            pointsMark1.setColor(Color.BLACK);
            pointsMark1.setPosition(1560, 110);
            this.stage.addActor(pointsMark1);

            Label pointsMark2 = new Label("+4", this.skin);
            pointsMark2.setFontScale(3f);
            pointsMark2.setColor(Color.BLACK);
            pointsMark2.setPosition(1560, 460);
            this.stage.addActor(pointsMark2);

            Label pointsMark3 = new Label("+8", this.skin);
            pointsMark3.setFontScale(3f);
            pointsMark3.setColor(Color.BLACK);
            pointsMark3.setPosition(1560, 760);
            this.stage.addActor(pointsMark3);

        }

        this.peopleSprite = new Sprite(this.peopleTexture);
        this.utilities.setSpritePosSize(this.game, this.peopleSprite, 600, 200, 400, 400);
        this.elements.add(this.peopleSprite);

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

        // Marbles
        this.ballTexture1.dispose();
        this.ballTexture2.dispose();
        this.ballTexture3.dispose();
        this.ballTexture4.dispose();

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

    // Check game status. Returns false if game is over and true if we are still playing
    public boolean gameStatus(){
        return gameOn || this.currentBallCounter != this.totalBalls;
    }

    // Load marbles in the game
    public void loadMarbles(){
        //if (this.currentBallCounter < this.totalBalls && this.ballsInGame < 4){

            this.marble1 = new Marbles(this.countriesGroups[this.currentBallCounter], this.skin);
            this.ballTexture1 = this.marble1.getTexture();
            this.ballSprite1 = new Sprite(this.ballTexture1);
            int x = random.nextInt(this.maxX - this.minX + 1) + this.minX;
            int y = random.nextInt(this.maxY - this.minY) + this.minY;
            this.ballSprite1.setPosition(x, y);
            this.ballSprite1.setSize(50, 50);
            this.currentBallCounter++;

            this.marble2 = new Marbles(this.countriesGroups[this.currentBallCounter], this.skin);
            this.ballTexture2 = this.marble2.getTexture();
            this.ballSprite2 = new Sprite(this.ballTexture2);
            x = random.nextInt(this.maxX - this.minX + 1) + this.minX;
            y = random.nextInt(this.maxY - this.minY) + this.minY;
            this.ballSprite2.setPosition(x, y);
            this.ballSprite2.setSize(50, 50);
            this.currentBallCounter++;

            this.marble3 = new Marbles(this.countriesGroups[this.currentBallCounter], this.skin);
            this.ballTexture3 = this.marble3.getTexture();
            this.ballSprite3 = new Sprite(this.ballTexture3);
            x = random.nextInt(this.maxX - this.minX + 1) + this.minX;
            y = random.nextInt(this.maxY - this.minY) + this.minY;
            this.ballSprite3.setPosition(x, y);
            this.ballSprite3.setSize(50, 50);
            this.currentBallCounter++;

            this.marble4 = new Marbles(this.countriesGroups[this.currentBallCounter], this.skin);
            this.ballTexture4 = this.marble4.getTexture();
            this.ballSprite4 = new Sprite(this.ballTexture4);
            x = random.nextInt(this.maxX - this.minX + 1) + this.minX;
            y = random.nextInt(this.maxY - this.minY) + this.minY;
            this.ballSprite4.setPosition(x, y);
            this.ballSprite4.setSize(50, 50);
            this.currentBallCounter++;

            this.ballsInGame = 4;
        //}

    }

    // Method to handle marbles
    public void addMarblesInGame(int second){

        // We are able to add marbles only when second of game are divided by 4
        if (this.gameStatus()){

            this.marblesMovement();

            this.utilities.setSpritePosSizeDraw(this.game, this.ballSprite1, (int) this.ballSprite1.getX(),
                (int) this.ballSprite1.getY(), 50, 50);

            this.utilities.setSpritePosSizeDraw(this.game, this.ballSprite2, (int) this.ballSprite2.getX(),
                (int) this.ballSprite2.getY(), 50, 50);

            this.utilities.setSpritePosSizeDraw(this.game, this.ballSprite3, (int) this.ballSprite3.getX(),
                (int) this.ballSprite3.getY(), 50, 50);

            this.utilities.setSpritePosSizeDraw(this.game, this.ballSprite4, (int) this.ballSprite4.getX(),
                (int) this.ballSprite4.getY(), 50, 50);

        }

    }

    // Update marbles location
    public void updateMarblesLocation(Sprite sprite, float posX, float posY, int speedX, int speedY){
        float newPosX = posX + speedX;
        float newPosY = posY + speedY;
        sprite.setPosition(newPosX, newPosY);
    }

    // Marbles movement
    public void marblesMovement(){

        float ball1X = this.ballSprite1.getX();
        float ball1Y = this.ballSprite1.getY();
        float ball2X = this.ballSprite2.getX();
        float ball2Y = this.ballSprite2.getY();
        float ball3X = this.ballSprite3.getX();
        float ball3Y = this.ballSprite3.getY();
        float ball4X = this.ballSprite4.getX();
        float ball4Y = this.ballSprite4.getY();

        if (ball1X < 0 || ball1X > 1570){
            this.ballsSpeedX[0] *= -1;
        }
        if (ball1Y < 50 || ball1Y > 910){
            this.ballsSpeedY[0] *= -1;
        }
        if (ball2X < 0 || ball2X > 1570){
            this.ballsSpeedX[1] *= -1;
        }
        if (ball2Y < 50 || ball2Y > 910){
            this.ballsSpeedY[1] *= -1;
        }
        if (ball3X < 0 || ball3X > 1570){
            this.ballsSpeedX[2] *= -1;
        }
        if (ball3Y < 50 || ball3Y > 910){
            this.ballsSpeedY[2] *= -1;
        }
        if (ball4X < 0 || ball4X > 1570){
            this.ballsSpeedX[3] *= -1;
        }
        if (ball4Y < 50 || ball4Y > 910){
            this.ballsSpeedY[3] *= -1;
        }

        this.updateMarblesLocation(this.ballSprite1, ball1X, ball1Y, this.ballsSpeedX[0], this.ballsSpeedY[0]);
        this.updateMarblesLocation(this.ballSprite2, ball2X, ball2Y, this.ballsSpeedX[1], this.ballsSpeedY[1]);
        this.updateMarblesLocation(this.ballSprite3, ball3X, ball3Y, this.ballsSpeedX[2], this.ballsSpeedY[2]);
        this.updateMarblesLocation(this.ballSprite4, ball4X, ball4Y, this.ballsSpeedX[3], this.ballsSpeedY[3]);
    }


    @Override
    public void show(){

        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // Two minutes per game
        this.timeRemaining = 2 * 60;
        this.timeLapsed = 0;

        // Tracking session time
        this.sessionTime = 130;

        // Adding stable elements
        this.populatePlayerGraphics();

        // Moving elements initial positions
        this.goalieY = 50;
        this.pipeRotation = 0;
        this.pipeSpeed = 1;

        if (this.gamer.equals("William")){
            this.goalieSpeed = 10;
        }

        this.loadMarbles();

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
        //this.populatePlayerGraphics();
        this.utilities.drawSpriteElements(this.elements, this.game);

        int remMin = (int) (timeRemaining/60);
        int remSec = (int) (timeRemaining % 60);
        font.getData().setScale(2f);
        font.draw(game.batch, String.format("%02d:%02d", remMin, remSec), 1000, 800);

        // Moving elements
        this.movingElements();

        // Marbles
        this.addMarblesInGame(remSec);
        //this.marblesMovement();


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
