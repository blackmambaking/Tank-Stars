package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Background;
import com.mygdx.game.Button;
import com.mygdx.game.MainClass;

public class MainMenu implements Screen {
    MainClass mainClass;
    private SpriteBatch batch;
    private Texture img;
    private Texture img1;
    private Texture img2;
    private Texture img3;
    private Background background;

    private Button newGame;
    private Button resumeGame;
    private Button exit;
    public MainMenu(MainClass mainClass) {
        this.mainClass = mainClass;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture("logo3.jpg");
        img1 = new Texture("new.png");
        img2= new Texture("load.png");
        img3 = new Texture("exit.png");
        background = new Background(img);
        newGame = new Button(img1);
        resumeGame = new Button(img2);
        exit = new Button(img3);
        Vector2 position = new Vector2(300,100);
        Vector2 position2 = new Vector2(500,100);
        Vector2 position3 = new Vector2(700,100);
        Vector2 position4 = new Vector2(0,20);
        newGame.setPosition(position);
        resumeGame.setPosition(position2);
        exit.setPosition(position3);
        background.setPosition(position4);

    }

    @Override
    public void render(float delta) {
        batch.begin();
        background.draw(batch);
        newGame.draw(batch);
        resumeGame.draw(batch);
        exit.draw(batch);
        batch.end();
//        if(newGameClick ==1 ){
//
//
//        }
//        else if(exitGameClick == 1){
//
//        }
//        else if(resumeGameClick ==1){
//
//        }


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
