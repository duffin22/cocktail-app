package com.hfad.cocktailapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AddIngredientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);

        Button done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySQLDBHelper db = MySQLDBHelper.getInstance(AddIngredientActivity.this);

                String s = db.getCocktailName(1);

                Log.i("MATTTEST",s);

            }
        });

    }
}