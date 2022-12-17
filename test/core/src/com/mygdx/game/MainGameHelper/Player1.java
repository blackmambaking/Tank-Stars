package com.mygdx.game.MainGameHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Screens.MainGameScreen;

import java.io.Serializable;
import java.util.ArrayList;

public class Player1 extends Player {
    private Vector2 position;
    private Vector2 positionLaser;
    private Sprite sprite;
    private Sprite laserSprite;

    private double angle;
    private double attackSpeed;
    private float speed = 300;
    private int health;

    private ArrayList<Float> terrain;

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLaserSpeed(float laserSpeed) {
        LaserSpeed = laserSpeed;
    }

    private float LaserSpeed = 300;
    private ShapeRenderer shapeRenderer;
    public Player1(Texture img, Texture laserImg){

        terrain = new ArrayList<>();
        for(int i = 0; i< 1500; i++){
            float y = (float) ((float) 50*(Math.abs(3*Math.sin(i *0.001) + 2*Math.sin(i * 0.01) + 2*Math.sin(i * 0.0016))))+80;
            terrain.add(y);
        }
        sprite = new Sprite(img);
        laserSprite = new Sprite(laserImg);
        position = new Vector2(-200,terrain.get((int) -200+350) -140);
        positionLaser = new Vector2(Gdx.graphics.getWidth()/2,1000);
        sprite.setScale((float) 0.2);
        sprite.setRotation(0);
        laserSprite.setScale((float) 0.2);
        this.setName("Player1");
        this.health = 100;
        this.attackSpeed = 0;
        this.angle = 0;

    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @Override
    public void update(float deltaTime){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            position.x = position.x - deltaTime*speed;
            position.y = terrain.get((int) (position.x)+350) -140;
            Float delY = terrain.get((int) (position.x)+351) - terrain.get((int) (position.x)+350);
            Float delX = 1F;
            sprite.rotate((float) Math.tanh((float)delY/delX));

        }if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            position.x = position.x + deltaTime*speed;
            position.y = terrain.get((int) (position.x)+350) -140;
            Float delY = terrain.get((int) (position.x)+351) - terrain.get((int) (position.x)+350);
            Float delX = 1F;
            sprite.rotate(-(float) Math.tanh((float)delY/delX));
            //position.y += terrain.get((int) (position.x));
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if(this.angle < 180){
                this.angle += deltaTime*speed;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(this.angle > 10){
                this.angle -= deltaTime*speed;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.L)){
            if(this.attackSpeed<400){
                this.attackSpeed += deltaTime*speed;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.K)){
            if(this.attackSpeed >10){
            this.attackSpeed -= deltaTime*speed;
        }}

        

//        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
//            position.y += deltaTime*speed;
//        }if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
//            position.y -= deltaTime*speed;
//        }
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
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){

            positionLaser.y = position.y +100;
            positionLaser.x = position.x -174;
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
