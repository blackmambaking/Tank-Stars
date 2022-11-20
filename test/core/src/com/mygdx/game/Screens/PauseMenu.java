package com.mygdx.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Background;
import com.mygdx.game.MainClass;

public class PauseMenu implements Screen {

    private MainClass mainClass;
    private SpriteBatch batch;
    private Texture img;
    private Background background;


    public PauseMenu(MainClass mainClass) {
        this.mainClass = mainClass;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture("log.jpg");
        background = new Background(img);
        background.getSprite().setPosition(0, 20);
        try {
            Thread.sleep(2000);
            mainClass.setScreen(new MainMenu(mainClass));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void render(float delta) {
        batch.begin();
        background.draw(batch);
        batch.end();
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
