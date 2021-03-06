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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddCocktailActivity extends AppCompatActivity {

    LayoutInflater inflater;
    ViewGroup methodViewGroup, ingredientViewGroup;
    List<CocktailIngredient> ingredients;
    List<MethodItem> methods;
    boolean isIngredientClicked = false, isMethodClicked = false;

    private static final int ADD_INGREDIENT_REQUEST = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cocktail);

        final MySQLDBHelper helper = MySQLDBHelper.getInstance(AddCocktailActivity.this);

        methodViewGroup = (ViewGroup) findViewById(R.id.methodList);
        ingredientViewGroup = (ViewGroup) findViewById(R.id.ingredientList);

        //create a list of ingredients for test purposes
        ingredients = new ArrayList<>();
        methods = new ArrayList<>();

        final LinearLayout addMethod = (LinearLayout) findViewById(R.id.addMethodLayout);
        final LinearLayout addIngredient = (LinearLayout) findViewById(R.id.addIngredientLayout);


        View ingredientButton = (Button) findViewById(R.id.ingredientButton);
        ingredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addMethod.setVisibility(View.GONE);
                isMethodClicked = false;
                if (!isIngredientClicked) {
                    addIngredient.setVisibility(View.VISIBLE);
                    int i = addIngredientActivity();
                } else {
                    addIngredient.setVisibility(View.GONE);
                }
                isIngredientClicked = !isIngredientClicked;
            }
        });

        View methodButton = (Button) findViewById(R.id.methodButton);
        methodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addIngredient.setVisibility(View.GONE);
                isIngredientClicked = false;
                if (!isMethodClicked) {
                    TextView number = (TextView) findViewById(R.id.addMethodNumber);
                    number.setText(""+(methods.size()+1));
                    addMethod.setVisibility(View.VISIBLE);
                    int i = addMethodActivity();
                } else {
                    addMethod.setVisibility(View.GONE);
                }
                isMethodClicked = !isMethodClicked;

            }
        });

        View addCocktailButton = (Button) findViewById(R.id.addCocktailButton);
        addCocktailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editName = (EditText) findViewById(R.id.nameEdit);
                EditText editAuthor = (EditText) findViewById(R.id.authorEdit);
                EditText editCategory = (EditText) findViewById(R.id.typeEdit);

                String mName = editName.getText().toString();
                String mAuthor = editAuthor.getText().toString();
                String mCategory = editCategory.getText().toString();

                Cocktail c = new Cocktail(mName, mAuthor, mCategory, methods, ingredients);
                helper.addToDB(c);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        for (CocktailIngredient i : ingredients) {
            addIngredientListItem(i);
        }
    }

    public int addMethodActivity() {
        int toReturn = 0;
        Button done = (Button) findViewById(R.id.methodDone);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout addIngredient = (LinearLayout) findViewById(R.id.addMethodLayout);
                EditText body = (EditText) findViewById(R.id.addMethodBody);

                String mBody = body.getText().toString();
                int mNumber = methods.size()+1;

                MethodItem m = new MethodItem(mBody,mNumber);
                methods.add(m);
                addMethodListItem(m.getPosition(),m.getMethod());

                addIngredient.setVisibility(View.GONE);
                isIngredientClicked = false;
                isMethodClicked = false;
            }
        });

        return toReturn;
    }

    public int addIngredientActivity() {
        int toReturn = 0;
        Button done = (Button) findViewById(R.id.ingredientDone);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout addIngredient = (LinearLayout) findViewById(R.id.addIngredientLayout);
                EditText name = (EditText) findViewById(R.id.addIngredientName);
                EditText quantity = (EditText) findViewById(R.id.addIngredientQuantity);
                EditText measurement = (EditText) findViewById(R.id.addIngredientMeasurement);
                CheckBox main = (CheckBox) findViewById(R.id.addIngredientMain);
                CheckBox garnish = (CheckBox) findViewById(R.id.addIngredientGarnish);

                String mName = name.getText().toString();
                int mQuantity;
                try {
                    mQuantity = Integer.parseInt(quantity.getText().toString());
                } catch (Exception e) {
                    mQuantity = -1;
                }
                String mMeasurement = measurement.getText().toString();

                int isMain;
                int isGarnish;

                if (main.isSelected()) {
                    isMain = 1;
                } else {
                    isMain = 0;
                }

                if (garnish.isSelected()) {
                    isGarnish = 1;
                } else {
                    isGarnish = 0;
                }

                CocktailIngredient c = new CocktailIngredient(mName,mQuantity,mMeasurement,isMain,isGarnish);
                ingredients.add(c);
                addIngredientListItem(c);

                addIngredient.setVisibility(View.GONE);
                isIngredientClicked = !isIngredientClicked;
            }
        });

        return toReturn;
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

        number.setText("" +i+".");
        body.setText(method);

        methodViewGroup.addView(v);
    }
}
