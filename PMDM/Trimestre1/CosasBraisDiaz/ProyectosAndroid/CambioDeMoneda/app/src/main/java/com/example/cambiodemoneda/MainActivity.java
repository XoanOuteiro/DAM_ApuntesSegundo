package com.example.cambiodemoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup rgCambio;
    private RadioButton rbtAPtas, rbtAEur;
    private TextView txtResultado;
    private EditText etValor;
    private Button btnCambio;
    private float valor;
    private float resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extracted();
    }

    private void extracted() {
        this.rgCambio = findViewById(R.id.rgCambio);
        this.rbtAPtas = findViewById(R.id.rbtAPt);
        this.rbtAEur = findViewById(R.id.rbtAEur);
        this.etValor = findViewById(R.id.valor);
        this.txtResultado = findViewById(R.id.resultado);
        this.btnCambio = findViewById(R.id.btnCambio);
        btnCambio.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (etValor.getText().toString().equals("")){
            Toast.makeText(this, "Debes teclear un valor", Toast.LENGTH_SHORT).show();
        } else {
            try {
                if (rbtAPtas.isChecked()) {
                    valor = Float.parseFloat(etValor.getText().toString());
                    resultado = (float) (valor / 166.38);
                    txtResultado.setText(etValor.getText().toString() + " pesetas son " + resultado + " euros.");
                } else {
                    valor = Float.parseFloat(etValor.getText().toString());
                    resultado = (float) (valor * 166.38);
                    txtResultado.setText(etValor.getText().toString() + " euros son " + resultado + " pesetas.");
                }
            }
            catch (NumberFormatException e){
                Toast.makeText(this, "El valor introducido debe ser numérico", Toast.LENGTH_SHORT).show();
            }

        }

    }
}