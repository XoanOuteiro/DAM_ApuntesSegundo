package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

public class ListView_5_Activity extends AppCompatActivity {

    private ListView lv5;
    private int[] arrayIdFotosPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view5);

        this.lv5 = findViewById(R.id.lv5);

        //Auxiliar
        this.arrayIdFotosPlanetas = new int[]{R.drawable.mercurio, R.drawable.venus, R.drawable.tierra,
                                    R.drawable.marte, R.drawable.jupiter, R.drawable.saturno, R.drawable.urano, R.drawable.neptuno};

        //Crear instancia del adaptador personalizado
        AdaptadorPersonalizado1 adapter = new AdaptadorPersonalizado1(this, R.layout.fila_diferentes_imagenes, getResources().getStringArray(R.array.planetas), this.arrayIdFotosPlanetas);

        lv5.setAdapter(adapter);
    }
}