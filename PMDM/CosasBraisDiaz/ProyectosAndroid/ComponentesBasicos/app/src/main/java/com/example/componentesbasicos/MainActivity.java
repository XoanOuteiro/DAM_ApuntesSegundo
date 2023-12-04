package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ToggleButton tglBtn;
    private Switch switch1;
    private Switch switch2;
    private CheckBox chkAcept;
    private EditText text;
    private EditText number;
    private Button btn_estandar;
    private RadioGroup rg1;
    private RadioButton rbSi, rbNo, rbAVeces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    private void inicializar() {
        this.tglBtn = findViewById(R.id.tglBtn);
        tglBtn.setOnClickListener(this);

        this.switch1 = findViewById(R.id.wifi);
        this.switch2 = findViewById(R.id.datos);
        switch1.setOnClickListener(this);
        switch2.setOnClickListener(this);

        this.chkAcept = findViewById(R.id.chk_acepto);
        chkAcept.setOnClickListener(this);

        this.text = findViewById(R.id.et_texto_normal);
        this.number = findViewById(R.id.number);

        this.btn_estandar = findViewById(R.id.btn_estandar);
        btn_estandar.setOnClickListener(this);

        //Escuchador onCheckedChanged
        chkAcept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "Cambio de estado: Acepto", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Cambio de estado: No Acepto", Toast.LENGTH_SHORT).show();
                }
            }

        });

        this.rg1 = findViewById(R.id.rg1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rbtnSi){
                    Toast.makeText(MainActivity.this, "Has pulsado Si", Toast.LENGTH_SHORT).show();
                } else if (checkedId==R.id.rbtnNo){
                    Toast.makeText(MainActivity.this, "Has pulsado No", Toast.LENGTH_SHORT).show();
                } else if (checkedId==R.id.rbtnAveces) {
                    Toast.makeText(MainActivity.this, "Has pulsado A Veces", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.tglBtn){    //Toggle Button

            if (tglBtn.isChecked()){
                Toast.makeText(this, "Has activado el Toggle Button", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Has desactivado el Toggle Button", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId()==R.id.wifi){   //Switch
            if (switch1.isChecked()){
                Toast.makeText(this, "Has activado el wifi", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Has desactivado el wifi", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId()==R.id.datos){  //Switch
            if (switch2.isChecked()){
                Toast.makeText(this, "Has activado los datos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Has desactivado los datos", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId()==R.id.chk_acepto){ //CheckBox
            if (chkAcept.isChecked()){
                Toast.makeText(this, "Has aceptado las condiciones", Toast.LENGTH_LONG).show();
            } else{
                Toast.makeText(this, "No has aceptado las condiciones", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId()== R.id.btn_estandar){  //Button
            //Capturar entradas de cada EditText y construir un mensaje
            String mensaje;
            mensaje = text.getText().toString() + "\n" + number.getText().toString();
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
            //Visualizar el mensaje
        }
    }
}