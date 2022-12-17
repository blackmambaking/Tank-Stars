package com.mygdx.game.MainGameHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.io.Serializable;

public class Health implements healthInt {
    private Vector2 position;
    private Sprite sprite;

    private String playerName = "Player1_health";
    @Override
    public Vector2 getPosition() {
        return position;
    }
    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }
    @Override
    public Sprite getSprite() {
        return sprite;
    }
    @Override
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void getPlayerName(){
        System.out.println(playerName);
    }

    public Health(Texture img){
        sprite = new Sprite(img);
        position = new Vector2(600, 590);
        sprite.setSize(500, (float) 100);

    }
    @Override
    public void draw(SpriteBatch batch){
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
}
