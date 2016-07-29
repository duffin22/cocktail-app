//package com.hfad.cocktailapp;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by matthewtduffin on 28/07/16.
// */
//public class MySQLiteHelper extends SQLiteOpenHelper {
//    private static final String TAG = MySQLiteHelper.class.getCanonicalName();
//
//    private static final int DATABASE_VERSION = 1;
//    public static final String DATABASE_NAME = "COCKTAIL_DB";
//    public static final String EXAMPLE_LIST_TABLE_NAME = "EXAMPLE_LIST";
//
//    public static final String COL_ID = "_id";
//    public static final String COL_ITEM_NAME = "ITEM_NAME";
//    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
//
//    public static final String[] EXAMPLE_COLUMNS = {COL_ID,COL_ITEM_NAME,COL_ITEM_DESCRIPTION};
//
//    private static final String CREATE_EXAMPLE_LIST_TABLE =
//            "CREATE TABLE " + EXAMPLE_LIST_TABLE_NAME +
//                    "(" +
//                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    COL_ITEM_NAME + " TEXT, " +
//                    COL_ITEM_DESCRIPTION + " TEXT )";
//
//    private static MySQLiteHelper DB;
//
//    public static MySQLiteHelper getInstance(Context context) {
//        if (DB == null) {
//            Log.i("SINGLETON", "has been created!!!");
//            DB = new MySQLiteHelper(context);
//        } else {
//            Log.i("SINGLETON", "has been accessed.....");
//        }
//        return DB;
//    }
//
//
//    private MySQLiteHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_EXAMPLE_LIST_TABLE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + EXAMPLE_LIST_TABLE_NAME);
//        this.onCreate(db);
//    }
//
//    public List<GroceryItem> getExampleList(){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(EXAMPLE_LIST_TABLE_NAME, // a. table
//                EXAMPLE_COLUMNS, // b. column names
//                null, // c. selections
//                null, // d. selections args
//                null, // e. group by
//                null, // f. having
//                null, // g. order by
//                null); // h. limit
//
//        List<GroceryItem> items = new ArrayList<>();
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            int i_id = cursor.getColumnIndexOrThrow(MySQLiteHelper.COL_ID);
//            int i_name = cursor.getColumnIndexOrThrow(MySQLiteHelper.COL_ITEM_NAME);
//            int i_desc = cursor.getColumnIndexOrThrow(MySQLiteHelper.COL_ITEM_DESCRIPTION);
//
//            int id = cursor.getInt(i_id);
//            String name = cursor.getString(i_name);
//            String description = cursor.getString(i_desc);
//
//            items.add(new GroceryItem(id,name,description));
//            cursor.moveToNext();
//
//        }
//
//        return  items;
//
//
//    }
//
//    public Cursor getDescription(int pos) {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String sql = "SELECT "+COL_ITEM_DESCRIPTION +
//                " FROM "+EXAMPLE_LIST_TABLE_NAME +
//                " WHERE "+COL_ID + " = "+ (pos+1)+";";
//
//        Cursor cursor = db.rawQuery(sql,null);
//        return cursor;
//    }
