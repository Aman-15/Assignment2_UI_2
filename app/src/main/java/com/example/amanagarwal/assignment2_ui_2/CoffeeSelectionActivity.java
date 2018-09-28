package com.example.amanagarwal.assignment2_ui_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CoffeeSelectionActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CoffeeAdaptor coffeeAdaptor;

    SparseBooleanArray selectionState = new SparseBooleanArray();

    List<Coffee> coffeeList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_selection_activity);

        coffeeList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        coffeeList.add(
                new Coffee(0, "Vanilla Cream Frappuccino®", "coffee")
        );
        coffeeList.add(
                new Coffee(1, "Caramel Cream Frappuccino®", "coffee")
        );
        coffeeList.add(
                new Coffee(2, "Double Chocolate Chip Frappuccino®", "coffee")
        );
        coffeeList.add(
                new Coffee(3, "Chocolate Cream Frappuccino®", "coffee")
        );
        coffeeList.add(
                new Coffee(4, "White Chocolate Cream Frappuccino®", "coffee")
        );
        coffeeList.add(
                new Coffee(5, "Green Tea Cream Frappuccino®", "coffee")
        );
        coffeeList.add(
                new Coffee(6, "Chai Tea Cream Frappuccino®", "coffee")
        );
        coffeeList.add(
                new Coffee(7, "Strawberries & Crème Frappuccino®", "coffee")
        );
        coffeeList.add(
                new Coffee(8, "Caffè Latte", "coffee")
        );
        coffeeList.add(
                new Coffee(9, "Vanilla Latte", "coffee")
        );
        coffeeList.add(
                new Coffee(10, "Cocoa Cappuccino", "coffee")
        );
        coffeeList.add(
                new Coffee(11, "Caffè Mocha", "coffee")
        );
        coffeeList.add(
                new Coffee(12, "White Chocolate Mocha", "coffee")
        );
        coffeeList.add(
                new Coffee(13, "Caffè Americano", "coffee")
        );
        coffeeList.add(
                new Coffee(14, "Caramel Macchiato", "coffee")
        );
        coffeeList.add(
                new Coffee(15, "Espresso Macchiato", "coffee")
        );
        coffeeList.add(
                new Coffee(16, "Iced Americano", "coffee")
        );
        coffeeList.add(
                new Coffee(17, "Iced Caramel Macchiato", "coffee")
        );
        coffeeList.add(
                new Coffee(18, "Iced Latte", "coffee")
        );
        coffeeList.add(
                new Coffee(19, "Espresso Con Panna", "coffee")
        );
        coffeeList.add(
                new Coffee(20, "Caramel Mocha", "coffee")
        );
        coffeeList.add(
                new Coffee(21, "Iced Hibiscus & Passion Lemonade", "coffee")
        );
        coffeeList.add(
                new Coffee(22, "Iced Shaken Black Tea", "coffee")
        );

        coffeeAdaptor = new CoffeeAdaptor(this, coffeeList, selectionState);
        recyclerView.setAdapter(coffeeAdaptor);
    }

    public void onLetsGoButtonClicked(View view) {

        if (selectionState.size() > 0) {

            ArrayList<String> coffees = generateList();

            Intent intent = new Intent(this, CoffeeSummary.class);
            intent.putStringArrayListExtra("summary", coffees);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "No selections made!", Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<String> generateList() {
        ArrayList<String> coffees = new ArrayList<>();

        for (int i=0; i<selectionState.size(); i++) {
            coffees.add(coffeeList.get(selectionState.keyAt(i)).getHeading());
        }

        return coffees;
    }
}
