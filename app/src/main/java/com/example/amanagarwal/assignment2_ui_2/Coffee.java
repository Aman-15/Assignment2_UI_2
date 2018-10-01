package com.example.amanagarwal.assignment2_ui_2;

public class Coffee {

    private int id;
    private String heading;
    private String ingredients;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Coffee(int id, String heading, String ingredients) {
        this.id = id;
        this.heading = heading;
        this.ingredients = ingredients;

    }

    public String getHeading() {
        return heading;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getId() {
        return id;
    }
}
