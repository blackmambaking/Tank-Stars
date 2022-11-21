package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Background;
import com.mygdx.game.Button;
import com.mygdx.game.MainClass;
import com.mygdx.game.MainGameHelper.*;

import java.util.Random;

public class MainGameScreen implements Screen {
    private final MainClass mainClass;
    private SpriteBatch batch;
    private Random rn = new Random();

    private Texture img;
    private Texture img2;
    private Texture img3;
    private Texture img4;
    private Texture img5;
    private Texture img6;
    private Texture img7;
    private Texture img8;
    private Texture img9;
    private Texture img10;
    private Player1 player1;
    private Player2 player2;
    private Background background;
    private Health health;
    private Health2 health2;
    private Terrain terrain;
    private SineTerm sineTerm;
    private SineTerm sineTerm2;
    private ShapeRenderer shapeRenderer;
    private ShapeRenderer shapeRenderer2;
    private Button pause;

    private int score = 0;
    private int a;
    private int b;

    public MainGameScreen(MainClass mainClass) {
        this.mainClass = mainClass;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer2 = new ShapeRenderer();


        img = new Texture("bgm2.png");
        img2 = new Texture("tank2.png");
        img3 = new Texture("laser.png");
        img4 = new Texture("full.png");
        img5 = new Texture("full.png");
        img6 = new Texture("terrain.png");

        img7 = new Texture("fire.png");
        img8 = new Texture("abr.png");
        img9 = new Texture("laser2.png");
        img10 = new Texture("pause.png");
        player1 = new Player1(img2, img3);
        player2 = new Player2(img8, img9);
        pause = new Button(img10);

        Vector2 position = new Vector2(-100,100);
        Vector2 position2 = new Vector2(300,100);
        Vector2 position3 = new Vector2(350,390);
        player1.setPosition(position);
        player2.setPosition(position2);
        pause.setPosition(position3);
        pause.getSprite().setScale(0.1F);


        background = new Background(img);
        health = new Health(img4 );
        health2 = new Health2(img5);
        sineTerm = new SineTerm(1, 1/2, 0);
        sineTerm2 = new SineTerm(2, 1/5, 2);


    }

    @Override
    public void render(float delta) {
        try{
            ScreenUtils.clear(0, 0, 0, 1);
            batch.begin();
            background.draw(batch);
            player1.draw(batch);
            player2.draw(batch);
            health.draw(batch);
            health2.draw(batch);
            pause.draw(batch);
            batch.end();
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.BLACK);
            shapeRenderer.circle(00 , -800, 1000);
            shapeRenderer.end();
            shapeRenderer2.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer2.setColor(Color.BLACK);
            shapeRenderer2.circle(800 , -700, 1000);
            shapeRenderer2.end();
            if(Gdx.input.isKeyJustPressed(Input.Keys.P)){
                mainClass.setScreen(new PauseMenu(mainClass));
            }

        }catch (Exception e){
            System.out.println("Error");

        }

        //batch.draw(img, 0, 0);
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
        img.dispose();

    }
}
