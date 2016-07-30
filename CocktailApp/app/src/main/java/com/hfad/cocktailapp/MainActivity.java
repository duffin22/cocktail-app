package com.hfad.cocktailapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLDBHelper helper = MySQLDBHelper.getInstance(MainActivity.this);

        SQLiteDatabase db = helper.getWritableDatabase();

        S.addIngredientToDB(db,"Lime","Fresh Fruit");
        S.addCocktailToDB(db,"Mojito","Classic", "John Mojito");
        S.addMethodToDB(db,"Add all ingredients to the cocktail shaker",1, 1);
        S.addMethodToDB(db,"Shake the shaker",1, 2);
        S.addCocktailIngredientToDB(db, 1, 2, 30, "ml", 0, 0);

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
