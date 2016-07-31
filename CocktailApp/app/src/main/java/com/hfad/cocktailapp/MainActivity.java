package com.hfad.cocktailapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLDBHelper helper = MySQLDBHelper.getInstance(MainActivity.this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cocktail cocktail = new Cocktail();
        helper.addToDB(cocktail);
        cocktail = new Cocktail();
        helper.addToDB(cocktail);
        cocktail = new Cocktail();
        helper.addToDB(cocktail);
        cocktail = new Cocktail();
        helper.addToDB(cocktail);
        cocktail = new Cocktail();

        helper.addToDB(cocktail);


        View addButton = (Button) findViewById(R.id.addCocktail);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddCocktailActivity.class);
                startActivity(i);
            }
        });

    }
}
