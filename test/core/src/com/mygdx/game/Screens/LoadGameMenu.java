package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Background;
import com.mygdx.game.Button;
import com.mygdx.game.MainClass;

import javax.swing.text.View;

import java.io.Serializable;

import static java.lang.System.exit;

public class LoadGameMenu implements Screen {
    private final MainClass mainClass;
    private SpriteBatch batch;
    private Texture img;
    private Texture img1;
    private Texture img2;
    private Texture img3;
    private Texture img4;
    private Background background;

    private Button ld1;
    private Button ld2;
    private Button ld3;
    private Button ld4;
    private BitmapFont font;
    private BitmapFont font1;
    private BitmapFont font2;

    private Vector2 position;
    private Vector2 position2;
    private Vector2 position3;
    private Vector2 position4;
    private Vector2 position5;

    public LoadGameMenu(MainClass mainClass) {

        this.mainClass = mainClass;
        batch = new SpriteBatch();
        img = new Texture("bgm3.png");
        img1 = new Texture("ld.png");
        img2= new Texture("ld.png");
        img3 = new Texture("ld.png");
        img4 = new Texture("a.jpg");
        background = new Background(img);
        ld1 = new Button(img1);
        ld2 = new Button(img2);
        ld3 = new Button(img3);
        ld4 = new Button(img4);
        font = new BitmapFont();
        font1 = new BitmapFont();
        font2 = new BitmapFont();
        position = new Vector2(0,-100);
        position2 = new Vector2(0,100);
        position3 = new Vector2(0,300);
        position4 = new Vector2(0,0);
        position5 = new Vector2(210,-450);
    }

    @Override
    public void show() {

        background.getSprite().setScale(1);

        ld1.getSprite().setScale(1F, 0.4F);
        ld2.getSprite().setScale(1F, 0.4F);
        ld3.getSprite().setScale(1F, 0.4F);
        ld4.getSprite().setScale(0.45F, 0.5F);

        ld1.setPosition(position);
        ld2.setPosition(position2);
        ld3.setPosition(position3);
        ld4.setPosition(position5);
        background.setPosition(position4);

        font.getData().setScale(2);
        font1.getData().setScale(2);
        font2.getData().setScale(2);

    }

    @Override
    public void render(float delta) {

        batch.begin();
        background.draw(batch);
        ld1.draw(batch);
        ld2.draw(batch);
        ld3.draw(batch);
        ld4.draw(batch);
        font.draw(batch, "Game1: Dark Hills\n21-11-2022 \n13:00", 170, 570);
        font1.draw(batch, "Game2: Monster Brawl\n22-11-2022 \n1:10", 170, 370);
        font2.draw(batch, "Game3: Fight Mania\n25-11-2022 \n4:50", 170, 170);
        batch.end();
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
