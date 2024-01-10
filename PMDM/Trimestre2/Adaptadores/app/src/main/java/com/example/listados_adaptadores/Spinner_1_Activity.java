package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class Spinner_1_Activity extends AppCompatActivity {

    private Spinner spnPlanetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner1);

        this.spnPlanetas = findViewById(R.id.spPlanetas1);

        spnPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String elementoSeleccionado = spnPlanetas.getSelectedItem().toString();
                String elementoSeleccionado2 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Spinner_1_Activity.this, "Seleccionaste " + elementoSeleccionado + "\n" + elementoSeleccionado2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}