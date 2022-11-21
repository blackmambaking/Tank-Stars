package com.mygdx.game.Screens;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.*;
import com.mygdx.game.MainGameHelper.*;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
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
	private Player1 player1;
	private Player2 player2;
	private Background background;
	private Health health;
	private Health2 health2;
	private Terrain terrain;
	private SineTerm sineTerm;
	private SineTerm sineTerm2;

	private int score = 0;
	private int a;
	private int b;

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



	@Override
	public void create () {
		batch = new SpriteBatch();

		img = new Texture("bgm2.png");
		img2 = new Texture("tank2.png");
		img3 = new Texture("laser.png");
		img4 = new Texture("full.png");
		img5 = new Texture("full.png");
		img6 = new Texture("terrain.png");

		img7 = new Texture("fire.png");
		img8 = new Texture("abr.png");
		img9 = new Texture("laser2.png");
		player1 = new Player1(img2, img3);
		player2 = new Player2(img8, img9);
		background = new Background(img);
		health = new Health(img4 );
		health2 = new Health2(img5);
		sineTerm = new SineTerm(1, 1/2, 0);
		sineTerm2 = new SineTerm(2, 1/5, 2);


	}

	@Override
	public void render () {

		ScreenUtils.clear(0, 0, 0, 1);

		batch.begin();
		background.draw(batch);
		player1.draw(batch);
		player2.draw(batch);
		health.draw(batch);
		health2.draw(batch);

		//batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
