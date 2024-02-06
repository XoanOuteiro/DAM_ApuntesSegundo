package com.example.ejercicioaves;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        registerForContextMenu(lvAves);


        listenerListView();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        String origen = lvAves.getAdapter().getItem(info.position).toString();
        menu.setHeaderTitle(origen);
        inflater.inflate(R.menu.menu_context, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.ctx_opc1:

                createToast("Pulsada Opción 1");
                break;

            case R.id.ctx_opc2:

                createToast("Pulsada Opción 2");
                break;

        }

        return super.onContextItemSelected(item);
    }

    private void createToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void listenerListView() {
        lvAves.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView tvNombre = view.findViewById(R.id.tvNombreAve);
                TextView tvInfo = view.findViewById(R.id.tvInfoAve);

                String nombre = tvNombre.getText().toString();
                String info = tvInfo.getText().toString();

                createToast(nombre + "\n" + info);

            }
        });
    }

    private void finds() {
        lvAves = findViewById(R.id.lvAves);

        arrayIdAves = getResources().obtainTypedArray(R.array.imgAves);

        arrayIdPuntos = getResources().obtainTypedArray(R.array.imgColor);
    }
}