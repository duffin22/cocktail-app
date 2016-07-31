package com.hfad.cocktailapp;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by matthewtduffin on 28/07/16.
 */
public class CocktailIngredient {
    private String name, type;
    private int cocktailId = -1, ingredientId = -1;
    private int quantity;
    private String measurement;
    private int isMain, isGarnish;

    //4-part constuctor sets isMain and isGarnish to false (0)
    public CocktailIngredient(String name, String type, int quantity, String measurement) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.measurement = measurement;
        this.isMain = 0;
        this.isGarnish = 0;
    }

    public CocktailIngredient(int cocktailId, int ingredientId, int quantity, String measurement, int isMain, int isGarnish) {
        this.cocktailId = cocktailId;
        this.quantity = quantity;
        this.measurement = measurement;
        this.setMain(isMain);
        this.setGarnish(isGarnish);
    }

    //6-part constructor where isMain and isGarnish can be set
    public CocktailIngredient(String name, String type, int quantity, String measurement, int isMain, int isGarnish) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.measurement = measurement;
        this.setMain(isMain);
        this.setGarnish(isGarnish);
    }


//    public boolean addCocktailIngredientToDB(SQLiteDatabase db) {
//
//        if (!isIngredientInDB(this.name)) {
//            S.addIngredientToDB(db, this.name, this.type);
//        }
//
//        S.addCocktailIngredientToDB(db, this.cocktailId, this.ingredientId, this.quantity, this.measurement, this.isMain, this.isGarnish);
//
//        return true;
//    }

    public boolean isIngredientInDB(String name) {
        if (true) {
            return true;
        }
        return false;
    }

    public String getQuantityMeasure() {
        return "" + quantity + measurement;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public int isMain() {
        return this.isMain;
    }

    public void setMain(int main) {
        if (main == 1) {
            this.isMain = main;
        } else {
            this.isMain = 0;
        }
    }

    public int isGarnish() {
        return this.isGarnish;
    }

    public void setGarnish(int garnish) {
        if (garnish == 1) {
            this.isGarnish = garnish;
        } else {
            this.isMain = 0;
        }

    }
}
