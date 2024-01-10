package com.example.ex8_lanzaractividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Ciclo","OnCreate");
    }

    public void onClickCambioActivity(View view){

        Intent i = null;

        if(view.getId() == R.id.llamadaActividad2){

            i = new Intent(this, Activity2.class);


        }else if(view.getId() == R.id.llamadaActividad3){

            i = new Intent(this, Activity3.class);

            String dato = "Texto enviado por la activity 1";

            i.putExtra("mensaje",dato);

        }

        startActivity(i);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo","OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo","OnStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo","OnPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo","OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo","OnDestroy");
    }
}