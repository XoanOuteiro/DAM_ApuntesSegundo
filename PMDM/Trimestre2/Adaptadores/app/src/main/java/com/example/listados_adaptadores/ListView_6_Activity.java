package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

public class ListView_6_Activity extends AppCompatActivity {

    private ListView lv6;
    private TypedArray arrayIdFotosPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view6);

        this.lv6 = findViewById(R.id.lv6);

        TypedArray drawables = getResources().obtainTypedArray(R.array.icons);

        //Crear instancia del adaptador personalizado
        AdaptadorPersonalizado2 adapter = new AdaptadorPersonalizado2(this, R.layout.fila_diferentes_imagenes, getResources().getStringArray(R.array.planetas), drawables);

        lv6.setAdapter(adapter);
    }
}