package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Screens.*;

import java.io.Serializable;

public class MainClass extends Game implements ApplicationListener {

    private PauseMenu pauseMenu;
    private MainMenu mainMenu;
    private LoadGameMenu loadGameMenu;
    private LoadedGameScreen loadedGameScreen;
    private ResultScreen resultScreen;
    private MyGdxGame myGdxGame;
    private MainGameScreen mainGameScreen;
    private SelectTank selectTank;
    private SelectTank2 selectTank2;
    private SplashScreen splashScreen;


    private int tank1;

    public int getTank1() {
        return tank1;
    }

    public void setTank1(int tank1) {
        this.tank1 = tank1;
    }

    public int getTank2() {
        return tank2;
    }

    public void setTank2(int tank2) {
        this.tank2 = tank2;
    }

    private int tank2;
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
    }void setSelectTank2Menu()
    {
        selectTank2=new SelectTank2(this);
        setScreen(selectTank2);
    }void setLoadGameMenu()
    {
        loadGameMenu = new LoadGameMenu(this);
        setScreen(loadGameMenu);
    }void setMainGameScreen()
    {
        mainGameScreen = new MainGameScreen(this);
        setScreen(mainGameScreen);
    }void setSplashScreen()
    {
        splashScreen = new SplashScreen(this);
        setScreen(splashScreen);
    }void setLoadedGameScreenScreen()
    {
        loadedGameScreen = new LoadedGameScreen(this);
        setScreen(loadedGameScreen);
    }void setResultScreenScreen()
    {
        resultScreen = new ResultScreen(this);
        setScreen(resultScreen);
    }

    @Override
    public void create() {

        setSplashScreen();
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
