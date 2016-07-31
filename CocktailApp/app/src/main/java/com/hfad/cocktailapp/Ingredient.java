package com.hfad.cocktailapp;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by matthewtduffin on 28/07/16.
 */
public class Ingredient {
    private String name, type;
    private int id;
    private SQLiteDatabase db;

    public Ingredient(String name, String type, SQLiteDatabase db) {
        this.db = db;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

    public boolean dbContains(String name) {

        return true;
    }

    public int getIngredientId(String name) {

        return 0;
    }


}
