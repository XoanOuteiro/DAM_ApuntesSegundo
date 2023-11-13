package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();

        String dato = intent.getStringExtra("mensaje");

        TextView txtMensaje = findViewById(R.id.txtMensaje);
        txtMensaje.setText(dato);
    }
}