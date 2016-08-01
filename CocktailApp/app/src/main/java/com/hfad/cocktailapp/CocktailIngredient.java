package com.hfad.cocktailapp;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by matthewtduffin on 28/07/16.
 */
public class CocktailIngredient {
    private String name;
    private int cocktailId = -1, ingredientId = -1;
    private int quantity;
    private String measurement;
    private int isMain, isGarnish;

    //3-part constructor from user input (not garnish, not main ingredient)
    public CocktailIngredient(String name,int quantity, String measurement) {
        this.name = name;
        this.quantity = quantity;
        this.measurement = measurement;
        this.isMain = 0;
        this.isGarnish = 0;
    }

    //5-part constructor from user input
    public CocktailIngredient(String name, int quantity, String measurement, int isMain, int isGarnish) {
        this.name = name;
        this.quantity = quantity;
        this.measurement = measurement;
        this.setMain(isMain);
        this.setGarnish(isGarnish);
    }

    //7-part constructor from database information
    public CocktailIngredient(String name, int cocktailId, int ingredientId, int quantity, String measurement, int isMain, int isGarnish) {
        this.name = name;
        this.cocktailId = cocktailId;
        this.ingredientId = ingredientId;
        this.quantity = quantity;
        this.measurement = measurement;
        this.setMain(isMain);
        this.setGarnish(isGarnish);
    }



    public int getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(int cocktailId) {
        this.cocktailId = cocktailId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getQuantityMeasure() {
        return "" + quantity +" " + measurement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
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
