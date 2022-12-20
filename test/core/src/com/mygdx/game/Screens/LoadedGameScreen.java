package com.mygdx.game.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Background;
import com.mygdx.game.Button;
import com.mygdx.game.MainClass;
import com.mygdx.game.MainGameHelper.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class LoadedGameScreen implements Screen {
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
    private Texture img11;

    private Texture img12;
    private Player1 player1;
    private Player2 player2;
    public PlayerInfo pl1;
    public PlayerInfo pl2;
    private Background background;
    private Health health;
    private Health2 health2;

    private SineTerm sineTerm;
    private SineTerm sineTerm2;
    private ShapeRenderer shapeRenderer;
    private ShapeRenderer shapeRenderer2;
    private ShapeRenderer shapeRenderer3;
    private ShapeRenderer shapeRenderer4;
    private ShapeRenderer shapeRenderer5;
    private ShapeRenderer shapeRenderer6;
    private ShapeRenderer shapeRenderer7;
    private ShapeRenderer shapeRenderer8;
    private ShapeRenderer shapeRenderer9;

    private ArrayList <Float> trajectoryX_pl1;
    private ArrayList <Float> trajectoryY_pl1;
    private ArrayList <Float> trajectoryX_pl2;
    private ArrayList <Float> trajectoryY_pl2;
    private Button pause;

    private Vector2 position;
    private Vector2 position2;
    private Vector2 position3;

    private int score = 0;
    private int a;
    private int b;
    private ArrayList<Float> terrain;

    private Bezier<Vector2> path1;
    private CatmullRomSpline<Vector2> path2;
    private ShapeRenderer sr;
    private Sprite normal;
    private Sprite normal2;
    private Vector2 laserPo;
    public LoadedGameScreen(MainClass mainClass) {
        this.mainClass = mainClass;
        img = new Texture("bgm2.png");
        img2 = new Texture("tank2.png");
        img3 = new Texture("bomb.png");
        img4 = new Texture("full.png");
        img5 = new Texture("full.png");
        img6 = new Texture("terrain.png");


        img7 = new Texture("fire.png");
        img8 = new Texture("abr.png");
        img9 = new Texture("bomb.png");
        img10 = new Texture("pause.png");
        img11 = new Texture("fire.png");
        img12 = new Texture("tank3.png");


        laserPo = new Vector2(1000, 1000);
        if(mainClass.getTank1() ==1){
            player1 = new Player1(img2, img3);
            normal = new Sprite(img2);

        } else if (mainClass.getTank1() ==2) {
            player1 = new Player1(img8, img3);
            normal = new Sprite(img8);

        }else if (mainClass.getTank1() ==3) {
            player1 = new Player1(img12, img3);
            normal = new Sprite(img12);

        }if(mainClass.getTank2() ==1){
            player2 = new Player2(img2, img3);
            normal2 = new Sprite(img2);

        } else if (mainClass.getTank2() ==2) {
            player2 = new Player2(img8, img3);
            normal2 = new Sprite(img8);

        }else if (mainClass.getTank2() ==3) {
            player2 = new Player2(img12, img3);
            normal2 = new Sprite(img12);

        }
        normal.setScale((float) 0.2);
        normal2.setScale((float) 0.2);

        // player2 = new Player2(img8, img9);
        pause = new Button(img10);
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer2 = new ShapeRenderer();
        shapeRenderer3 = new ShapeRenderer();
        shapeRenderer4 = new ShapeRenderer();
        shapeRenderer5 = new ShapeRenderer();
        shapeRenderer6 = new ShapeRenderer();
        shapeRenderer7 = new ShapeRenderer();
        shapeRenderer8 = new ShapeRenderer();
        shapeRenderer9 = new ShapeRenderer();
        position = new Vector2(-100,100);
        position2 = new Vector2(300,100);
        position3 = new Vector2(350,390);
        background = new Background(img);
        health = new Health(img4 );
        health2 = new Health2(img5);
        sineTerm = new SineTerm(1, 1/2, 0);
        sineTerm2 = new SineTerm(2, 1/5, 2);
        terrain = new ArrayList<>();
        trajectoryX_pl1 = new ArrayList<>();
        trajectoryY_pl1 = new ArrayList<>();
        trajectoryX_pl2 = new ArrayList<>();
        trajectoryY_pl2 = new ArrayList<>();
        for(int i = 0; i< 1500; i++){
            float y = (float) ((float) 50*(Math.abs(3*Math.sin(i *0.001) + 2*Math.sin(i * 0.01) + 2*Math.sin(i * 0.0016))))+80;
            terrain.add(y);
        }

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

    //this method will print which player scored more XP

    public void getPlayerInfo(Player player){
        System.out.println(player.getName());
        System.out.println(player.getHealth());
    }

    //this method will print which player has how much health remaining in exact number out of 100.
    public void getPlayerHealth(healthInt health, Player player){

        health.getPlayerName();
        System.out.println(player.getHealth());
    }


    @Override
    public void show() {


        pause.setPosition(position3);
        pause.getSprite().setScale(0.1F);
        pl1 = new PlayerInfo("Player1", mainClass.getTank1(), 100, player1.getSprite().getX(), player1.getSprite().getX(), player1.getAngle(), player1.getAttackSpeed());
        pl2 = new PlayerInfo("Player2", mainClass.getTank2(), 100, player2.getSprite().getX(), player2.getSprite().getX(), player2.getAngle(), player2.getAttackSpeed());


    }

    @Override
    public void render(float delta) {

        try{
            if(Gdx.input.isKeyJustPressed(Input.Keys.N)){
                getPlayerInfo(player1);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
                getPlayerInfo(player2);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
                getPlayerHealth(health, player1);
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.V)){
                getPlayerHealth(health2, player2);
            }

            ScreenUtils.clear(0, 0, 0, 1);
            batch.begin();
            background.draw(batch);
            player1.draw(batch);
            player2.draw(batch);
            pl1.setX(player1.getSprite().getX());
            pl1.setY(player1.getSprite().getY());
            pl2.setX(player2.getSprite().getX());
            pl2.setY(player2.getSprite().getY());
            health.draw(batch);
            health2.draw(batch);
            pause.draw(batch);
            batch.end();


            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor((float)204/255, (float)102/255, (float)0 , (float)1);
            for(int i = 0; i< 1500; i++){
                shapeRenderer.box(i,0,0,1, terrain.get(i),0 );
            }
            shapeRenderer.setColor((float)153/255, (float)76/255, (float)0, (float)1);
            for(int i = 0; i< 1500; i++){
                shapeRenderer.box(i,0,0,1, terrain.get(i)-20,0 );
            }
            shapeRenderer.setColor((float)102/255, (float)51/255, (float)0, (float)1);
            for(int i = 0; i< 1500; i++){
                shapeRenderer.box(i,0,0,1, terrain.get(i)-60,0 );
            }
            shapeRenderer.setColor(Color.BLACK);
            for(int i = 0; i< 1500; i++){
                shapeRenderer.box(i,0,0,1, terrain.get(i)-120,0 );
            }

            shapeRenderer.end();
            batch.begin();
            player1.draw(batch);
            player2.draw(batch);
            batch.end();

//            shapeRenderer2.begin(ShapeRenderer.ShapeType.Filled);
//            shapeRenderer2.setColor(Color.RED);
//            shapeRenderer2.circle(player1.getSprite().getX() +350, player1.getSprite().getY()+140, 2);
//            shapeRenderer2.end();
//            shapeRenderer3.begin(ShapeRenderer.ShapeType.Filled);
//            shapeRenderer3.setColor(Color.RED);
//            shapeRenderer3.circle(player1.getSprite().getX() +390, player1.getSprite().getY()+140, 2);
//            shapeRenderer3.end();


            //making velocity and angle meter for player 1,2
            shapeRenderer4.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer4.setColor(Color.MAROON);
            shapeRenderer4.box(10, 10, 0, 20, 400, 0);
            shapeRenderer4.box(Gdx.graphics.getWidth() -30, 10, 0, 20, 400, 0);
            shapeRenderer4.end();

            shapeRenderer7.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer7.setColor(Color.RED);
            shapeRenderer7.box(10F, 10F, (float) 0, 20F, (float) player1.getAttackSpeed(), 0);
            shapeRenderer7.box(Gdx.graphics.getWidth() -30, 10F, (float) 0, 20F, (float) player2.getAttackSpeed(), 0);
            shapeRenderer7.end();

            shapeRenderer5.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer5.setColor(Color.LIGHT_GRAY);
            shapeRenderer5.box(40, 10, 0, 20, 180, 0);
            shapeRenderer5.box(Gdx.graphics.getWidth() -60, 10, 0, 20, 180, 0);
            shapeRenderer5.end();

            shapeRenderer6.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer6.setColor(Color.BLUE);
            shapeRenderer6.box(40F, 10F, 0F, 20F, (float) player1.getAngle(), 0);
            shapeRenderer6.box(Gdx.graphics.getWidth() -60F, 10F, 0F, 20F, (float) player2.getAngle(), 0);
            shapeRenderer6.end();


            //aiming for player 1
            for(int i = 0; i< 100000; i++){
                float x = (float) (player1.getAttackSpeed()* Math.cos(player1.getAngle()) * 0.0167*(i*100+1));
                float y = (float) (player1.getAttackSpeed()* Math.sin(player1.getAngle()) * 0.0167*(i*100+1) - 0.5*9.8*(i*100+1)*(i*100+1)*0.0167*0.0167);
                trajectoryX_pl1.add(x +player1.getSprite().getX() +350);
                trajectoryY_pl1.add(y +  player1.getSprite().getY()+140);
            }


            shapeRenderer8.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer8.setColor(Color.WHITE);
            for(int i = 1; i< 10; i++){
                shapeRenderer8.circle(trajectoryX_pl1.get(i), trajectoryY_pl1.get(i), 4);
            }
            shapeRenderer8.end();
            trajectoryY_pl1.clear();
            trajectoryX_pl1.clear();

            //aiming for player 2
            for(int i = 0; i< 100000; i++){
                float x = (float) (player2.getAttackSpeed()* Math.cos(player2.getAngle()) * 0.0167*(i*100+1));
                float y = (float) (player2.getAttackSpeed()* Math.sin(player2.getAngle()) * 0.0167*(i*100+1) - 0.5*9.8*(i*100+1)*(i*100+1)*0.0167*0.0167);
                trajectoryX_pl2.add(x +player2.getSprite().getX() +350);
                trajectoryY_pl2.add(y +  player2.getSprite().getY()+140);
            }
            shapeRenderer9.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer9.setColor(Color.WHITE);
            for(int i = 1; i< 10; i++){
                shapeRenderer9.circle(trajectoryX_pl2.get(i), trajectoryY_pl2.get(i), 4);
            }
            shapeRenderer9.end();
            trajectoryY_pl2.clear();
            trajectoryX_pl2.clear();
            //player1.setLaserSprite(normal);
            //player2.setLaserSprite(normal);

            if (player1.getLaserSprite().getBoundingRectangle().overlaps(player2.getSprite().getBoundingRectangle())) {

                Sprite blast = new Sprite(img11);

                //player1.setLaserSprite(blast);

                player1.setPositionLaser(laserPo);
                player2.setSprite(blast);
                //sleep(1000);
                //player2.setSprite(normal2);
                //sleep(1000);
                //player1.setLaserSprite(normal);
            }
            if (player2.getLaserSprite().getBoundingRectangle().overlaps(player1.getSprite().getBoundingRectangle())) {
                Sprite blast = new Sprite();

                // player2.setLaserSprite(blast);
                player2.setPositionLaser(laserPo);
                player1.setSprite(blast);
                //sleep(1000);
                //player1.setSprite(normal);
                //sleep(1000);
                //player2.setLaserSprite(normal);

            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.P)){
                mainClass.setScreen(new PauseMenu(mainClass));
            }
            if(Gdx.input.isKeyJustPressed(Input.Keys.F)){
                try
                {
                    //Saving of object in a file
                    FileOutputStream file = new FileOutputStream("player1.ser");
                    FileOutputStream file2 = new FileOutputStream("player2.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);
                    ObjectOutputStream out2 = new ObjectOutputStream(file2);

                    // Method for serialization of object

                    out.writeObject(pl1);
                    out.close();
                    file.close();
                    out2.writeObject(pl2);
                    out2.close();
                    file2.close();
                    System.out.println("MainGame Screen has been serialized");
                }
                catch(IOException ex)
                {
                    System.out.println("IOException is caught" + ex);
                }
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
