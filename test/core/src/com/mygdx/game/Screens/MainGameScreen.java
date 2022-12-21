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
    private Texture img11;

    private Texture img12;
    private Texture img13;
    private Texture img14;
    private Texture img15;
    private Texture img16;
    private Texture img17;
    private Texture img18;
    private Texture img19;
    private Texture img20;
    private Texture img21;
    private Texture img22;
    private Texture img23;
    private Texture img24;
    private Texture img25;
    private Player1 player1;
    private Player2 player2;
    public static PlayerInfo pl1;
    public static PlayerInfo pl2;
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
    private ShapeRenderer shapeRenderer10;

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

    public static int winner;
    private Vector2 laserPo;
    private Sprite s1;
    private Sprite s2;
    private Sprite s3;
    private Sprite s4;
    private Sprite s5;
    private Sprite s6;
    private Sprite s7;
    private Sprite s8;
    private Sprite s9;
    private Sprite s10;
    private Sprite s11;
    private Sprite s12;
    private Sprite s13;
    public MainGameScreen(MainClass mainClass) {
        this.mainClass = mainClass;
//        PauseMenu.playerInfo1 = null;
//        PauseMenu.playerInfo2 = null;
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
        img13 = new Texture("1-removebg-preview.png");
        img14 = new Texture("2-removebg-preview.png");
        img15 = new Texture("3-removebg-preview.png");
        img16 = new Texture("4-removebg-preview.png");
        img17 = new Texture("5-removebg-preview.png");
        img18 = new Texture("6-removebg-preview.png");
        img19 = new Texture("7-removebg-preview.png");
        img20 = new Texture("8-removebg-preview.png");
        img21 = new Texture("9-removebg-preview.png");
        img22 = new Texture("10-removebg-preview.png");
        img23 = new Texture("11-removebg-preview.png");
        img24 = new Texture("12-removebg-preview.png");
        img25 = new Texture("13-removebg-preview.png");

        //winner = 1;

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
        shapeRenderer10 = new ShapeRenderer();
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
        s1 = new Sprite(img4);
        s2 = new Sprite(img13);
        s3 = new Sprite(img14);
        s4 = new Sprite(img15);
        s5 = new Sprite(img16);
        s6 = new Sprite(img17);
        s7 = new Sprite(img18);
        s8 = new Sprite(img19);
        s9 = new Sprite(img20);
        s10 = new Sprite(img21);
        s11 = new Sprite(img22);
        s12 = new Sprite(img23);
        s13 = new Sprite(img24);

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
        pl1 = new PlayerInfo("Player1", mainClass.getTank1(), 500, player1.getSprite().getX(), player1.getSprite().getX(), player1.getAngle(), player1.getAttackSpeed());
        pl2 = new PlayerInfo("Player2", mainClass.getTank2(), 500, player2.getSprite().getX(), player2.getSprite().getX(), player2.getAngle(), player2.getAttackSpeed());
        if(PauseMenu.playerInfo1 != null){
            pl1 = PauseMenu.playerInfo1;
            Vector2 a = new Vector2(pl1.getX(), pl1.getY());
            player1.setPosition(a);
            player1.setAttackSpeed(pl1.getAttackSpeed());
            player1.setAngle(pl1.getAttackAngle());
            player1.setHealth(pl1.getHealth());
        }
        if(PauseMenu.playerInfo2 != null ){
            pl2 = PauseMenu.playerInfo2;
            Vector2 b = new Vector2(pl2.getX(), pl2.getY());
            player2.setPosition(b);
            player2.setAttackSpeed(pl2.getAttackSpeed());
            player2.setAngle(pl2.getAttackAngle());
            player2.setHealth(pl2.getHealth());

        }
    }

    @Override
    public void render(float delta) {

        try{
//            if(Gdx.input.isKeyJustPressed(Input.Keys.N)){
//                getPlayerInfo(player1);
//            }
//            if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
//                getPlayerInfo(player2);
//            }
//            if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
//                getPlayerHealth(health, player1);
//            }
//            if(Gdx.input.isKeyJustPressed(Input.Keys.V)){
//                getPlayerHealth(health2, player2);
//            }

            ScreenUtils.clear(0, 0, 0, 1);
            batch.begin();
            background.draw(batch);
            player1.draw(batch);
            player2.draw(batch);
            pl1.setX(player1.getSprite().getX());
            pl1.setY(player1.getSprite().getY());
            pl2.setX(player2.getSprite().getX());
            pl2.setY(player2.getSprite().getY());
            //health.draw(batch);
            //health2.draw(batch);
            pause.draw(batch);
            batch.end();
            //making the terrain

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

            //making the health bars
            shapeRenderer10.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer10.setColor(Color.LIGHT_GRAY);
            shapeRenderer10.box(70, Gdx.graphics.getHeight() - 40, 0, 500, 20, 0);
            shapeRenderer10.box(Gdx.graphics.getWidth()/2 +30, Gdx.graphics.getHeight() - 40, 0, 500, 20, 0);

            shapeRenderer10.setColor(Color.RED);
            shapeRenderer10.box(70F, Gdx.graphics.getHeight() - 40, (float) 0, pl1.getHealth(), 20, 0);
            shapeRenderer10.box(Gdx.graphics.getWidth()/2 +30, Gdx.graphics.getHeight() - 40, (float) 0, pl2.getHealth(), 20, 0);
            shapeRenderer10.end();

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
            shapeRenderer4.setColor(Color.LIGHT_GRAY);
            shapeRenderer4.box(10, 10, 0, 20, 400, 0);
            shapeRenderer4.box(Gdx.graphics.getWidth() -30, 10, 0, 20, 400, 0);
            shapeRenderer4.end();

            shapeRenderer7.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer7.setColor(Color.MAROON);
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
            for(int i = 1; i< 6; i++){
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
            for(int i = 1; i< 6; i++){
                shapeRenderer9.circle(trajectoryX_pl2.get(i), trajectoryY_pl2.get(i), 4);
            }
            shapeRenderer9.end();
            trajectoryY_pl2.clear();
            trajectoryX_pl2.clear();
            //player1.setLaserSprite(normal);
            //player2.setLaserSprite(normal);

            //making fuel ration per turn
            shapeRenderer3.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer3.setColor(Color.LIGHT_GRAY);
            shapeRenderer3.box(70, 10, 0, 20, 100, 0);
            shapeRenderer3.box(Gdx.graphics.getWidth() -90, 10, 0, 20, 100, 0);
            shapeRenderer3.end();

            shapeRenderer2.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer2.setColor(Color.GOLD);
            shapeRenderer2.box(70F, 10F, (float) 0, 20F, (float) player1.getFuel(), 0);
            shapeRenderer2.box(Gdx.graphics.getWidth() -90, 10F, (float) 0, 20F, (float) player2.getFuel(), 0);
            shapeRenderer2.end();


            //making blast and damage on attack

            if (player1.getLaserSprite().getBoundingRectangle().overlaps(player2.getSprite().getBoundingRectangle())) {
                player1.setPositionLaser(laserPo);
                System.out.println("Blaaaast....");

                player2.setHealth((int) (player2.getHealth() - 0.01));
                pl2.setHealth((int) (pl2.getHealth()-0.01));
                System.out.println(pl2.getHealth());

            }
            if (player2.getLaserSprite().getBoundingRectangle().overlaps(player1.getSprite().getBoundingRectangle())) {
                System.out.println("Blaaaast....");
               // player2.setLaserSprite(blast);
                player2.setPositionLaser(laserPo);

                pl1.setHealth((int) (pl1.getHealth()-0.01));
                player1.setHealth((int) (player1.getHealth() - 0.01));
                System.out.println(pl1.getHealth());

            }
            //updating player info
            pl1.setX(player1.getSprite().getX());
            pl1.setY(player1.getSprite().getY());
            pl2.setX(player2.getSprite().getX());
            pl2.setY(player2.getSprite().getY());
            pl1.setHealth(player1.getHealth());
            pl2.setHealth(player2.getHealth());
            pl1.setAttackSpeed(player1.getAttackSpeed());
            pl2.setAttackSpeed(player2.getAttackSpeed());
            pl1.setAttackAngle(player1.getAngle());
            pl2.setAttackAngle(player2.getAngle());

            if(pl1.getHealth()<=0 || pl2.getHealth()<=0){
                if(pl1.getHealth()<=0){
                    winner = 2;
                } if(pl2.getHealth()<=0){
                    winner = 1;
                }
                mainClass.setScreen(new ResultScreen(mainClass));
            }

            //taking in game input for pausing the game
            if(Gdx.input.isKeyJustPressed(Input.Keys.P)){
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
