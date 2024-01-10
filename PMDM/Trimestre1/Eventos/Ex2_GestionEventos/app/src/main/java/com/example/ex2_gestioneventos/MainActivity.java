package com.example.ex2_gestioneventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView status;
    private Button btnSi, btnNo, btnAveces, btnNoSe;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.status = findViewById(R.id.statusView);
        btnSi = findViewById(R.id.btnSi);
        btnNo = findViewById(R.id.btnNo);
        btnAveces = findViewById(R.id.btnAveces);
        btnNoSe = findViewById(R.id.btnNoSe);

        //Metodo 1
        //Instanciar el objeto de la clase auxiliar --> Objeto escuchador
        Auxiliar escuchador_btnSi = new Auxiliar();

        //Asociar escuchador al boton
        btnSi.setOnClickListener(escuchador_btnSi);

        //Metodo 2
        btnNo.setOnClickListener(escuchadorNo);

        //Metodo 2.2: Metodo "3 en 1" (creacion y asignacion en una sentencia)
        btnAveces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status.setText("Has pulsado el boton a veces");
            }
        });

        //Metodo 3
        btnNoSe.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        status.setText("Has pulsado el boton No se");

    }

    //Metodo 1: Crear clase auxiliar (es mejor usar Clases anónimas
    private class Auxiliar implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            status.setText("Has pulsado el botón Si");
        }
    }

    //Metodo 2: Crear una clase anónima
    private View.OnClickListener escuchadorNo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            status.setText("Has pulsado el botón No");

        }

    };




}