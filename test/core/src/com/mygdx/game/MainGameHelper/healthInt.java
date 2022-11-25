package com.mygdx.game.MainGameHelper;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface healthInt {
    public void getPlayerName();
    public void draw(SpriteBatch spriteBatch);
    public Vector2 getPosition();


    public void setPosition(Vector2 position);

    public Sprite getSprite();

    public void setSprite(Sprite sprite);

}
