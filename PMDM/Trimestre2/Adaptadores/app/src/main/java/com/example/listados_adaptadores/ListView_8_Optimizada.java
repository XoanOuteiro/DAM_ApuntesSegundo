package com.example.listados_adaptadores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListView_8_Optimizada extends AppCompatActivity {

    private ListView lv8;

    private TypedArray arrayIdFotosPlanetas;

    private ArrayList<Planeta> arrayPlanetas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view6);

        finds();

        arrayIdFotosPlanetas = getResources().obtainTypedArray(R.array.icons);

        inicializarArrays();


        //crear instancia del adaptador personalizado
        /*AdaptadorPersonalizado2 adaptador = new AdaptadorPersonalizado2(this, R.layout.fila_diferentes_imagenes,
                getResources().getStringArray(R.array.planetas), arrayIdFotosPlanetas);*/

        AdaptadorPersonalizado3 adaptador = new AdaptadorPersonalizado3(this, R.layout.fila_diferentes_imagenes, arrayPlanetas);

        lv8.setAdapter(adaptador);
        registerForContextMenu(lv8);

        listenerListView();

    }

    private void inicializarArrays() {

        String[] nombresPlanetas = getResources().getStringArray(R.array.planetas);
        TypedArray fotosPlanetas = getResources().obtainTypedArray(R.array.icons);

        for (int i = 0; i < nombresPlanetas.length; i++){

            arrayPlanetas.add(new Planeta(nombresPlanetas[i], fotosPlanetas.getResourceId(i,-1)));

        }


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.menu_contextual, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.txt_item1:
                Toast.makeText(this, "Seleccionado item 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.txt_item2:
                Toast.makeText(this, "Seleccionado item 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.txt_item3:
                Toast.makeText(this, "Seleccionado item 3", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onContextItemSelected(item);
    }

    private void listenerListView() {
        lv8.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(ListView_8_Optimizada.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show());
    }

    private void finds() {
        lv8 = findViewById(R.id.lv8);
    }

}