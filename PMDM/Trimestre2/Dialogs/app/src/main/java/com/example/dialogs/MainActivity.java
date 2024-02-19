package com.example.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnDia_1;
    private Button btnDia_2;
    private Button btnDia_3;
    private Button btnDia_4;
    private Button btnDia_5;
    private Button btnDia_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.finds();
    }

    private void finds() {

        this.btnDia_1 = findViewById(R.id.btnDia_1);
        this.btnDia_2 = findViewById(R.id.btnDia_2);
        this.btnDia_3 = findViewById(R.id.btnDia_3);
        this.btnDia_4 = findViewById(R.id.btnDia_4);
        this.btnDia_5 = findViewById(R.id.btnDia_5);
        this.btnDia_6 = findViewById(R.id.btnDia_6);

    }

    public void onClickBtnDia(View view) {

        switch (view.getId()) {

            case R.id.btnDia_1:

                dialogo_mensaje();

                break;

            case R.id.btnDia_2:

                dialogo_ventana_1boton();

                break;

            case R.id.btnDia_3:

                dialogo_ventana_2botones();

                break;

            case R.id.btnDia_4:

                dialogo_ventana_3botones();

                break;

            case R.id.btnDia_5:

                dialogo_lista_simple();

                break;

            case R.id.btnDia_6:

                dialogo_checkbox();

                break;

        }

    }

    private void dialogo_mensaje() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setMessage("Esto es un MENSAJE DE AVISO DEL BLAblaBLA")
                .setTitle("Alerta ERROR Maligno!!")
                .show();
    }

    private void dialogo_ventana_1boton() {

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setMessage("Esto es un mensaje de ALERTA")
                .setTitle("ALERTA MALIGNA BOTON")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        dialog.cancel();

                    }
                });
        ventana.show();
    }

    private void dialogo_ventana_2botones() {

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setMessage("Esto es un mensaje de ALERTA")
                .setTitle("ALERTA MALIGNA BOTON")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        Toast.makeText(MainActivity.this, "Pulsaste OK!", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        Toast.makeText(MainActivity.this, "Pulsaste Cancel...", Toast.LENGTH_SHORT).show();

                    }
                });
        ventana.show();

    }

    private void dialogo_ventana_3botones() {

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setMessage("Esto es un mensaje de ALERTA")
                .setTitle("ALERTA MALIGNA BOTON")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        Toast.makeText(MainActivity.this, "Pulsaste OK!", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        Toast.makeText(MainActivity.this, "Pulsaste Cancel...", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNeutralButton("Acerca de", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, "Pulsaste Acerca de :)", Toast.LENGTH_SHORT).show();

                    }
                });
        ventana.show();
    }

    private void dialogo_lista_simple(){

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                ventana.setIcon(R.drawable.jupiter)
                .setCancelable(false)
                .setItems(R.array.colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, getResources().getStringArray(R.array.colores)[which], Toast.LENGTH_SHORT).show();

                    }
                });
        ventana.show();

    }

    private void dialogo_checkbox(){




    }
}