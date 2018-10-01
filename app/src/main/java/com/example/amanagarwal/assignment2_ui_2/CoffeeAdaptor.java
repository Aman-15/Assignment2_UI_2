package com.example.amanagarwal.assignment2_ui_2;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class CoffeeAdaptor extends RecyclerView.Adapter<CoffeeAdaptor.CoffeeViewHolder> {

    private Context context;
    private List<Coffee> coffeeList;
    private SparseBooleanArray selectionState;

    public CoffeeAdaptor(Context context, List<Coffee> coffeeList, SparseBooleanArray selectionState) {
        this.context = context;
        this.coffeeList = coffeeList;
        this.selectionState = selectionState;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.coffee_list, null);
        return new CoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder coffeeViewHolder, int i) {
        Coffee coffee = coffeeList.get(i);


        if (!selectionState.get(i, false)) {
            coffeeViewHolder.checkBox.setChecked(false);}
        else {
            coffeeViewHolder.checkBox.setChecked(true);
        }

        coffeeViewHolder.coffeeType.setText(coffee.getHeading());
        coffeeViewHolder.ingredients.setText(coffee.getIngredients());
    }

    @Override
    public int getItemCount() {
        return coffeeList.size();
    }

    class CoffeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView coffeeType, ingredients;
        CheckBox checkBox;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);

            coffeeType = itemView.findViewById(R.id.coffeeType);
            ingredients = itemView.findViewById(R.id.coffeeIngredients);
            checkBox = itemView.findViewById(R.id.checkbox);
            checkBox.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            if (!selectionState.get(adapterPosition, false)) {

                if (selectionState.size() < 7) {
                    checkBox.setChecked(true);
                    selectionState.put(adapterPosition, true);
                }
                else {
                    checkBox.setChecked(false);
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(context);
                    }
                    builder.setTitle("Limit Exceeded!")
                            .setMessage("You can select atmost 7 coffee types.")
                            .setPositiveButton(android.R.string.yes, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
            else  {
                checkBox.setChecked(false);
                selectionState.delete(adapterPosition);
            }
        }
    }
}
