package com.example.amanagarwal.assignment2_ui_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private CheckBox actionCheckBox;
    private Button chooseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionCheckBox = (CheckBox)findViewById(R.id.actionCheckbox);
        chooseButton = (Button)findViewById(R.id.chooseButton);

        actionCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox actionCheckBox = (CheckBox)findViewById(R.id.actionCheckbox);
                Button chooseButton = (Button)findViewById(R.id.chooseButton);

                boolean checked = actionCheckBox.isChecked();

                if (checked)
                    chooseButton.setEnabled(true);
                else
                    chooseButton.setEnabled(false);
            }
        });

        actionCheckBox.setChecked(false);
        chooseButton.setEnabled(false);
    }

    public void onChooseButtonClicked(View view) {
        Intent intent = new Intent(this, CoffeeSelectionActivity.class);
        startActivity(intent);
    }
}