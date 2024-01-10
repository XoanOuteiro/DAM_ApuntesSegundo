package com.example.eventoslistener1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvMensaje;
    private Button btnSi, btnNo, btnAVeces, btnNoSe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensaje = findViewById(R.id.tvMensaje);
        btnSi = findViewById(R.id.btnSi);
        btnNo = findViewById(R.id.btnNo);
        btnAVeces = findViewById(R.id.btnAVeces);
        btnNoSe = findViewById(R.id.btnNoSe);

        //Instanciamos el objeto de la clase auxiliar (que implementará la interfaz) --> Objeto escuchador
        Auxiliar escuchadorSi= new Auxiliar();
        //Asignar el escuchadorSi a la vista independiente (MÉTODO 1)
        btnSi.setOnClickListener(escuchadorSi);
        //Asignar el escuchadorNo a la vista (MÉTODO 2)
        btnNo.setOnClickListener(escuchadorNo);

        //Método 3: Crear el escuchador y asignarlo en un sólo paso
        btnAVeces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMensaje.setText("Has pulsado A Veces");
            }
        });

        //Asignar el escuchador mediante thiS (MÉTODO 4)
        btnNoSe.setOnClickListener(this);
    }




    //Método 1: Crear clase auxiliar
    private class Auxiliar implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            tvMensaje.setText("Has pulsado Si");
        }
    }

    //Método 2: Crear una clase anónima (más recomendable que el método 1)
    private View.OnClickListener escuchadorNo=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tvMensaje.setText("Has pulsado No");
        }
    };

    //Método 4: Implementar la interfaz al MainActivity directamente
    @Override
    public void onClick(View v) {
        tvMensaje.setText("Has pulsado No sé");
    }
}