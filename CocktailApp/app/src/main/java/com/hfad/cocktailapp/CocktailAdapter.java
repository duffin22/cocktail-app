package com.hfad.cocktailapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by matthewtduffin on 31/07/16.
 */

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder> {

    private List<Cocktail> cocktails;
    private int rowLayout;
    private Context context;
    final MySQLDBHelper helper = MySQLDBHelper.getInstance(context);


    public static class CocktailViewHolder extends RecyclerView.ViewHolder {
        LinearLayout cocktailsLayout;
        TextView cocktailName;
        TextView cocktailAuthor;
        TextView cocktailType;
        View view;


        public CocktailViewHolder(View v) {
            super(v);
            cocktailsLayout = (LinearLayout) v.findViewById(R.id.cocktailListItem);
            cocktailName = (TextView) v.findViewById(R.id.cocktailName);
            cocktailAuthor = (TextView) v.findViewById(R.id.cocktailAuthor);
            cocktailType = (TextView) v.findViewById(R.id.cocktailType);
            view = v;

        }
    }

    public CocktailAdapter(List<Cocktail> movies, int rowLayout, Context context) {
        this.cocktails = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public CocktailViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CocktailViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CocktailViewHolder holder, final int position) {
        holder.cocktailName.setText(cocktails.get(position).getName());
        holder.cocktailType.setText(cocktails.get(position).getCategory());
        holder.cocktailAuthor.setText(cocktails.get(position).getAuthor());


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailViewActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                int id = helper.getCocktailId(cocktails.get(position).getName());
                i.putExtra("id",id);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cocktails.size();
    }
}