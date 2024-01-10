package com.example.a2023_xoanmanueloterojorge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Activity_CalcularIMC extends AppCompatActivity {

    private EditText txtfMetros;
    private EditText txtfKg;
    private Button btnCalcular;
    private Button btnFinApp;

    private ToggleButton tBtnUnits;

    private boolean sistemaIngles = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);

        //inits
        this.txtfKg = findViewById(R.id.txtfKg);
        this.txtfMetros = findViewById(R.id.txtfMetros);
        this.btnCalcular = findViewById(R.id.btnCalcular);
        this.btnFinApp = findViewById(R.id.btnFinApp);
        this.tBtnUnits = findViewById(R.id.unitBtn);

    }

    public void calcBtnClicked(View view) {

        if (view.getId()==R.id.btnCalcular){

            try {

                if(!sistemaIngles) {

                    float metros = Float.parseFloat(txtfMetros.getText().toString());
                    float kg = Float.parseFloat(txtfKg.getText().toString());

                    float resultado = (float) (kg / Math.pow(metros, 2));

                    Intent intent = new Intent(this, Activity_Resultado.class);
                    intent.putExtra("res", resultado);
                    startActivity(intent);

                }else{

                    float metros = Float.parseFloat(txtfMetros.getText().toString());
                    float kg = Float.parseFloat(txtfKg.getText().toString());

                    float resultado = (float) (kg / Math.pow(metros, 2)) * 703; //Factor conversión

                    Intent intent = new Intent(this, Activity_Resultado.class);
                    intent.putExtra("res", resultado);
                    startActivity(intent);

                }

            }catch(Exception e){

                Toast.makeText(this, "No se pudo realizar la operación \nya que faltan datos", Toast.LENGTH_SHORT).show();

            }


        }else if(view.getId() == R.id.btnFinApp){

            this.finish();

        }else if (view.getId() == R.id.unitBtn){

            if(tBtnUnits.isChecked()){

                this.sistemaIngles = true;
                this.txtfMetros.setHint("Pulgadas");
                this.txtfKg.setHint("Libras");

            }else{

                this.sistemaIngles = false;
                this.txtfMetros.setHint("Metros");
                this.txtfKg.setHint("Kg");

            }

        }

    }
}