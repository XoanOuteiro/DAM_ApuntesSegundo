package com.example.sharedpreferences_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View vColor;
    private int[] colorSwitchable = {R.color.ROJO, R.color.VERDE, R.color.AMARILLO, R.color.AZUL};

    private SharedPreferences preferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.vColor = findViewById(R.id.viewColor);


        this.preferencia = PreferenceManager.getDefaultSharedPreferences(this);
        setColor();

    }

    public void onClickBtn(View view) {

        switch(view.getId()){

            case R.id.btnInvocarSeleccion:


                break;


            case R.id.btnReset:


                break;

        }
    }

    private void dialogo_lista_simple() {

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setCancelable(false)
                .setItems(R.array.colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    int selected = colorSwitchable[which];

                    SharedPreferences.Editor editorPreferencia = preferencia.edit();
                    editorPreferencia.putInt("color",selected);
                    editorPreferencia.apply();


                    }
                });
        ventana.show();

        setColor();

    }

    private void setColor(){

        int selected = this.preferencia.getInt("color",0);
        this.vColor.setBackground(getDrawable(selected));

    }
}