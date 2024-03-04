package com.example.repasobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickBtn(View view) {

        Intent intent = null;

        switch(view.getId()){

            case R.id.btnInsertar:
                intent = new Intent(this, Activity_Insertar.class);
                break;


            case R.id.btnBorrar:
                intent = new Intent(this, Activity_Borrar.class);
                break;


            case R.id.btnModificar:
                intent = new Intent(this, Activity_Modificar.class);
                break;


            case R.id.btnMuestrauno:
                intent = new Intent(this, Activity_MuestraUno.class);
                break;


            case R.id.btnMuestravarios:
                intent = new Intent(this, Activity_MuestraVarios.class);
                break;


            case R.id.btnMuestraLista:
                intent = new Intent(this, Activity_MuestraListView.class);
                break;
        }

        startActivity(intent);

    }
}