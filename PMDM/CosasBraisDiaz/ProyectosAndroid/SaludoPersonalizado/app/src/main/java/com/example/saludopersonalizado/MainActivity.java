package com.example.saludopersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText etNombre, etAnho;
    RadioGroup rgGenero, rgSaludo;
    RadioButton rbtSra, rbtSr, rbtAdios, rbtHastaPronto;
    CheckBox chkSaludo;
    TextView txtSaludo, saludoFinal;
    Button btnSaludar;
    String genero = "Sra.";
    String nombre;
    int anhoNac;
    int edad;
    String edadSaludo;
    String despedida = "Adiós";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extracted();
        chkSaludo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    txtSaludo.setVisibility(View.VISIBLE);
                    rgSaludo.setVisibility(View.VISIBLE);
                } else {
                    txtSaludo.setVisibility(View.GONE);
                    rgSaludo.setVisibility(View.GONE);
                }
            }
        });
        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    nombre=etNombre.getText().toString();

                    rgGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId==R.id.sr){
                                genero="Sr.";
                            } else {
                                genero="Sra.";
                            }
                        }
                    });
                    rgSaludo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (checkedId==R.id.adios){
                                despedida = rbtAdios.getText().toString();
                            } else {
                                despedida = rbtHastaPronto.getText().toString();
                            }
                        }
                    });
                    String edadText=comprobarEdad();
                    if (chkSaludo.isChecked()){
                        saludoFinal.setText("Hola, " + genero + " " + nombre + "\n" + edadText + "\n" + despedida);
                    } else {
                        saludoFinal.setText("Hola, " + genero + " " + nombre + "\n" + edadText);
                    }

                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Problema al saludar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String comprobarEdad() {
        anhoNac = Integer.parseInt(etAnho.getText().toString());
        int anhoActual = Calendar.getInstance().get(Calendar.YEAR);
        if (anhoNac>anhoActual){
            Toast.makeText(this, "El año no puede ser mayor que el actual", Toast.LENGTH_SHORT).show();
        } else {
            edad = anhoActual-anhoNac;
            if (edad<18){
                edadSaludo="Eres menor de edad";
            } else {
                edadSaludo = "Eres mayor de edad";
            }
        }
        return edadSaludo;
    }


    private void extracted() {
        this.etNombre = findViewById(R.id.etNombre);
        this.etAnho = findViewById(R.id.etAnho);
        this.rgGenero = findViewById(R.id.rgGenero);
        this.rgSaludo = findViewById(R.id.rgDespedida);
        this.chkSaludo = findViewById(R.id.chkDespedida);
        this.txtSaludo = findViewById(R.id.txtEscoge);
        this.btnSaludar = findViewById(R.id.btnSaludo);
        this.saludoFinal = findViewById(R.id.saludoFinal);
        this.rbtSr = findViewById(R.id.sr);
        this.rbtSra = findViewById(R.id.sra);
        this.rbtAdios = findViewById(R.id.adios);
        this.rbtHastaPronto = findViewById(R.id.hastaPronto);
    }


}