package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Background;
import com.mygdx.game.Button;
import com.mygdx.game.MainClass;
import jdk.tools.jmod.Main;

import java.io.Serializable;

public class SelectTank implements Screen {
    private final MainClass mainClass;
    private SpriteBatch batch;
    private Texture img;
    private Texture img1;
    private Texture img2;
    private Texture img3;
    private Texture img4;
    private Texture img5;
    private Background background;


    private Button select;

    private Button tank1;
    private Button tank2;
    private Button tank3;
    private ShapeRenderer shapeRenderer;

    private Vector2 pos;
    private Vector2 posB;
    private Vector2 position2;
    private Vector2 position4;
    private Vector2 position;


    public SelectTank(MainClass mainClass) {
        this.mainClass = mainClass;
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();

        img1 = new Texture("bgm2.png");
        img2= new Texture("start.png");
        img3 = new Texture("tank3.gif");
        img4 = new Texture("tank2.png");
        img5 = new Texture("abr.png");
        background = new Background(img1);
        select = new Button(img2);
        tank1 = new Button(img4);
        tank2 = new Button(img5);
        tank3 = new Button(img3);
        position2 = new Vector2(Gdx.graphics.getWidth()/2 - 260,-150);
        position4 = new Vector2(0,0);
        //position4 = new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        pos = new Vector2(-200,130);
        posB = new Vector2(750,40);
        position = new Vector2(140,130);

    }

    @Override
    public void show() {


        tank1.getSprite().setScale(0.75F, 0.75F);
        tank2.getSprite().setScale(0.75F, 0.75F);
        tank3.getSprite().setScale(0.75F, 0.75F);

        select.setPosition(position2);
        select.getSprite().setScale((float) 0.5, (float) 0.5);

        tank1.setPosition(pos);
        tank2.setPosition(posB);
        tank3.setPosition(position);
        background.setPosition(position4);

    }

    @Override
    public void render(float delta) {

        batch.begin();
        background.draw(batch);

        tank1.draw(batch);
        tank2.draw(batch);
        tank3.draw(batch);

        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(0,0,5000,200);
        shapeRenderer.end();
        batch.begin();
        select.draw(batch);
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
