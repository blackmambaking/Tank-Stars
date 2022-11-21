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

public class PauseMenu implements Screen {

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



    public PauseMenu(MainClass mainClass) {
        this.mainClass = mainClass;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture("logo4.jpg");
        img1 = new Texture("ld.png");
        img2= new Texture("ld.png");
        img3 = new Texture("ld.png");
        img4 = new Texture("a.jpg");
        img5= new Texture("save.png");
        img6 = new Texture("quit.png");
        img7 = new Texture("resume.png");
        background = new Background(img);
        background.getSprite().setScale(1);
        ld1 = new Button(img1);
        ld2 = new Button(img2);
        ld3 = new Button(img3);
        ld4 = new Button(img4);
        save = new Button(img5);
        resume = new Button(img7);
        quit = new Button(img6);
        ld1.getSprite().setScale(1F, 0.4F);
        ld2.getSprite().setScale(1F, 0.4F);
        ld3.getSprite().setScale(1F, 0.4F);
        save.getSprite().setScale(1F, 0.4F);
        quit.getSprite().setScale(1F, 0.4F);
        resume.getSprite().setScale(1F, 0.4F);
        ld4.getSprite().setScale(0.45F, 0.5F);
        Vector2 position = new Vector2(0,-100);
        Vector2 position2 = new Vector2(0,100);
        Vector2 position3 = new Vector2(0,300);
        Vector2 position4 = new Vector2(0,0);
        Vector2 position5 = new Vector2(200,-450);
        ld1.setPosition(position);
        ld2.setPosition(position2);
        ld3.setPosition(position3);
        ld4.setPosition(position5);
        background.setPosition(position4);
        font = new BitmapFont();
        font1 = new BitmapFont();
        font2 = new BitmapFont();
        font.getData().setScale(1);
        font1.getData().setScale(1);
        font2.getData().setScale(1);
        quit.getSprite().setScale(0.2F);
        save.getSprite().setScale(0.2F);
        resume.getSprite().setScale(0.5F);

    }

    @Override
    public void render(float delta) {

        batch.begin();
        background.draw(batch);
        ld1.draw(batch);
        ld2.draw(batch);
        ld3.draw(batch);
        ld4.draw(batch);
        quit.draw(batch);
        resume.draw(batch);
        save.draw(batch);
        font.draw(batch, "RESUME", 200, 550);
        font1.draw(batch, "SAVE", 200, 350);
        font2.draw(batch, "EXIT", 200, 150);
        batch.end();

        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            mainClass.setScreen(new MainGameScreen(mainClass));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
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
        batch.dispose();


    }

}
