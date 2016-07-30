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

    public String getCocktailName(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "SELECT "+S.COCKTAIL_COL_NAME +
                " FROM " + S.COCKTAIL_TABLE_NAME +
                " WHERE "+ S.COCKTAIL_COL_ID + " = "+ (id)+";";

        Cursor cursor = db.rawQuery(sql,null);

        cursor.moveToFirst();

        String s = cursor.getString(cursor.getColumnIndexOrThrow(S.COCKTAIL_COL_NAME));

        return s;
    }




}

