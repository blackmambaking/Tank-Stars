package com.mygdx.game.MainGameHelper;

import java.io.Serializable;
import java.util.ArrayList;

public class Armoury<T> {
    private ArrayList<T> collection;


    public Armoury(ArrayList<T> collection) {
        this.collection = collection;

    }

    public ArrayList<T> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<T> collection) {
        this.collection = collection;
    }


}
