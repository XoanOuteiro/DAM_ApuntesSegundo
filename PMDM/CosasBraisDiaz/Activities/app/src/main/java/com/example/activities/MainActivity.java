package com.example.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String dato;
    private static final int LLAMADA_ACTIVIDAD5 = 0;
    private TextView txtEscucha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEscucha = findViewById(R.id.txtEscucha);
        Log.i("ciclo","Ejecutando onCreate() on Activity 1");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo","Ejecutando onStart() on Activity 1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo","Ejecutando onResume() on Activity 1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo","Ejecutando onStop() on Activity 1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo","Ejecutando onPause() on Activity 1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy() on Activity 1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart() on Activity 1");
    }

    public void onClickFinalizar(View view) {
        finish();

    }


    public void onClickCambioActivity(View view) {
        Intent intent = null;
        if (view.getId()==R.id.btnLlamadaAct2){
            intent = new Intent(this, Activity2.class);
            startActivity(intent);

        } else if (view.getId()==R.id.btnLlamadaAct3) {
            intent = new Intent(this, Activity3.class);
            dato = "El Activity 1 envía este mensaje a la activity3";
            intent.putExtra("mensaje", dato);
            startActivity(intent);


        } else if (view.getId()==R.id.btnLlamadaAct4) {
            intent = new Intent(this, Activity4.class);
            dato = "El Activity 1 envía este mensaje a la activity4 a través de un bundle";

            Bundle bundle = new Bundle();
            bundle.putString("mensaje", dato);

            intent.putExtras(bundle);
            startActivity(intent);
        } else if (view.getId() == R.id.btnLlamadaEsperaRespuesta){
            intent = new Intent(this, Activity5.class);

            //LLamada esperando respuesta
            startActivityForResult(intent, LLAMADA_ACTIVIDAD5);
        } else if (view.getId() == R.id.btnLlamadaOtraApp) {
            intent = new Intent();
            intent.setClassName("com.example.ex3_cuentaclick","com.example.ex3_cuentaclick.MainActivity");


            try {
                startActivity(intent);
            } catch (ActivityNotFoundException a){
                Toast.makeText(this, "Ninguna actividad puede realizar esta acción", Toast.LENGTH_SHORT).show();
            }


            //Opción con Package Manager

            /* PackageManager pm = getPackageManager();
            List actividadesPosibles = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (actividadesPosibles.size()>0){
                startActivity(intent);
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }*/
        } else if (view.getId()==R.id.btnLlamadaSystemApp){
            try {
                intent = new Intent();
                intent.setClassName("com.android.calculator2","com.android.calculator2.Calculator");
                startActivity(intent);
            } catch (ActivityNotFoundException act){
                Toast.makeText(this, "No se encontró la calculadora", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId()==R.id.btnLlamadaSystemAppSettings){
            try {
                intent = new Intent();
                intent.setClassName("com.android.settings","com.android.settings.Settings");
                startActivity(intent);
            } catch (ActivityNotFoundException act){
                Toast.makeText(this, "No se encontraron las Settings", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Vemos quien nos contesta
        if (requestCode == LLAMADA_ACTIVIDAD5){
            //testeamos el código del resultado
            if (resultCode == RESULT_OK){
                //operaciones si la actividad llamada finaliza según lo previsto
                Toast.makeText(this, "Todo ok", Toast.LENGTH_SHORT).show();
                txtEscucha.setText(data.getStringExtra("mensaje_retornado"));
            } else {
                //operaciones si la actividad llamada no hace lo previsto
                Toast.makeText(this, "Algo falló", Toast.LENGTH_SHORT).show();
            }
        }
    }


}