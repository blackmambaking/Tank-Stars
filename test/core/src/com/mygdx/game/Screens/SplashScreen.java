package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Background;
import com.mygdx.game.MainClass;


public class SplashScreen implements Screen {
    private Texture img;
    private Background background;
    private MainClass mainClass;
    private Vector2 position;

    private SpriteBatch batch;
    public SplashScreen(MainClass mainClass) {
        this.mainClass = mainClass;
        batch = new SpriteBatch();
        img = new Texture("log.jpg");
        position = new Vector2(Gdx.graphics.getWidth()/2-650, Gdx.graphics.getHeight()/2-320);
        background = new Background(img);
    }

    @Override
    public void show() {
        background.setPosition(position);
        background.getSprite().setScale(1.2F);

    }

    @Override
    public void render(float delta) {
        batch.begin();
        background.draw(batch);

        batch.end();
        if(Gdx.input.isKeyJustPressed(Input.Keys.N)){
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
