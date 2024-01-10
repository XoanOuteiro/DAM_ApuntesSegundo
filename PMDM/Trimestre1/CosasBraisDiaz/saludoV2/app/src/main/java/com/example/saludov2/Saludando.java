package com.example.saludov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Saludando extends AppCompatActivity {
    private CheckBox chkDespedida;

    private RadioGroup rgDespedida;
    private RadioButton rbtAdios, rbtHastaPronto;
    private Button btnFin;
    private TextView txtMensaje;
    private String despedida= "El usuario no ha contestado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludando);

        Intent intent = getIntent();

        String texto = intent.getStringExtra("mensaje");

        extracted();

        txtMensaje.setText(texto);
        comprobarChk();
        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnFin){


                    Intent intent = new Intent();
                    intent.putExtra("mensaje", despedida);
                    setResult(RESULT_OK, intent);
                    Log.i("ciclo","Ejecutando listener() on Activity 5");
                    finish();
                }
            }
        });
    }

    private void comprobarChk() {
        chkDespedida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkDespedida.isChecked()){
                    rgDespedida.setVisibility(View.VISIBLE);
                    rbtAdios.setChecked(true);
                    despedida = rbtAdios.getText().toString();
                    rgDespedida.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (rbtAdios.isChecked()){
                                despedida = rbtAdios.getText().toString();
                            } else if (rbtHastaPronto.isChecked()) {
                                despedida = rbtHastaPronto.getText().toString();
                            }
                        }
                    });
                } else {
                    rgDespedida.setVisibility(View.GONE);
                }
            }
        });

    }

    private void extracted() {
        txtMensaje = findViewById(R.id.txtMensaje);
        rgDespedida = findViewById(R.id.rgDespedida);
        rbtAdios = findViewById(R.id.rbtAdios);
        rbtHastaPronto = findViewById(R.id.rbtHastaPronto);
        btnFin = findViewById(R.id.btnFin);
        chkDespedida = findViewById(R.id.chkDespedida);
    }


}