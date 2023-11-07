package com.example.ex8_lanzaractividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}