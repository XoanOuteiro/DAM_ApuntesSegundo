package com.example.ex3_cuentaclickssimple;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnPulsa;
    private TextView status;

    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Anular el giro mediante código
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Log.i("ciclo","Ejecutando onCreate()");
        Log.i("ciclo","contador = " + num);

        //Inits
        this.status = findViewById(R.id.status);
        this.btnPulsa = findViewById(R.id.btnPulsa);

        /*
        if (savedInstanceState != null){
            num = savedInstanceState.getInt("contador");

            Log.i("ciclo","contador = " + num);

            if (num == 1){
                status.setText("Has pulsado " + num + " vez.");
            } else {
                status.setText("Has pulsado " + num + " veces.");
            }

        }
        */

        //Asignación (método 3 (o 2.2) en ex2)
        btnPulsa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                status.setText("");

                num += 1;

                if (num == 1){
                    status.setText("Has pulsado " + num + " vez.");
                } else {
                    status.setText("Has pulsado " + num + " veces.");
                }

            }
        });

    }


    /*================================================================
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contador", num);
        Log.i("ciclo","Ejecutando onSaveInstanceState()");
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        num = savedInstanceState.getInt("contador");
        Log.i("ciclo","Ejecutando onRestoreInstanceState()");

        if (num == 1){
            status.setText("Has pulsado " + num + " vez.");
        } else {
            status.setText("Has pulsado " + num + " veces.");
        }
    }
    ====================================================================*/

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