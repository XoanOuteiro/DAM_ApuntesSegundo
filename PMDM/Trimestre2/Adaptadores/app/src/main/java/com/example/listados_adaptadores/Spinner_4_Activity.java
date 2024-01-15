package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Spinner_4_Activity extends AppCompatActivity {

    private Spinner spin;
    private ArrayList<String> arrayDinamico = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner4);

        spin = findViewById(R.id.spPlanetas4);

        arrayDinamico.add("Mercurio");
        arrayDinamico.add("Venus");
        arrayDinamico.add("Saturno");
        arrayDinamico.add("Urano");
        arrayDinamico.add("Neptuno");

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayDinamico);

        spin.setAdapter(adaptador);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Spinner_4_Activity.this, "Has seleccionado " + spin.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}