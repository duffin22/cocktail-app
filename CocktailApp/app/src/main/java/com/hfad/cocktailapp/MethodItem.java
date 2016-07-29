package com.hfad.cocktailapp;

/**
 * Created by matthewtduffin on 28/07/16.
 */
public class MethodItem {
    private String method;
    private int position;

    public MethodItem(String method, int position) {
        this.method = method;
        this.position = position;
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
