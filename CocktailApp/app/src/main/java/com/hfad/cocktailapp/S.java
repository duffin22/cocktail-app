package com.hfad.cocktailapp;

/**
 * Created by matthewtduffin on 29/07/16.
 */
public class S {
    //class to hold strings with database references
    public static final String COCKTAIL_TABLE_NAME = "cocktails";
    public static final String INGREDIENT_TABLE_NAME = "ingredients";
    public static final String METHOD_TABLE_NAME = "methods";
    public static final String INGREDIENT_TO_COCKTAIL_TABLE_NAME = "ingredient_to_cocktail";

    public static final String COCKTAIL_COL_ID = "_id";
    public static final String COCKTAIL_COL_NAME = "name";
    public static final String COCKTAIL_COL_CATEGORY = "category";
    public static final String COCKTAIL_COL_AUTHOR = "author";

    public static final String INGREDIENT_COL_ID ="_id";
    public static final String INGREDIENT_COL_NAME ="name";
    public static final String INGREDIENT_COL_TYPE ="type";

    public static final String METHOD_COL_ID ="_id";
    public static final String METHOD_COL_CONTENT ="content";
    public static final String METHOD_COL_COCKTAIL_ID ="cocktail_id";
    public static final String METHOD_COL_METHOD_NUMBER ="method_number";

    public static final String INGREDIENT_TO_COCKTAIL_COL_COCKTAIL_ID ="cocktail_id";
    public static final String INGREDIENT_TO_COCKTAIL_COL_INGREDIENT_ID ="ingredient_id";
    public static final String INGREDIENT_TO_COCKTAIL_COL_QUANTITY ="quantity";
    public static final String INGREDIENT_TO_COCKTAIL_COL_MEASUREMENT ="measurement";
    public static final String INGREDIENT_TO_COCKTAIL_COL_IS_MAIN ="is_main";
    public static final String INGREDIENT_TO_COCKTAIL_COL_IS_GARNISH ="is_garnish";


//******************* Helper methods for COCKTAILS table ***********************

    public static void addCocktailToDB(String name, String category, String author) {

    }


    public static int getCocktailId(String name) {

    }

    public static int getCocktailName(int id) {

    }

    public static int getCocktailCategory(String name) {
        int id = getCocktailId(name);
        return getCocktailCategory(id);
    }

    public static int getCocktailCategory(int id) {

    }

    public static int getCocktailAuthor(String name) {
        int id = getCocktailId(name);
        return getCocktailAuthor(id);
    }

    public static int getCocktailAuthor(int id) {

    }

//********************************************************************************

//******************* Helper methods for INGREDIENTS table ***********************

    public static void addIngredientToDB(String name, String type) {

    }


    public static int getIngredientId(String name) {

    }

    public static int getIngredientName(int id) {

    }

    public static int getIngredientType(String name) {
        int id = getIngredientId(name);
        return getIngredientType(id);
    }

    public static int getIngredientType(int id) {

    }

//********************************************************************************


}
