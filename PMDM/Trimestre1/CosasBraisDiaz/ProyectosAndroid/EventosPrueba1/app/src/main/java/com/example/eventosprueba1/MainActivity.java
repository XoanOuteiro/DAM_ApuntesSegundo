package com.example.eventosprueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asociamos el elemento TextView con la correspondiente vista del layout
        mensaje = findViewById(R.id.statusView);
    }

    public void onClickbtnSi(View view) {
        //Operaciones para gestionar la pulsación del botón
        mensaje.setText(R.string.textbtnSi);
    }

    public void onClickbtnNo(View view) {
        //Operaciones para gestionar la pulsación del botón
        mensaje.setText(R.string.textbtnNo);
    }

    public void onClickbtnAVeces(View view) {
        //Operaciones para gestionar la pulsación del botón
        mensaje.setText(R.string.textbtnAVeces);
    }

    public void onClickbtn(View view) {
        if (view.getId()==R.id.btnSi){
            onClickbtnSi(view);
        }
        else if (view.getId()==R.id.btnNo){
            onClickbtnNo(view);
        }
        else if (view.getId()==R.id.btnAVeces){
            onClickbtnAVeces(view);
        }
    }
}