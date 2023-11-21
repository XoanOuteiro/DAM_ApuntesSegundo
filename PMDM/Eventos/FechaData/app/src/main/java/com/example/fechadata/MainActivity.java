package com.example.fechadata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnActivarAlarma;
    private TimePicker tpHora;
    private DatePicker dpFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnActivarAlarma = findViewById(R.id.btnActviarAlarma);
        this.dpFecha = findViewById(R.id.dpFecha);
        this.tpHora = findViewById(R.id.tpHora);

    }

    public void onClickBtn(View view) {

        if(view == this.btnActivarAlarma){

            int dia = dpFecha.getDayOfMonth();
            int mes = dpFecha.getMonth();
            int anho = dpFecha.getYear();

            int hora;
            int minutos;

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

                hora = tpHora.getHour();
                minutos = tpHora.getMinute();

            }else{

                hora = tpHora.getCurrentHour();
                minutos = tpHora.getCurrentMinute();

            }

            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
            intent.putExtra(AlarmClock.EXTRA_HOUR, hora);
            intent.putExtra(AlarmClock.EXTRA_MINUTES, minutos);

            if(intent.resolveActivity(getPackageManager())!= null){

                startActivity(intent);

            }else{

                Toast.makeText(this, "Error al llamar alarma", Toast.LENGTH_SHORT).show();

            }

            String mensaje_con_datos = "Fecha: " + dia + " - " + mes + " - " + anho + "\n Hora: " + hora + " : " + minutos;
            Toast.makeText(this, mensaje_con_datos, Toast.LENGTH_SHORT).show();

        }
    }
}