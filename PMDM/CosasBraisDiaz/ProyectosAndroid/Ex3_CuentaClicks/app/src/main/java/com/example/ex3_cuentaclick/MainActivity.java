package com.example.ex3_cuentaclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnPulsa, btnFinalizado;
    private TextView status;

    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inits
        this.status = findViewById(R.id.status);
        this.btnPulsa = findViewById(R.id.btnPulsa);
        this.btnFinalizado = findViewById(R.id.btnFinalizar);

        //Asignación (método 3 (o 2.2) en ex2)
        btnPulsa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                status.setText("");

                num += 1;

            }
        });

        btnFinalizado.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                status.setText("Has pulsado " + num + " vez/ces.");

                num = 0;

            }
        });
    }

}