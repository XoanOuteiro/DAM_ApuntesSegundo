package com.example.fechadata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

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

            String dia = dpFecha.getDayOfMonth();
            String 

        }
    }
}