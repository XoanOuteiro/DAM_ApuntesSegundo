package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Spinner_3_Activity extends AppCompatActivity {

    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner3);

        this.spin = findViewById(R.id.spPlanetas3);

        /*
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.planetas, android.R.layout.simple_spinner_dropdown_item);
        this.spin.setAdapter(adaptador);
        */

        //Capturando recursos mediante getResources()
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this , android.R.layout.simple_spinner_dropdown_item , getResources().getStringArray(R.array.planetas));


        //Asignacion
        this.spin.setAdapter(adaptador);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String elementoSeleccionado = spin.getSelectedItem().toString();
                String elementoSeleccionado2 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Spinner_3_Activity.this, "Seleccionaste " + elementoSeleccionado + "\n" + elementoSeleccionado2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}