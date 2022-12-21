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
import com.mygdx.game.MainGameHelper.PlayerInfo;

import java.io.*;
import java.util.ArrayList;

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
    private ArrayList<String[]> savedGames;
    public static PlayerInfo playerInfo1;
    public static PlayerInfo playerInfo2;

    public LoadGameMenu(MainClass mainClass) {

        this.mainClass = mainClass;
        batch = new SpriteBatch();
        img = new Texture("bgm3.png");
        img1 = new Texture("ld.png");
        img2 = new Texture("ld.png");
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
        position = new Vector2(0, -100);
        position2 = new Vector2(0, 100);
        position3 = new Vector2(0, 300);
        position4 = new Vector2(0, 0);
        position5 = new Vector2(210, -450);
        savedGames = new ArrayList<String[]>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("savedGames.txt"));
            String line = reader.readLine();

            while (line != null) {
                // read next line
                String[] splited = line.split("\\s+");
                savedGames.add(splited);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void show() {

        background.getSprite().setScale(1);
//
//        ld1.getSprite().setScale(1F, 0.4F);
//        ld2.getSprite().setScale(1F, 0.4F);
//        ld3.getSprite().setScale(1F, 0.4F);
        ld4.getSprite().setScale(0.45F, 0.5F);

//        ld1.setPosition(position);
//        ld2.setPosition(position2);
//        ld3.setPosition(position3);
        ld4.setPosition(position5);
        background.setPosition(position4);

        font.getData().setScale(2);
//        font1.getData().setScale(2);
//        font2.getData().setScale(2);

    }


    @Override
    public void render(float delta) {

        batch.begin();
        background.draw(batch);
//        ld1.draw(batch);
//        ld2.draw(batch);
//        ld3.draw(batch);
        ld4.draw(batch);
        font.draw(batch, "Saved Games", 50, 610);
        if(savedGames.size() != 0){
            for (int i = 0; i < savedGames.size(); i++) {
                String s = i + " ";
                for (int j = 0; j < 6; j++) {
                    s = s + " " + savedGames.get(i)[j];
                }
                font.draw(batch, s, 50, 570 - i * 40);
            }
        }


        batch.end();
        if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
            mainClass.setScreen(new MainMenu(mainClass));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_0)) {

            deserialise(savedGames.get(0)[6].trim(),savedGames.get(0)[7].trim() );
            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");

        }   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {

            deserialise(savedGames.get(1)[6].trim(),savedGames.get(1)[7].trim() );
            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");


        }   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {

            deserialise(savedGames.get(2)[6].trim(),savedGames.get(2)[7].trim() );
            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");


        }   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {

            deserialise(savedGames.get(3)[6].trim(),savedGames.get(3)[7].trim() );
            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");

        }   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {

            deserialise(savedGames.get(4)[6].trim(),savedGames.get(4)[7].trim() );
            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");


        }   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) {

            deserialise(savedGames.get(5)[6].trim(),savedGames.get(5)[7].trim() );
            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");


        }   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_6)) {

            deserialise(savedGames.get(6)[6].trim(),savedGames.get(6)[7].trim() );
            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");


        }   if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_7)) {

            deserialise(savedGames.get(7)[6].trim(),savedGames.get(7)[7].trim() );

            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");


        }if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_8)) {

            deserialise(savedGames.get(8)[6].trim(),savedGames.get(8)[7].trim() );
            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");



        }if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_9)) {

            deserialise(savedGames.get(9)[6].trim(),savedGames.get(9)[7].trim() );
            mainClass.setTank1(playerInfo1.getTankName());
            mainClass.setTank2(playerInfo2.getTankName());
            mainClass.setScreen(new LoadedGameScreen(mainClass));
            System.out.println("Loaded game.");


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

    public void deserialise(String filename1, String filename2) {
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename1);
            FileInputStream file2 = new FileInputStream(filename2);
            ObjectInputStream in = new ObjectInputStream(file);
            ObjectInputStream in2 = new ObjectInputStream(file2);

            // Method for deserialization of object
            playerInfo1 = (PlayerInfo) in.readObject();
            playerInfo2 = (PlayerInfo) in2.readObject();

            in.close();
            file.close();
            in2.close();
            file2.close();
            System.out.println("Object has been deserialized ");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
