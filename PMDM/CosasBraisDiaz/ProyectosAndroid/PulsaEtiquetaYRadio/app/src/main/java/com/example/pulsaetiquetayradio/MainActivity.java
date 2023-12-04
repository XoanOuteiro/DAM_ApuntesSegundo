package com.example.pulsaetiquetayradio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView label;
    RadioGroup radiog;
    RadioButton rbtView;
    RadioButton rbtImagen;
    Button btnAceptar;
    EditText etGrados;
    int rotation=0;
    int posicion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.label = findViewById(R.id.label);
        this.rbtView = findViewById(R.id.rbtView);
        this.rbtImagen = findViewById(R.id.rbtImagen);
        this.btnAceptar = findViewById(R.id.btnAceptar);
        this.etGrados = findViewById(R.id.etGrados);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    rotation = Integer.parseInt(etGrados.getText().toString());
                    label.setText("");
                    if (rbtView.isChecked()){
                        label.setText("Hola!");
                        label.setTextSize(getResources().getDimension(R.dimen.tamanhoLetra));
                        label.setBackgroundColor(getResources().getColor(R.color.purple));
                        label.setTextColor(getResources().getColor(R.color.red));
                    }
                    else if (rbtImagen.isChecked()){
                        label.setBackground(getDrawable(R.drawable.imagen_abc));
                    }
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "La rotación tiene que tener un valor", Toast.LENGTH_SHORT).show();
                }
            }
        });


        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicion+=rotation;
                label.setRotation(posicion);
                if (posicion>=360){
                    posicion=0;
                }
            }
        });
    }
}