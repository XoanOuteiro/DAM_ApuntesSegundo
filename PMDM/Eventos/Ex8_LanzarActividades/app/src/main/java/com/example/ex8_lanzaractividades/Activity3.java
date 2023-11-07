package com.example.ex8_lanzaractividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent i = getIntent();

        String datoRecibido = getIntent().getStringExtra("mensaje");

        TextView tv = findViewById(R.id.tvMensajeRecibido);

        tv.setText(datoRecibido);
    }
}