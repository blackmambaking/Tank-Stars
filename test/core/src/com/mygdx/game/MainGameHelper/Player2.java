package com.mygdx.game.MainGameHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Player2 extends Player {
    private Vector2 position;
    private Vector2 positionLaser;
    private Sprite sprite;
    private Sprite laserSprite;

    private double angle;
    private double attackSpeed;
    private float speed = 50;
    private int health;
    private float time;
    private int fire;

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
    private int fuel;
    public Player2(Texture img, Texture laserImg){

        terrain = new ArrayList<>();
        for(int i = 0; i< 1500; i++){
            float y = (float) ((float) 50*(Math.abs(3*Math.sin(i *0.001) + 2*Math.sin(i * 0.01) + 2*Math.sin(i * 0.0016))))+80;
            terrain.add(y);
        }
        sprite = new Sprite(img);
        laserSprite = new Sprite(laserImg);
        position = new Vector2(700,terrain.get((int) 700+350) -140);
        positionLaser = new Vector2(Gdx.graphics.getWidth()/2,10000);
        sprite.setScale((float) 0.2);
        sprite.flip(true, false);
        sprite.setRotation(0);
        laserSprite.setScale((float) 0.1);
        this.setName("Player1");
        this.health = 500;
        this.attackSpeed = 70;
        this.angle = 20;
        this.time = 0;
        this.fire = 0;
        this.fuel = 100;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
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
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if(this.fuel>0){
                position.x = position.x - deltaTime*speed;
                position.y = terrain.get((int) (position.x)+350) -140;
                Float delY = terrain.get((int) (position.x)+351) - terrain.get((int) (position.x)+350);
                Float delX = 4F;
                float angle2 = (float) Math.tanh((float)delY/delX);
                this.fuel = (int) (this.fuel - deltaTime*speed*0.2);
                //System.out.println(this.fuel);

                sprite.rotate(angle2);
            }



        }if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if(this.fuel>0){
                position.x = position.x + deltaTime*speed;
                position.y = terrain.get((int) (position.x)+350) -140;
                Float delY = terrain.get((int) (position.x)+351) - terrain.get((int) (position.x)+350);
                Float delX = 4F;
                float angle2 = (float) Math.tanh((float)delY/delX);
                this.fuel = (int) (this.fuel - deltaTime*speed*0.2);
                //System.out.println(this.fuel);

                sprite.rotate(-angle2);
            }


        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            if(this.angle < 180){
                this.angle += deltaTime;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            if(this.angle > 10){
                this.angle -= deltaTime;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Z)){
            if(this.attackSpeed<400){
                this.attackSpeed += deltaTime*5;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.X)){
            if(this.attackSpeed >10){
            this.attackSpeed -= deltaTime*5;
        }}

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
        if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
            this.time = 0.5F;
            this.laserSprite.setRotation(0);
            this.fire = 1;
            positionLaser.y = position.y - 60 ;
            positionLaser.x = position.x +125;
            this.fuel = 100;
        }

        float x = position.x  + 125+ (float) ((this.attackSpeed)* Math.cos(this.angle) * this.time) - 30;
        float y = position.y - 60 + (float) ((this.attackSpeed)* Math.sin(this.angle) * this.time - 0.5*9.8*this.time*this.time) -50;

        if(fire == 1){

            positionLaser.x = x;
            positionLaser.y = y;
            this.time = this.time + deltaTime;
            laserSprite.rotate(deltaTime*10);
        }
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
