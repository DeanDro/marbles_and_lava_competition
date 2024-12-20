package marbles_and_lava_compeition.git.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Marbles {

    private Texture imgTexture;
    private Sprite imgSprite;
    private String name;
    private Skin skin;
    private String[] countries;

    public Marbles(String filename, String name, Skin skin){
        this.name = name;
        this.imgTexture = new Texture(Gdx.files.internal(filename));
        this.skin = skin;
        this.imgSprite = new Sprite(this.imgTexture);
    }

    // Overloading constructor
    public Marbles(String name, Skin skin){
        this.name = name;
        this.skin = skin;
        this.imgTexture = this.getTexture(name);
        this.imgSprite = new Sprite(this.imgTexture);
    }

    // Get Texture
    private Texture getTexture(String name){
        String filePath = "images/flags/"+name.toLowerCase()+"_circle.png";
        return new Texture(Gdx.files.internal(filePath));

    }

    // Get a label with the name of the country at positions x and y
    public Label getLabel(int x, int y){
        Label country = new Label(this.name, this.skin);
        country.setFontScale(1f);
        country.setPosition(x, y);

        return country;
    }

    // Get the circle with the img
    public Sprite getCircleSprite(int x, int y, int width, int height){
        this.imgSprite.setPosition(x, y);
        this.imgSprite.setSize(width, height);

        return this.imgSprite;
    }

    // Get the circle with img without a specific loc set
    public Sprite getCircleSpriteNoPos(int width, int height){
        this.imgSprite.setSize(width, height);
        return this.imgSprite;
    }

    public Label getLabelNoPos(){
        Label country = new Label(this.name, this.skin);
        country.setFontScale(1f);

        return country;
    }

    // return texture
    public Texture getTexture(){
        return this.imgTexture;
    }

    // Set position for Sprite
    public void setImgSpritePos(int x, int y){
        this.imgSprite.setPosition(x, y);
    }

    public Sprite getImgSprite(){
        return this.imgSprite;
    }


}
