package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AuxiliarDB auxiliarDB = new AuxiliarDB(this,"BD",null,1);
        SQLiteDatabase db = auxiliarDB.getWritableDatabase();
    }

    public void onClickBtn(View view) {

        switch(view.getId()){

            case R.id.txt:
                Toast.makeText(this, "No no aqui no es eh", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_Guardar:

                break;

            case R.id.btn_Reset:

                break;

            case R.id.btn_Eliminar:

                break;

            case R.id.btn_Consulta1:

                break;

            case R.id.btn_Consulta2:

                break;


        }
    }
}