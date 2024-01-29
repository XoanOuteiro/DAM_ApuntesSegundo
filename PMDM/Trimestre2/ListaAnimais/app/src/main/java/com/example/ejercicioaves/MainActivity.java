package com.example.ejercicioaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicioaves.adaptadores.AdaptadorPersonalizado;

public class MainActivity extends AppCompatActivity {

    private ListView lvAves;

    private TypedArray arrayIdAves;
    private TypedArray arrayIdPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        finds();

        AdaptadorPersonalizado adapter = new AdaptadorPersonalizado(this, R.layout.listview_aves_personalizado,
                getResources().getStringArray(R.array.nombreAves), arrayIdAves, getResources().getStringArray(R.array.infoAves),
                arrayIdPuntos);

        lvAves.setAdapter(adapter);


        listenerListView();
    }

    private void listenerListView() {
        lvAves.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView tvNombre = view.findViewById(R.id.tvNombreAve);
                TextView tvInfo = view.findViewById(R.id.tvInfoAve);

                String nombre = tvNombre.getText().toString();
                String info = tvInfo.getText().toString();

                Toast.makeText(MainActivity.this, nombre + "\n" + info, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void finds() {
        lvAves = findViewById(R.id.lvAves);

        arrayIdAves = getResources().obtainTypedArray(R.array.imgAves);

        arrayIdPuntos = getResources().obtainTypedArray(R.array.imgColor);
    }
}