package com.example.ex8_lanzaractividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Log.i("Ciclo", "onCreate_2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo","OnStart_2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo","OnStop_2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo","OnResume_2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo","OnPause_2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo","OnRestart_2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo","OnDestroy_2");
    }
}