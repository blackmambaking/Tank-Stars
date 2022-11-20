package com.mygdx.game.MainGameHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Health {
    private Vector2 position;
    private Sprite sprite;

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Health(Texture img){
        sprite = new Sprite(img);
        position = new Vector2(600, 590);
        sprite.setSize(500, (float) 100);

    }
    public void draw(SpriteBatch batch){
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
}