package com.hfad.cocktailapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by matthewtduffin on 29/07/16.
 */
public class IngredientListAdapter extends BaseAdapter {

        private final LayoutInflater inflater;
        private final ArrayList<CocktailIngredient> listItems;
        private final Context context;

        public IngredientListAdapter(Context context, ArrayList<CocktailIngredient> listItems) {
            inflater = LayoutInflater.from(context);
            this.listItems = listItems;
            this.context = context;
        }

        @Override
        public int getCount() {

            Log.d("Pos","Entered getCount method");
            return listItems.size();
        }

        @Override
        public Object getItem(int position) {
            return listItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View child, ViewGroup parent) {

            Log.d("Postion: ", "" + position);

            View v = child;
            ViewGroup vG = parent;
            TextView name, quantity;

            if (v == null) {
                v = inflater.inflate(R.layout.ingredient_list_item, parent, false);
            }

            name = (TextView) v.findViewById(R.id.ingredientName);
            quantity = (TextView) v.findViewById(R.id.ingredientQuantity);

            CocktailIngredient current = listItems.get(position);

            String currentName = current.getName();
            String currentQuantity = current.getQuantityMeasure();

            name.setText(currentName);
            quantity.setText(currentQuantity);


            Log.d("Pointer","getView used at position " +position);

            return v;
        }
    }


