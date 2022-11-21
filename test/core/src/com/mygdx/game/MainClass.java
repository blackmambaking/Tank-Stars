package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Screens.*;

public class MainClass extends Game implements ApplicationListener {

    private PauseMenu pauseMenu;
    private MainMenu mainMenu;
    private LoadGameMenu loadGameMenu;
    private MyGdxGame myGdxGame;
    private MainGameScreen mainGameScreen;
    private SelectTank selectTank;
    void setPauseMenu()
    {
        pauseMenu=new PauseMenu(this);
        setScreen(pauseMenu);
    }void setMainMenu()
    {
        mainMenu=new MainMenu(this);
        setScreen(mainMenu);
    }void setSelectTankMenu()
    {
        selectTank=new SelectTank(this);
        setScreen(selectTank);
    }void setLoadGameMenu()
    {
        loadGameMenu = new LoadGameMenu(this);
        setScreen(loadGameMenu);
    }void setMainGameScreen()
    {
        mainGameScreen = new MainGameScreen(this);
        setScreen(mainGameScreen);
    }
    @Override
    public void create() {

        setMainMenu();
    }
    @Override
    public void dispose() {

        super.dispose();
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        super.render();
    }

    @Override
    public void resize(int width, int height) {

        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }
}
