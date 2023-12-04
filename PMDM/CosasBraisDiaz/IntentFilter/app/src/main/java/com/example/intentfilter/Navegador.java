package com.example.intentfilter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Navegador extends AppCompatActivity {

    private WebView wbUrl;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);
        Log.i("ciclo","Ejecutando onCreate()");
        Log.i("ciclo","Contador = " + contador);

        extracted();

        WebSettings ws = wbUrl.getSettings();
        ws.setJavaScriptEnabled(true);

        cargarURL();
    }

    private void cargarURL() {
        Intent intent = getIntent();
        wbUrl.loadUrl(intent.getStringExtra("enlace"));
    }

    private void extracted() {
        wbUrl = findViewById(R.id.wbUrl);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    //=================================================//


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