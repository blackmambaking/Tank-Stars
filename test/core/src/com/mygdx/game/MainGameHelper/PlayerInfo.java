package com.mygdx.game.MainGameHelper;

import java.io.Serializable;

public class PlayerInfo implements Serializable {
    private String name;
    private String tankName;

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }

    private int health;
    private float x;
    private float y;

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

    public PlayerInfo(String name, String tank, int health, float x, float y) {
        this.name = name;
        this.health = health;
        this.x = x;
        this.y = y;
        this.tankName = tank;
    }
}
