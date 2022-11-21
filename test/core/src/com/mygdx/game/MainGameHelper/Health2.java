package com.mygdx.game.MainGameHelper;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Health2 implements healthInt{
    private Vector2 position;
    private Sprite sprite;

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


    public Health2(Texture img){
        sprite = new Sprite(img);
        position = new Vector2(100, 590);
        sprite.setSize(500, (float) 100);
        sprite.flip(true, false);

    }
    @Override
    public void draw(SpriteBatch batch){
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
}
