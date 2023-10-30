package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ToggleButton tglBtn;
    private Switch swtchCosas;
    private CheckBox chk;

    private EditText txtNormal;
    private EditText txtNumber;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tglBtn = findViewById(R.id.tglButton);
        tglBtn.setOnClickListener(this);
        swtchCosas = findViewById(R.id.switchCosas);
        swtchCosas.setOnClickListener(this);
        chk = findViewById(R.id.chk);
        chk.setOnClickListener(this);
        txtNormal = findViewById(R.id.texto_normal);
        txtNumber = findViewById(R.id.texto_number);
        txtNormal.setOnClickListener(this);
        txtNumber.setOnClickListener(this);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        if(v.getId() == R.id.tglButton){

            if(tglBtn.isChecked()){

                Toast.makeText(this, "Has activado el toggle button", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Has desactivado el toggle button", Toast.LENGTH_SHORT).show();

            }

        } else if (v.getId() == R.id.switchCosas) {

            if(swtchCosas.isChecked()){

                Toast.makeText(this, "Has activado cosas", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Has desactivado cosas", Toast.LENGTH_SHORT).show();

            }

        } else if (v.getId() == R.id.chk) {

            if(chk.isChecked()){

                Toast.makeText(this, "Has aceptado las condiciones", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Has desaceptado las condiciones", Toast.LENGTH_SHORT).show();

            }

        } else if (v.getId() == R.id.btn) {

            String mensaje;
            mensaje = txtNormal.getText().toString() + "\n" + txtNumber.getText().toString();

            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

        }

    }
}