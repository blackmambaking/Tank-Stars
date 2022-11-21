package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Background;
import com.mygdx.game.Button;
import com.mygdx.game.MainClass;

import static java.lang.System.exit;

public class MainMenu implements Screen, InputProcessor {
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
    private ImageButton newG;

    private Drawable drawable;
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
        newGame.getSprite().setScale(1);
        resumeGame.getSprite().setScale(1);
        exit.getSprite().setScale(1);

        drawable = new TextureRegionDrawable(new TextureRegion(img1));
        newG = new ImageButton(drawable);
        background.setPosition(position4);

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


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
