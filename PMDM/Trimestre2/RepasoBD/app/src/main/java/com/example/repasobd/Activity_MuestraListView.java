package com.example.repasobd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Activity_MuestraListView extends AppCompatActivity {

    private ListView lvMostrar;
    private SQLiteDatabase db;
    private List<String> namesList;
    private List<Integer> codesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_list_view);

        this.lvMostrar = findViewById(R.id.lvMostrar);

        SQLiteOpenHelper dbHelper = new SQLiteHelper(this, "Usuarios",null,1);
        this.db = dbHelper.getWritableDatabase();

        this.namesList = new ArrayList<>();
        this.codesList = new ArrayList<>();

        getAllUsers(namesList,codesList);

        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_list_view, namesList,codesList);
        lvMostrar.setAdapter(adapter);
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


}