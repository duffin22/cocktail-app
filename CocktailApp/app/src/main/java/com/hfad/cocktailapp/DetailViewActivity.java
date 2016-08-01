package com.hfad.cocktailapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailViewActivity extends AppCompatActivity {

    LayoutInflater inflater;
    ViewGroup ingredientViewGroup, methodViewGroup;
    MySQLDBHelper helper = MySQLDBHelper.getInstance(DetailViewActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        Intent i = getIntent();
        int id = i.getIntExtra("id",-1);

        Cocktail cocktail = helper.createCocktailFromId(id);

        TextView name = (TextView) findViewById(R.id.titleText);
        name.setText(cocktail.getName());

        TextView category = (TextView) findViewById(R.id.categoryText);
        category.setText(cocktail.getCategory());

        TextView author = (TextView) findViewById(R.id.authorText);
        author.setText(cocktail.getAuthor());


        ingredientViewGroup = (ViewGroup) findViewById(R.id.ingredientListDetail);
        List<CocktailIngredient> ings = cocktail.getIngredients();
        for (CocktailIngredient ing : ings) {
            addIngredientListItem(ing);
        }

        methodViewGroup = (ViewGroup) findViewById(R.id.methodListDetail);
        List<MethodItem> meths = cocktail.getMethods();
        for (MethodItem meth : meths) {
            addMethodListItem(meth);
        }

    }

    public List<CocktailIngredient> getCocktailIngredients(int id) {

        List<CocktailIngredient> ings = helper.getAllIngredients(id);
        return ings;

    }

    public void addMethodListItem(MethodItem method) {
        inflater = LayoutInflater.from(DetailViewActivity.this);
        View v = inflater.inflate(R.layout.method_list_item, methodViewGroup, false);
        TextView number = (TextView) v.findViewById(R.id.methodNumber);
        TextView body = (TextView) v.findViewById(R.id.methodBody);

        number.setText("" + method.getPosition());
        body.setText(method.getMethod());
        methodViewGroup.addView(v);
    }


    public void addIngredientListItem(CocktailIngredient ingredient) {
        inflater = LayoutInflater.from(DetailViewActivity.this);
        View v = inflater.inflate(R.layout.ingredient_list_item, ingredientViewGroup, false);
        TextView quantity = (TextView) v.findViewById(R.id.ingredientQuantity);
        TextView name = (TextView) v.findViewById(R.id.ingredientName);

        quantity.setText(ingredient.getQuantityMeasure());
        name.setText(ingredient.getName());
        ingredientViewGroup.addView(v);
    }
}
