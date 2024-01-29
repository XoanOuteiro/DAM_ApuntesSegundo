package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListView_7_Activity extends AppCompatActivity {

    private ArrayList<Planeta> arrPlanetas = new ArrayList<>();
    private ListView lv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view7);

        String[] planetasNombre = getResources().getStringArray(R.array.planetas);
        TypedArray planetasFoto = getResources().obtainTypedArray(R.array.icons);

        for(int i = 0; i < planetasNombre.length; i++){

            this.arrPlanetas.add(new Planeta(planetasNombre[i],planetasFoto.getResourceId(i,-1)));

        }

        AdaptadorPersonalizado3 adapter = new AdaptadorPersonalizado3(this, R.layout.fila_diferentes_imagenes, this.arrPlanetas);
        this.lv7 = findViewById(R.id.lv7);
        this.lv7.setAdapter(adapter);
    }
}