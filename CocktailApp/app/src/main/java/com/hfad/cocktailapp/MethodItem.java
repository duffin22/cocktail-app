package com.hfad.cocktailapp;

/**
 * Created by matthewtduffin on 28/07/16.
 */
public class MethodItem {
    private String method;
    private int position;
    private int cocktailId = -1;
    private int id = -1;

    public MethodItem(String method, int position) {
        this.method = method;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(int cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
