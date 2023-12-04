package com.example.alarmaindent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnAlarma;
    private TimePicker tpHora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extracted();
    }

    private void extracted() {
        btnAlarma = findViewById(R.id.btnAlarma);
        tpHora = findViewById(R.id.tpHora);
    }


    public void onClickBtn(View view) {

        String mensaje = "Esto es el aviso actual de mi alarma";

        int hora = tpHora.getHour();
        int minutos = tpHora.getMinute();

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, mensaje);
        intent.putExtra(AlarmClock.EXTRA_HOUR, hora);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minutos);

        if (intent.resolveActivity(getPackageManager()) != null){

            startActivity(intent);

        } else {

            Toast.makeText(this, "Error al realizar la acción", Toast.LENGTH_SHORT).show();

        }

    }
}