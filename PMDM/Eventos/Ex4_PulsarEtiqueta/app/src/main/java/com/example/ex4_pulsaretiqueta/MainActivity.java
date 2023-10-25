package com.example.ex4_pulsaretiqueta;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView label;
    int colorFondo = Color.parseColor("#39FF14");
    int colorTexto = Color.parseColor("#4287f5");
    boolean rm = false;
    float rotation = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init
        this.label = findViewById(R.id.label);

        //Solo ex4
        /*
        label.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                label.setRotation(45.0f);
                label.setBackgroundColor(colorFondo);
                label.setTextColor(colorTexto);
                label.setTextSize(50f);
                label.setText("HOOOOOLA!!");

            }
        });
        */

        //Ex 4.2
        label.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(!rm){

                    rm = true;
                    label.setBackgroundColor(colorFondo);
                    label.setTextColor(colorTexto);
                    label.setTextSize(50f);
                    label.setText("HOOOOOLA!!");

                } else {


                    rotation += 45.0f;

                    if(rotation == 360){

                        rotation = 0;

                    }

                }

                label.setRotation(rotation);
            }
        });
    }
}