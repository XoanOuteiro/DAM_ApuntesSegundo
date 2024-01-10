package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String mensaje = bundle.getString("mensaje");

        TextView txtMensaje = findViewById(R.id.txtMensaje);
        txtMensaje.setText(mensaje);
    }
}