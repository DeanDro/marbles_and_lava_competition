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
import marbles_and_lava_compeition.git.graphics.Dashboard1;

import java.util.ArrayList;

public class IntroPage extends ScreenAdapter {

    public Main game;
    public Stage stage = new Stage();
    public BitmapFont font = new BitmapFont();
    public Skin skin = new Skin(Gdx.files.internal("data/comic/skin/comic-ui.json"));
    private CountriesPopulation utilities = new CountriesPopulation();
    public String gamer;

    // Countries list
    private String[] allCountries = {"Argentina", "Brazil", "Canada", "UK", "Madagascar", "Sweden",
                                    "Italy", "Norway", "Switzerland", "Spain", "China", "India",
                                    "Greece", "Ireland", "Germany", "Iceland", "France", "Portugal",
                                    "Belgium", "Mexico", "Japan", "South_Africa", "United_States", "Australia",
                                    "Vietnam", "New_Zealand", "Netherlands", "Denmark", "Chile", "Belgium",
                                    "South_Korea", "Malta"};

    private String[] countries = utilities.randomizeElementsOrder(allCountries);

    private Sprite[] spriteCountries = new Sprite[32];
    private Texture[] textureCountries = new Texture[32];
    private Label[] countryLabels = new Label[32];
    private Marbles[] countriesMarbles = new Marbles[32];



    public IntroPage(Main game, String gamer){
        this.game = game;
        this.gamer = gamer;
        this.populateMarblesData();
    }

    private void populateMarblesData(){
        for (int i = 0; i< this.countries.length; i++){
            this.countriesMarbles[i] = new Marbles(this.countries[i], this.skin);
        }

        for (int j = 0; j < this.countriesMarbles.length; j++){
            this.textureCountries[j] = this.countriesMarbles[j].getTexture();
            this.spriteCountries[j] = this.countriesMarbles[j].getCircleSpriteNoPos(50, 50);
            this.countryLabels[j] = this.countriesMarbles[j].getLabelNoPos();
        }
    }

    private void populateLabels(int x, int y, Stage stage){

        int xCounter = 0;
        int groupCounter = 1;
        int yCoord = y;
        int xCoord = x;
        int secRowY = 0;

        for (int i = 0; i < this.countries.length; i++){

            if (xCounter == 0) {
                Label group = new Label("Group " + groupCounter, this.skin);
                group.setPosition(xCoord, yCoord);
                group.setFontScale(1.5f);
                stage.addActor(group);
                xCounter += 1;
                yCoord -= 40;
                xCoord += 60;
            }

            if (xCounter < 5){
                this.countryLabels[i].setPosition(xCoord, yCoord);
                stage.addActor(this.countryLabels[i]);
                yCoord -= 60;
                xCounter += 1;
            }

            if (xCounter == 5){
                groupCounter += 1;
                if (groupCounter < 7) {
                    xCounter = 0;
                    xCoord += 190;
                    yCoord = y;
                } else if (groupCounter == 7) {
                    xCounter = 0;
                    xCoord = x;
                    secRowY = yCoord - 60;
                    yCoord = secRowY;
                } else {
                    xCounter = 0;
                    xCoord += 190;
                    yCoord = secRowY;
                }
            }

        }
    }

    private void populateSprite(int x, int y){

        int xCounter = 0;
        int yCoord = y;
        int xCoord = x;
        int groupCounter = 1;
        int ySecRow = y;

        for (int i = 0; i < this.countries.length; i++){

            if (xCounter < 4){
                this.spriteCountries[i].setPosition(xCoord, yCoord);
                this.spriteCountries[i].draw(this.game.batch);
                yCoord -= 60;
                xCounter += 1;
            }

            if(xCounter == 4){
                xCounter = 0;
                xCoord += 250;
                yCoord = ySecRow;
                groupCounter += 1;
            }

            if (groupCounter == 7 && xCounter == 0){
                xCoord = x;
                ySecRow = y - 330;
                yCoord = ySecRow;
            }
        }

    }

    private void disposeTextures(){
        for (Texture texture : this.textureCountries){
            texture.dispose();
        }
    }

    @Override
    public void show(){

        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // Setup
        Label pageTitle = new Label("Competing Groups", this.skin);
        pageTitle.setFontScale(3f);
        pageTitle.setPosition(100, 900);

        this.populateLabels(50, 820, this.stage);

        this.stage.addActor(pageTitle);

        TextButton startGame = new TextButton("Start", this.skin);
        startGame.setPosition(800, 200);
        startGame.setSize(250, 100);
        startGame.setColor(Color.WHITE);

        // Add a listener to handle button clicks
        startGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Dashboard1(game, countries, gamer));
            }
        });

        this.stage.addActor(startGame);

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


        this.populateSprite(50, 750);

        this.stage.draw();
        this.game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
        this.stage.dispose();

        // Marbles groups
        this.disposeTextures();
    }

}
