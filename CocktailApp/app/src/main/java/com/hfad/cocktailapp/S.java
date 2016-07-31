package com.hfad.cocktailapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by matthewtduffin on 29/07/16.
 */
public class S {
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

    public static final String CREATE_COCKTAIL_TABLE =
            "CREATE TABLE " + COCKTAIL_TABLE_NAME + "(" +
                    COCKTAIL_COL_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                    COCKTAIL_COL_NAME + " text, " +
                    COCKTAIL_COL_CATEGORY + " text, " +
                    COCKTAIL_COL_AUTHOR + " text);";

    public static final String CREATE_INGREDIENT_TABLE =
            "CREATE TABLE " + INGREDIENT_TABLE_NAME + "(" +
                    INGREDIENT_COL_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                    INGREDIENT_COL_NAME + " text, " +
                    INGREDIENT_COL_TYPE + " text);";

    public static final String CREATE_METHOD_TABLE =
            "CREATE TABLE " + METHOD_TABLE_NAME + "(" +
                    METHOD_COL_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                    METHOD_COL_CONTENT + " text, " +
                    METHOD_COL_COCKTAIL_ID + " integer, " +
                    METHOD_COL_METHOD_NUMBER + " integer);";

    public static final String CREATE_INGREDIENT_TO_COCKTAIL_TABLE =
            "CREATE TABLE " + INGREDIENT_TO_COCKTAIL_TABLE_NAME + "(" +
                    INGREDIENT_TO_COCKTAIL_COL_COCKTAIL_ID + " integer, " +
                    INGREDIENT_TO_COCKTAIL_COL_INGREDIENT_ID + " integer, " +
                    INGREDIENT_TO_COCKTAIL_COL_QUANTITY + " integer, " +
                    INGREDIENT_TO_COCKTAIL_COL_MEASUREMENT + " text, " +
                    INGREDIENT_TO_COCKTAIL_COL_IS_MAIN + " integer, " +
                    INGREDIENT_TO_COCKTAIL_COL_IS_GARNISH + " integer);";

    public static final String[] CREATE_TABLES = {CREATE_COCKTAIL_TABLE, CREATE_INGREDIENT_TABLE, CREATE_INGREDIENT_TO_COCKTAIL_TABLE, CREATE_METHOD_TABLE};
}
