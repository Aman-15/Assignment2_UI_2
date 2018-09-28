package com.example.amanagarwal.assignment2_ui_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CoffeeSummaryAdaptor extends RecyclerView.Adapter<CoffeeSummaryAdaptor.CoffeeSummaryViewHolder> {

    private Context context;
    private ArrayList<String> coffees;

    public CoffeeSummaryAdaptor(Context context, ArrayList<String> coffees) {
        this.context = context;
        this.coffees = coffees;
    }

    @NonNull
    @Override
    public CoffeeSummaryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.coffee_summary_list, null);

        return new CoffeeSummaryAdaptor.CoffeeSummaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeSummaryViewHolder coffeeSummaryViewHolder, int i) {
        coffeeSummaryViewHolder.coffeeSummary.setText(coffees.get(i));
    }

    @Override
    public int getItemCount() {
        return coffees.size();
    }

    class CoffeeSummaryViewHolder extends RecyclerView.ViewHolder {

        TextView coffeeSummary;

        public CoffeeSummaryViewHolder(@NonNull View itemView) {
            super(itemView);
            coffeeSummary = itemView.findViewById(R.id.coffeeSummary);
        }
    }
}
