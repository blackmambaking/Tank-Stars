package com.mygdx.game.MainGameHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

abstract public class Player {
    private Vector2 position;
    private Vector2 positionLaser;
    private Sprite sprite;
    private Sprite laserSprite;
    private float speed = 300;
    private String name;

    private int health;
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //using object class to change the object name to string method
    @Override
    public String toString() {
        return this.name;
    }

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

    private void setSprite(Sprite sprite) {
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

    private void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getLaserSpeed() {
        return LaserSpeed;
    }

    public void setLaserSpeed(float laserSpeed) {
        LaserSpeed = laserSpeed;
    }

    private float LaserSpeed = 300;
    public Player(){


    }
    abstract public void update(float deltaTime);
    public void draw(SpriteBatch batch){};

}
