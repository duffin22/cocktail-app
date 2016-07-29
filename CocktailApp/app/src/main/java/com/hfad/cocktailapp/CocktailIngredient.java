package com.hfad.cocktailapp;

/**
 * Created by matthewtduffin on 28/07/16.
 */
public class CocktailIngredient {
    private String name, type;
    private int quantity;
    private String measurement;
    private boolean isMain, isGarnish;

    //4-part constuctor sets isMain and isGarnish to false
    public CocktailIngredient(String name, String type, int quantity, String measurement) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.measurement = measurement;
        this.isMain = false;
        this.isGarnish = false;
    }

    //6-part constructor where isMain and isGarnish can be set
    public CocktailIngredient(String name, String type, int quantity, String measurement, boolean isMain, boolean isGarnish) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.measurement = measurement;
        this.isMain = isMain;
        this.isGarnish = isGarnish;
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

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public boolean isGarnish() {
        return isGarnish;
    }

    public void setGarnish(boolean garnish) {
        isGarnish = garnish;
    }
}
