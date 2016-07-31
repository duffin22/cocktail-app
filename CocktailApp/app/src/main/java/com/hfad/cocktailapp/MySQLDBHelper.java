package com.hfad.cocktailapp;


import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewtduffin on 29/07/16.
 */
public class MySQLDBHelper extends SQLiteOpenHelper {
    private static final String TAG = MySQLDBHelper.class.getCanonicalName();
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "COCKTAIL_DB";
    private static MySQLDBHelper DB;

    private MySQLDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String s : S.CREATE_TABLES) {
            db.execSQL(s);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static MySQLDBHelper getInstance(Context context) {
        if (DB == null) {
            Log.i("SINGLETON", "has been created!!!");
            DB = new MySQLDBHelper(context);
        } else {
            Log.i("SINGLETON", "has been accessed.....");
        }
        return DB;
    }

    public void addCocktailToDB(Cocktail cocktail, SQLiteDatabase db) {
        if (containsCocktail(cocktail.getName())) {
            //what to do if cocktail name is not unique
        } else {
            //TODO: Call methods to add all relevant cocktail information to tables

            //Step 1: add to cocktail table
            addToCocktailTable(cocktail);

            //Step 2: add to methods table
            List<MethodItem> methods = cocktail.getMethods();
            for (MethodItem method : methods) {
                //addToMethodTable(method);
            }

            //Step 3: add to ingredients & cocktailIngredients tables
            List<CocktailIngredient> cocktailIngredients = cocktail.getIngredients();
            for (CocktailIngredient ings : cocktailIngredients) {
                if (!containsIngredient(ings.getName())) {
                    addToIngredientTable(ings);
                }
                addToCocktailIngredientTable(ings);
            }

            //set the id of the cocktail after it has been added to the table
        }
    }

    public void addIngredientToDB(SQLiteDatabase db, Ingredient ingredient) {
        addIngredientToDB(db, ingredient.getName(), ingredient.getType());
        ingredient.setId(getIngredientId(ingredient.getName()));
    }


    public void addIngredientToDB(SQLiteDatabase db, String name, String type) {

        String s = "INSERT INTO " + S.INGREDIENT_TABLE_NAME +
                " VALUES (null, '" +
                name + "', '" +
                type + "');";

        db.execSQL(s);
    }

    public boolean containsCocktail(String name) {
        //method to return true if cocktail is already in db
        if (getCocktailId(name) == -1) {
            return false;
        }
        return true;
    }

    public boolean containsIngredient(String name) {
        if (getIngredientId(name) == -1) {
            return false;
        }
        return true;
    }


    public void addToCocktailTable(Cocktail cocktail) {
        //add the cocktail to the cocktail table of db
        SQLiteDatabase db = this.getWritableDatabase();
        boolean checker = true;
        int count = 2;
        String name = cocktail.getName();
        while (checker) {
            if (!containsCocktail(cocktail.getName())) {
                addCocktailToDB(db,cocktail.getName(),cocktail.getCategory(), cocktail.getAuthor());
                checker = false;
            } else {
                cocktail.setName(name + " (ver " + count + ")");
                count++;
            }
        }
        cocktail.setId(getCocktailId(cocktail.getName()));
    }

    public void addToMethodTable(Cocktail cocktail) {
        //add the cocktail's methods to the method table of db

        SQLiteDatabase db = this.getWritableDatabase();

        List<MethodItem> methods = cocktail.getMethods();

        for (MethodItem method : methods) {
            method.setCocktailId(getCocktailId(cocktail.getName()));
            addMethodToDB(db, method.getMethod(), method.getCocktailId(), method.getPosition());
        }


    }

    public void addToIngredientTable(CocktailIngredient ingredient) {
        //TODO: Create method to add an ingredient to the ingredient table of db
    }

    public void addToCocktailIngredientTable(CocktailIngredient ingredient) {
        //TODO: Create method to add the cocktail to the method table of db
    }

    public int getCocktailId(String name) {
    //checks to see if a cocktail of a certain name is in the db and returns its id. Returns -1 if not in database
        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "SELECT "+S.COCKTAIL_COL_ID +
                " FROM " + S.COCKTAIL_TABLE_NAME +
                " WHERE "+ S.COCKTAIL_COL_NAME + " = '"+ name +"';";

        try {
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            int i = cursor.getInt(cursor.getColumnIndexOrThrow(S.COCKTAIL_COL_ID));
            cursor.close();
            return i;
        } catch (Exception e) {
            return -1;
        }
    }

    public String getCocktailName(int id) {
    //checks to see if a cocktail of a certain id is in the db and returns its name. Returns null if not in database

        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "SELECT "+S.COCKTAIL_COL_NAME +
                " FROM " + S.COCKTAIL_TABLE_NAME +
                " WHERE "+ S.COCKTAIL_COL_ID + " = "+ (id)+";";

        try {
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            String s = cursor.getString(cursor.getColumnIndexOrThrow(S.COCKTAIL_COL_NAME));
            cursor.close();
            return s;
        } catch (Exception e) {
            return null;
        }

    }

    public int getIngredientId(String name) {

        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "SELECT "+S.INGREDIENT_COL_ID +
                " FROM " + S.INGREDIENT_TABLE_NAME +
                " WHERE "+ S.INGREDIENT_COL_NAME + " = "+ name +";";

        try {
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            int i = cursor.getInt(cursor.getColumnIndexOrThrow(S.INGREDIENT_COL_ID));
            cursor.close();
            return i;
        } catch (Exception e) {
            return -1;
        }

    }


    public static boolean addCocktailToDB(SQLiteDatabase db, String name, String category, String author) {

        String s = "INSERT INTO " + S.COCKTAIL_TABLE_NAME +
                " VALUES (null, '" +
                name + "', '" +
                category + "', '" +
                author + "');";

        db.execSQL(s);

        return true;
    }

    public static boolean addMethodToDB(SQLiteDatabase db, String content, int cocktailId, int methodNumber) {

        String s = "INSERT INTO " + S.METHOD_TABLE_NAME +
                " VALUES (null, '" +
                content + "', " +
                cocktailId + ", " +
                methodNumber + ");";

        db.execSQL(s);

        return true;
    }

    public static boolean addCocktailIngredientToDB(SQLiteDatabase db, int cocktailId, int ingredientId, int quantity, String measurement, int isMain, int isGarnish) {

        String s = "INSERT INTO " + S.INGREDIENT_TO_COCKTAIL_TABLE_NAME +
                " VALUES (" +
                cocktailId + ", " +
                ingredientId + ", " +
                quantity + ", '" +
                measurement + "', " +
                isMain + ", " +
                isGarnish + ");";

        db.execSQL(s);

        return true;
    }






}

