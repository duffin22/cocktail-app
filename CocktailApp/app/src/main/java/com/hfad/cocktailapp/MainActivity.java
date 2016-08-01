package com.hfad.cocktailapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager layoutManager;
    List<Cocktail> cocktails;
    CocktailAdapter adapty;
    public static final int ADD_COCKTAIL_CODE = 1987;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLDBHelper helper = MySQLDBHelper.getInstance(MainActivity.this);
        cocktails = helper.getAllCocktailsForHomeScreen();

        if (cocktails.size() == 0) {
            List<Cocktail> cocktailss = Initializer.makeAllCocktails();
            for (Cocktail cocktail : cocktailss) {
                helper.addToDB(cocktail);
            }
            cocktails = helper.getAllCocktailsForHomeScreen();
        }

        View addButton = (Button) findViewById(R.id.addCocktail);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddCocktailActivity.class);
                startActivityForResult(i,ADD_COCKTAIL_CODE);
            }
        });


        layoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cocktails_recycler_view);

        recyclerView.setLayoutManager(layoutManager);

        adapty = new CocktailAdapter(cocktails, R.layout.cocktail_list_item, getApplicationContext());
        recyclerView.setAdapter(adapty);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_COCKTAIL_CODE) {
            if (resultCode == RESULT_OK) {
                MySQLDBHelper helper = MySQLDBHelper.getInstance(MainActivity.this);

                cocktails = helper.getAllCocktailsForHomeScreen();
                adapty.notifyDataSetChanged();
                final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cocktails_recycler_view);
                recyclerView.setAdapter(adapty);
            }
        }
    }
}
