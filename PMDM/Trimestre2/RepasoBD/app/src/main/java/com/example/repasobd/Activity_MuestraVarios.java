package com.example.repasobd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity_MuestraVarios extends AppCompatActivity {

    private SQLiteDatabase db;
    private TextView txtVarios;

    private List<String> namesList;
    private List<Integer> codesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_varios);

        txtVarios = findViewById(R.id.txtVarios);

        SQLiteOpenHelper dbHelper = new SQLiteHelper(this, "Usuarios",null,1);
        this.db = dbHelper.getWritableDatabase();

        this.namesList = new ArrayList<>();
        this.codesList = new ArrayList<>();

        this.getAllUsers(this.namesList,this.codesList);
        String text = this.concatenate();
        this.txtVarios.setText(text);
    }

    private void getAllUsers(List<String> namesList, List<Integer> codesList) {
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int codigoIndex = cursor.getColumnIndex("codigo");
                int nombreIndex = cursor.getColumnIndex("nombre");

                int codigo = cursor.getInt(codigoIndex);
                String nombre = cursor.getString(nombreIndex);

                if (codigo >= -1) {
                    codesList.add(codigo);
                    namesList.add(nombre);
                }
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }
    }

    private String concatenate(){

        String returnable = "";

        for(int i = 0; i<= this.namesList.size()-1;i++){

            returnable = returnable + this.codesList.get(i) + " --> " + this.namesList.get(i) + "\n";

        }

        return returnable;

    }

}