package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Background;
import com.mygdx.game.Button;
import com.mygdx.game.MainClass;

public class SelectTank2 implements Screen {
    private final MainClass mainClass;
    private SpriteBatch batch;
    private Texture img;
    private Texture img1;
    private Texture img2;
    private Texture img3;
    private Texture img4;
    private Texture img5;
    private Background background;

    private Button prev;
    private Button select;
    private Button next;
    private Button prev2;

    private Button next2;

    private Button tank1;
    private Button tank2;
    private Button tank3;


    public SelectTank2(MainClass mainClass) {
        this.mainClass = mainClass;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
//        img = new Texture("prev.png");
        img1 = new Texture("bgm2.png");
        img2= new Texture("start.png");
        img3 = new Texture("tank3.gif");
        img4 = new Texture("tank2.png");
        img5 = new Texture("abr.png");
        background = new Background(img1);
        //prev = new Button(img);
        select = new Button(img2);
        //next = new Button(img3);
        //  prev2 = new Button(img);
        tank1 = new Button(img4);
        tank2 = new Button(img5);
        tank3 = new Button(img3);

        tank1.getSprite().setScale(0.75F, 0.75F);
        tank2.getSprite().setScale(0.75F, 0.75F);
        tank3.getSprite().setScale(0.75F, 0.75F);

        // next2 = new Button(img3);


        Vector2 position2 = new Vector2(Gdx.graphics.getWidth()/2 - 260,-190);
        Vector2 position3 = new Vector2(200,100);

        Vector2 positionB = new Vector2(400,100);

        Vector2 position3B = new Vector2(700,100);

        Vector2 position4 = new Vector2(0,0);
//        prev.setPosition(position);
        select.setPosition(position2);
        select.getSprite().setScale((float) 0.5, (float) 0.5);

        Vector2 pos = new Vector2(-200,140);
        Vector2 posB = new Vector2(750,40);
        Vector2 position = new Vector2(140,130);

        tank1.setPosition(pos);
        tank2.setPosition(posB);
        tank3.setPosition(position);

//        next.setPosition(position3);

//        prev2.setPosition(positionB);
//
//        next2.setPosition(position3B);
//
//        prev.getSprite().flip(true, false);
//        prev2.getSprite().flip(true, false);
        background.setPosition(position4);

    }

    @Override
    public void render(float delta) {
        batch.begin();
        background.draw(batch);
//        prev.draw(batch);
        select.draw(batch);
//        next.draw(batch);
//        prev2.draw(batch);
        tank1.draw(batch);
        tank2.draw(batch);
        tank3.draw(batch);

        //next2.draw(batch);
        batch.end();
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            mainClass.setScreen(new MainGameScreen(mainClass));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.B)){
            mainClass.setScreen(new MainMenu(mainClass));
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
