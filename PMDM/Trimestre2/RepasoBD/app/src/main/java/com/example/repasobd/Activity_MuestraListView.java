package com.example.repasobd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;

public class Activity_MuestraListView extends AppCompatActivity {

    private ListView lvMostrar;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_list_view);

        this.lvMostrar = findViewById(R.id.lvMostrar);

        SQLiteOpenHelper dbHelper = new SQLiteHelper(this, "Usuarios",null,1);
        this.db = dbHelper.getWritableDatabase();
    }
}