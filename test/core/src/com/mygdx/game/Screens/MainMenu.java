package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Background;
import com.mygdx.game.Button;
import com.mygdx.game.MainClass;

import java.io.Serializable;

import static java.lang.System.exit;

public class MainMenu implements Screen {
    private MainClass mainClass;

    private SpriteBatch batch;
    private Texture img;
    private Texture img1;
    private Texture img2;
    private Texture img3;
    private Background background;
    private Button newGame;
    private Button resumeGame;
    private Button exit;
    private ImageButton newG;
    private Drawable drawable;

    private Vector2 position;
    private Vector2 position2;
    private Vector2 position3;
    private Vector2 position4;
    public MainMenu(MainClass mainClass) {
        this.mainClass = mainClass;
        batch = new SpriteBatch();
        img = new Texture("logo3.jpg");
        img1 = new Texture("newA.png");
        img2= new Texture("loadA.png");
        img3 = new Texture("exitA.png");
        background = new Background(img);
        newGame = new Button(img1);
        resumeGame = new Button(img2);
        exit = new Button(img3);
        position = new Vector2(70,-150);
        position2 = new Vector2(270,-150);
        position3 = new Vector2(470,-150);
        position4 = new Vector2(0,20);
        drawable = new TextureRegionDrawable(new TextureRegion(img1));
        newG = new ImageButton(drawable);
    }

    @Override
    public void show() {
        newGame.setPosition(position);
        resumeGame.setPosition(position2);
        exit.setPosition(position3);
        newGame.getSprite().setScale(1.2F);
        resumeGame.getSprite().setScale(1.2F);
        exit.getSprite().setScale(1.2F);
        background.setPosition(position4);
        background.getSprite().setScale(1.2F);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        background.draw(batch);
        //newG.draw(batch, 1);
        newGame.draw(batch);
        resumeGame.draw(batch);
        exit.draw(batch);
        batch.end();
        if(Gdx.input.isKeyJustPressed(Input.Keys.N)){
            mainClass.setScreen(new SelectTank(mainClass));
        }if(Gdx.input.isKeyJustPressed(Input.Keys.L)){
            mainClass.setScreen(new LoadGameMenu(mainClass));
        }if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
            exit(0);
        }if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
            mainClass.setScreen(new SplashScreen(mainClass));
        }
        if(Gdx.input.isTouched()){
            if(newGame.getSprite().getBoundingRectangle().contains((float)Gdx.input.getX(),(float)Gdx.input.getY())){
                mainClass.setScreen(new SelectTank(mainClass));
            }
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

    }


}
