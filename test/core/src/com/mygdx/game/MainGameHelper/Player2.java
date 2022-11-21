package com.mygdx.game.MainGameHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player2 extends Player{
    private Vector2 position;
    private Vector2 positionLaser;
    private Sprite sprite;
    private Sprite laserSprite;
    private float speed = 300;

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPositionLaser() {
        return positionLaser;
    }

    public void setPositionLaser(Vector2 positionLaser) {
        this.positionLaser = positionLaser;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getLaserSprite() {
        return laserSprite;
    }

    public void setLaserSprite(Sprite laserSprite) {
        this.laserSprite = laserSprite;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getLaserSpeed() {
        return LaserSpeed;
    }

    public void setLaserSpeed(float laserSpeed) {
        LaserSpeed = laserSpeed;
    }

    private float LaserSpeed = 300;
    public Player2(Texture img, Texture laserImg){
        sprite = new Sprite(img);
        laserSprite = new Sprite(laserImg);
        position = new Vector2(Gdx.graphics.getWidth()/2 - 300,-100);
        positionLaser = new Vector2(Gdx.graphics.getWidth()/2,1000);
        sprite.setScale((float) 0.2);
        sprite.flip(true, false);
        laserSprite.setScale((float) 0.1);
        this.setName("Player1");


    }
    @Override
    public void update(float deltaTime){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            position.x -= deltaTime*speed;
        }if(Gdx.input.isKeyPressed(Input.Keys.D)){
            position.x += deltaTime*speed;
        }if(Gdx.input.isKeyPressed(Input.Keys.W)){
            position.y += deltaTime*speed;
        }if(Gdx.input.isKeyPressed(Input.Keys.S)){
            position.y -= deltaTime*speed;
        }
//        if(position.x - sprite.getWidth()* sprite.getScaleX()/2 <=0){
//            position.x = sprite.getWidth()* sprite.getScaleX()/2;
//        }
        if(position.x + sprite.getWidth()* sprite.getScaleX()/2 >Gdx.graphics.getWidth()){
            position.x = Gdx.graphics.getWidth() - sprite.getWidth()* sprite.getScaleX()/2;
        }
//        if(position.y - sprite.getHeight()* sprite.getScaleY()/2 <=0){
//            position.y = sprite.getHeight()* sprite.getScaleY()/2;
//        }
        if(position.y + sprite.getHeight()* sprite.getScaleY()/2 >Gdx.graphics.getHeight()){
            position.y = Gdx.graphics.getHeight() - sprite.getHeight()* sprite.getScaleY()/2;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){

            positionLaser.y = position.y + 160 ;
            positionLaser.x = position.x + 192;
        }
        positionLaser.y += deltaTime*LaserSpeed;

    }
    @Override
    public void draw(SpriteBatch batch){
        update(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x, position.y);
        laserSprite.setPosition(positionLaser.x, positionLaser.y);
        laserSprite.draw(batch);
        sprite.draw(batch);
    }
}
