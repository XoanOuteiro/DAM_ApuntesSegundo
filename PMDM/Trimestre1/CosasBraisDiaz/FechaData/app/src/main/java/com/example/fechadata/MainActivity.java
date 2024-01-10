package com.example.fechadata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnRes;
    private DatePicker dpFecha;
    private TimePicker tpHora;
    private String mensaje_con_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRes = findViewById(R.id.btnResult);
        dpFecha = findViewById(R.id.dpFecha);
        tpHora = findViewById(R.id.tpHora);
    }


    public void onClickBtn(View view) {
        if (view.getId() == R.id.btnResult){

            int dia = dpFecha.getDayOfMonth();
            int mes = dpFecha.getMonth()+1;
            int anho = dpFecha.getYear();

            int hora;
            int minutos;

            if (android.os.Build.VERSION.SDK_INT >= 23) {

                hora = tpHora.getHour();
                minutos = tpHora.getMinute();

            } else {

                hora = tpHora.getCurrentHour();
                minutos = tpHora.getCurrentMinute();

            }

            
            mensaje_con_datos = "Fecha: " + dia + "-" + mes + "-" + anho + "\n" + "Hora: " + hora + ":" + minutos;

            Toast.makeText(this, mensaje_con_datos, Toast.LENGTH_SHORT).show();


        }

    }
}