package com.mygdx.game.MainGameHelper;

import java.io.Serializable;

public class PlayerInfo implements Serializable {
    private String name;
    private int tankName;


    private int health;
    private float x;
    private float y;
    private double attackAngle;
    private double attackSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getTankName() {
        return tankName;
    }

    public void setTankName(int tankName) {
        this.tankName = tankName;
    }

    public double getAttackAngle() {
        return attackAngle;
    }

    public void setAttackAngle(double attackAngle) {
        this.attackAngle = attackAngle;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public PlayerInfo(String name, int tankName, int health, float x, float y, double attackAngle, double attackSpeed) {
        this.name = name;
        this.tankName = tankName;
        this.health = health;
        this.x = x;
        this.y = y;
        this.attackAngle = attackAngle;
        this.attackSpeed = attackSpeed;
    }
}
