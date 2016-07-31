package com.hfad.cocktailapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        Intent i = getIntent();
        int id = i.getIntExtra("id",-1);

        TextView textView = (TextView) findViewById(R.id.detailText);
        textView.setText("" + id);
    }
}
