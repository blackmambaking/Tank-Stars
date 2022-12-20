package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Background;
import com.mygdx.game.Button;
import com.mygdx.game.MainClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import static com.mygdx.game.Screens.MainGameScreen.pl1;
import static com.mygdx.game.Screens.MainGameScreen.pl2;
import static java.lang.System.exit;

public class ResultScreen implements Screen {

    private MainClass mainClass;
    private SpriteBatch batch;
    private Texture img;
    private Texture img1;
    private Texture img2;
    private Texture img3;
    private Texture img4;
    private Texture img5;
    private Texture img6;
    private Texture img7;
    private Background background;

    private Button ld1;
    private Button ld2;
    private Button ld3;
    private Button ld4;
    private Button save;
    private Button quit;
    private Button resume;
    private BitmapFont font;
    private BitmapFont font1;
    private BitmapFont font2;

    private Drawable drawable;
    private ImageButton playButton;
    private Vector2 position;
    private Vector2 position1;
    private Vector2 position2;
    private Vector2 position3;
    private Vector2 position4;
    private Vector2 position5;
    private Vector2 position6;
    private Vector2 position7;
    private Vector2 position8;

    public ResultScreen(MainClass mainClass) {
        this.mainClass = mainClass;
        batch = new SpriteBatch();
        img = new Texture("bgm4.png");
        img1 = new Texture("ld.png");
        img2= new Texture("ld.png");
        img3 = new Texture("ld.png");
        img4 = new Texture("a.jpg");
        img5= new Texture("saveA.png");
        img6 = new Texture("quitA.png");
        img7 = new Texture("resumeA.png");
        background = new Background(img);
        ld1 = new Button(img1);
        ld2 = new Button(img2);
        ld3 = new Button(img3);
        ld4 = new Button(img4);
        save = new Button(img5);
        resume = new Button(img7);
        quit = new Button(img6);
        drawable = new TextureRegionDrawable(img5);
        playButton =  new ImageButton(drawable);
        position = new Vector2(0,-100);
        position2 = new Vector2(0,100);
        position3 = new Vector2(0,300);
        position4 = new Vector2(0,0);
        position5 = new Vector2(200,-450);
        font = new BitmapFont();
        font1 = new BitmapFont();
        font2 = new BitmapFont();
        position6 = new Vector2(-60,50);
        position7 = new Vector2(-60,250);
        position8 = new Vector2(-60,150);
    }

    @Override
    public void show() {


        background.getSprite().setScale(1);

        playButton.getImage().setScale(0.2F);


        ld1.getSprite().setScale(1F, 0.4F);
        ld2.getSprite().setScale(1F, 0.4F);
        ld3.getSprite().setScale(1F, 0.4F);
        save.getSprite().setScale(1F, 0.4F);
        quit.getSprite().setScale(1F, 0.4F);
        resume.getSprite().setScale(1F, 0.4F);
        ld4.getSprite().setScale(0.45F, 0.5F);

        ld1.setPosition(position);
        ld2.setPosition(position2);
        ld3.setPosition(position3);
        ld4.setPosition(position5);
        background.setPosition(position4);

        font.getData().setScale(1);
        font1.getData().setScale(1);
        font2.getData().setScale(1);

        quit.getSprite().setScale(1.2F);
        save.getSprite().setScale(1.2F);
        resume.getSprite().setScale(1.2F);
        quit.setPosition(position6);
        save.setPosition(position7);
        resume.setPosition(position8);
//        Stage stage = new Stage();
//        Gdx.input.setInputProcessor(stage);
//        stage.addActor(playButton);


    }

    @Override
    public void render(float delta) {

        batch.begin();
        background.draw(batch);
//        ld1.draw(batch);
//        ld2.draw(batch);
//        ld3.draw(batch);
        ld4.draw(batch);
        quit.draw(batch);
        resume.draw(batch);
        save.draw(batch);
//        font.draw(batch, "SAVE", 250, 520);
//        font1.draw(batch, "EXIT", 250, 320);
//        font2.draw(batch, "RESUME", 250, 120);
//        font.getData().setScale(2);
//        font1.getData().setScale(2);
//        font2.getData().setScale(2);
        //playButton.draw(batch, 1);
        batch.end();

        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            mainClass.setScreen(new MainGameScreen(mainClass));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            mainClass.setScreen(new MainMenu(mainClass));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){

            //saving the state of the game

        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();


    }

}
