package com.hfad.cocktailapp;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AddCocktailActivity extends AppCompatActivity {

    LayoutInflater inflater;
    ViewGroup methodViewGroup, ingredientViewGroup;

    private static final int ADD_INGREDIENT_REQUEST = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cocktail);

        methodViewGroup = (ViewGroup) findViewById(R.id.methodList);
        ingredientViewGroup = (ViewGroup) findViewById(R.id.ingredientList);

        //create a list of ingredients for test purposes
        ArrayList<CocktailIngredient> ingredients = makeIngredientArrayList();

        for (CocktailIngredient i : ingredients) {
            addIngredientListItem(i);
        }

        addMethodListItem(1,"Do some stuff");
        addMethodListItem(2,"Do some more stuerfvhuyf uoyb3fj i j3u4fik i 34f ib m iu34 fmn i;wiurh oyue r, ouer fm ou ff");
        addMethodListItem(3,"Do even more stuff");


        LayoutTransition l = new LayoutTransition();
        l.enableTransitionType(LayoutTransition.CHANGING);
        methodViewGroup.setLayoutTransition(l);

        View ingredientButton = (Button) findViewById(R.id.ingredientButton);
        ingredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddCocktailActivity.this, AddIngredientActivity.class);
                startActivityForResult(i, ADD_INGREDIENT_REQUEST);
            }
        });

        View methodButton = (Button) findViewById(R.id.methodButton);
        methodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_INGREDIENT_REQUEST) {


        }

    }

    public void addIngredientListItem(CocktailIngredient ingredient) {
        inflater = LayoutInflater.from(AddCocktailActivity.this);
        View v = inflater.inflate(R.layout.ingredient_list_item, ingredientViewGroup, false);
        TextView quantity = (TextView) v.findViewById(R.id.ingredientQuantity);
        TextView name = (TextView) v.findViewById(R.id.ingredientName);
        View spacer = v.findViewById(R.id.spacer);
        quantity.setText(ingredient.getQuantityMeasure());
        name.setText(ingredient.getName());
        ingredientViewGroup.addView(v);
    }

    public void addMethodListItem(int i, String method) {
        inflater = LayoutInflater.from(AddCocktailActivity.this);
        View v = inflater.inflate(R.layout.method_list_item, methodViewGroup, false);
        TextView number = (TextView) v.findViewById(R.id.methodNumber);
        TextView body = (TextView) v.findViewById(R.id.methodBody);
        View spacer = v.findViewById(R.id.spacer);
        number.setText("" +i+".");
        body.setText(method);
        if (i == 1) {
            spacer.setVisibility(View.INVISIBLE);
        }
        methodViewGroup.addView(v);
    }

    public ArrayList<CocktailIngredient> makeIngredientArrayList() {
        ArrayList<CocktailIngredient> ingredients = new ArrayList<>();

        CocktailIngredient exampleOne = new CocktailIngredient("Lime Juice", "Non-Alcoholic",15,"ml");
        CocktailIngredient exampleTwo = new CocktailIngredient("Vodka", "Alcoholic",30,"ml");
        CocktailIngredient exampleThree = new CocktailIngredient("Lime Wedges", "Non-Alcoholic",4,"");

        ingredients.add(exampleOne);
        ingredients.add(exampleTwo);
        ingredients.add(exampleThree);

        return ingredients;
    }
}
