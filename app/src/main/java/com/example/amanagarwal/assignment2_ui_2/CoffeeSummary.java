package com.example.amanagarwal.assignment2_ui_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CoffeeSummary extends AppCompatActivity {

    ArrayList<String> coffees;
    TextView count;
    RecyclerView recyclerView;
    CoffeeSummaryAdaptor coffeeSummaryAdaptor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_summary_activity);

        coffees = getIntent().getStringArrayListExtra("summary");

        count = findViewById(R.id.textView2);
        count.setText(String.valueOf(coffees.size()));

        recyclerView = (RecyclerView) findViewById(R.id.recycler2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        coffeeSummaryAdaptor = new CoffeeSummaryAdaptor(this, coffees);
        recyclerView.setAdapter(coffeeSummaryAdaptor);
    }

    public void onDoneButtonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
