package com.hfad.cocktailapp;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by matthewtduffin on 28/07/16.
 */
public class Cocktail {
    private String name, author, category;
    private List<MethodItem> methods;
    private List<CocktailIngredient> ingredients;
    private int id = -1;

    public Cocktail() {
        List<MethodItem> meths = new ArrayList<>();
        meths.add(new MethodItem("Do the first thing",1));
        meths.add(new MethodItem("Do the second thing",2));
        meths.add(new MethodItem("Do the third thing",3));

        List<CocktailIngredient> ings = new ArrayList<>();
        ings.add(new CocktailIngredient("Lime", "Fresh Fruit",4,"slices"));
        ings.add(new CocktailIngredient("Rum", "Alcoholic",45,"ml"));

        this.name = "Mojito";
        this.author = "IBA Official";
        this.category = "Summer Drink";
        this.methods = meths;
        this.ingredients = ings;
    }

    public Cocktail(String name, String author, String category, List<MethodItem> methods, List<CocktailIngredient> ingredients) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.methods = methods;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<MethodItem> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodItem> methods) {
        this.methods = methods;
    }

    public List<CocktailIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<CocktailIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
