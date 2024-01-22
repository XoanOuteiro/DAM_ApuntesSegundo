package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView_4_Activity extends AppCompatActivity {

    private ListView lv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view4);

        this.lv4 = findViewById(R.id.lv4);


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.fila_simple, R.id.txtFila,getResources().getStringArray(R.array.planetas));

        lv4.setAdapter(adapter);
    }
}