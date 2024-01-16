package com.example.listados_adaptadores;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Spinner_5_Activity extends AppCompatActivity {

    private Button btnInsertar;
    private EditText txtDinamico;
    private Spinner spin;
    private ArrayList<String> contents = new ArrayList<>();
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner5);

        this.btnInsertar = findViewById(R.id.btnInsertar);
        this.txtDinamico = findViewById(R.id.txtDinamico);
        this.spin = findViewById(R.id.spPlanetas5);

        this.adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, this.contents);
        spin.setAdapter(adaptador);

        this.spin.setVisibility(View.GONE);
    }


    public void onClickBtnInsertar(View view) {

        if (txtIsEmpty()){

            Toast.makeText(this, "No se puedes insertar \nvalores vacios", Toast.LENGTH_SHORT).show();

        }else{

            String newElement = this.getContents();
            this.addToList(newElement);
            this.spin.setVisibility(View.VISIBLE);

        }

    }

    private boolean txtIsEmpty(){

        return this.getContents().trim().isEmpty();

    }

    private String getContents(){

        return txtDinamico.getText().toString();

    }

    private void addToList(String s){

        this.contents.add(s);
        this.recastAdapter();
        this.cleanupField();

    }

    private void recastAdapter(){

        this.adaptador.notifyDataSetChanged();

    }

    private void cleanupField(){

        this.txtDinamico.setText("");

    }
}