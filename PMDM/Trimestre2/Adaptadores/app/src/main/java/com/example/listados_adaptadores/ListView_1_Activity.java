package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListView_1_Activity extends AppCompatActivity {

    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);

        this.lv1 = findViewById(R.id.lv1);


        this.lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String elementoSeleccionado = lv1.getItemAtPosition(position).toString();

                Toast.makeText(ListView_1_Activity.this, "Seleccionado: " + elementoSeleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}