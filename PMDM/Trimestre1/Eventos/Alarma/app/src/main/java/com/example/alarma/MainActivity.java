package com.example.alarma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnActivarAlarma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnActivarAlarma = findViewById(R.id.btnActivarAlarma);
    }

    public void onClickBtn(View view) {

        int i = view.getId();

        if (R.id.btnActivarAlarma == i) {

            String avisoAlarma = "Esto es el aviso de mi alarma";
            int hora = 10;
            int minutos = 13;


            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, avisoAlarma);
            intent.putExtra(AlarmClock.EXTRA_HOUR, hora);
            intent.putExtra(AlarmClock.EXTRA_MINUTES, minutos);

            if(intent.resolveActivity(getPackageManager())!= null){

                startActivity(intent);

            }else{

                Toast.makeText(this, "No se pudo crear la alarma", Toast.LENGTH_SHORT).show();

            }

        }


    }
}