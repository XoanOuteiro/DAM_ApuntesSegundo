package com.example.expulsaetiqueta;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView label;
    float rotation=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.label= findViewById(R.id.label);

        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                label.setText("Hola!");
                label.setRotation(rotation);
                rotation+=45;
                label.setTextSize(getResources().getDimension(R.dimen.tamanhoLetra));
                label.setBackgroundColor(getResources().getColor(R.color.purple));
                label.setTextColor(getResources().getColor(R.color.red));
                if (rotation>=360){
                    rotation=0;
                }
            }
        });
    }
}