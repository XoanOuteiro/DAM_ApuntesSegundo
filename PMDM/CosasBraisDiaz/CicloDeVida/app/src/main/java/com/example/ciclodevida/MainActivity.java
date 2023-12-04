package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ciclo","Ejecutando onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo","Ejecutando onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo","Ejecutando onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo","Ejecutando onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo","Ejecutando onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart()");
    }

    public void onClickFinalizar(View view) {
        finish();

    }
}