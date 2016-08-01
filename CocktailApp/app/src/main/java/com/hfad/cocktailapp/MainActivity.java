package com.hfad.cocktailapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLDBHelper helper = MySQLDBHelper.getInstance(MainActivity.this);

        if (helper.getAllCocktails().size() == 0) {
            List<Cocktail> cocktailss = Initializer.makeAllCocktails();
            for (Cocktail cocktail : cocktailss) {
                helper.addToDB(cocktail);
            }
        }

        View addButton = (Button) findViewById(R.id.addCocktail);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddCocktailActivity.class);
                startActivity(i);
            }
        });


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cocktails_recycler_view);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        List<Cocktail> cocktails = helper.getAllCocktails();
        recyclerView.setAdapter(new CocktailAdapter(cocktails, R.layout.cocktail_list_item, getApplicationContext()));

    }
}
