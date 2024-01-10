package com.example.a2023_xoanmanueloterojorge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_Resultado extends AppCompatActivity {

    private TextView imcResult;
    private TextView imcResultIMG;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        this.imcResult = findViewById(R.id.imcResult);
        this.imcResultIMG = findViewById(R.id.imcResultIMG);
        this.show = findViewById(R.id.showResText);

        Intent gottenIntent = getIntent();
        float resultado = gottenIntent.getFloatExtra("res",0.00f);

        //String showableNum = String.format(".%2d",Float.toString(resultado));
        //No recuerdo como se hacia el formato

        this.imcResult.setText("IMC = " + resultado);

        if(resultado >= 30){

            this.imcResultIMG.setBackground(getDrawable(R.drawable.imc_obesidad));
            this.show.setText("OBESIDAD");

        }else if(resultado >= 25){

            this.imcResultIMG.setBackground(getDrawable(R.drawable.imc_sobrepeso));
            this.show.setText("SOBREPESO");

        }else{

            this.imcResultIMG.setBackground(getDrawable(R.drawable.imc_correcto));
            this.show.setText("NORMAL");

        }


    }
}