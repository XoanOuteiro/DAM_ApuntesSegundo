package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Spinner_2_Activity extends AppCompatActivity {
    private Spinner spPlanetas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);
        this.spPlanetas2 = findViewById(R.id.spPlanetas2);

        String[] arrayPlanetas = {"Mercurio","Venus","Tierra","Marte","Jupiter","Saturno","Urano","Neptuno"};

        //adapter usage
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item , arrayPlanetas);

        //asign adapter to spinner
        spPlanetas2.setAdapter(adapter);
        spPlanetas2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}