package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Ciclo","OnCrete");
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