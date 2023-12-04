package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity5 extends AppCompatActivity {
    private Button btnRetornar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        btnRetornar = findViewById(R.id.btnEnviarRespuesta);
        Log.i("ciclo","Ejecutando onCreate() on Activity 5");
        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //operaciones que queremos que se ejecuten al pulsar
                //volver a la actividad 1 enviándole un dato
                String mensajeRespuesta = "Respondiendo desde la actividad 5";
                Intent intent = new Intent();
                intent.putExtra("mensaje_retornado", mensajeRespuesta);
                setResult(RESULT_OK, intent);
                Log.i("ciclo","Ejecutando listener() on Activity 5");
                finish();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo","Ejecutando onStart() on Activity 5");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo","Ejecutando onResume() on Activity 5");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo","Ejecutando onStop() on Activity 5");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo","Ejecutando onPause() on Activity 5");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy() on Activity 5");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart() on Activity 5");
    }

    public void onClickFinalizar(View view) {
        finish();

    }

}