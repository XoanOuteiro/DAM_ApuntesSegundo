package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView_2_Activity extends AppCompatActivity {

    private ListView lv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        this.lv2 = findViewById(R.id.lv2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planetas, android.R.layout.simple_list_item_1);

        lv2.setAdapter(adapter);

        listenerListView();
    }

    private void listenerListView(){

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListView_2_Activity.this, "Seleccionado: " + lv2.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}