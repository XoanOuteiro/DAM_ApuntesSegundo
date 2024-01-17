package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ListView_3_Activity extends AppCompatActivity {


    private EditText txt;
    private ListView lv3;
    private Button btn;
    private ArrayList<String> contents = new ArrayList<>();
    private ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);

        this.txt = findViewById(R.id.txtLV3);
        this.lv3 = findViewById(R.id.lv3);
        this.btn = findViewById(R.id.btnLV3);

        Collections.addAll(contents, getResources().getStringArray(R.array.planetas));
        this.adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.contents);
        this.lv3.setAdapter(adaptador);

        listenerListView();
    }

    public void onClickBtnInsertarLv3(View view) {

        if (txt.getText().toString().trim()==""){

            Toast.makeText(this, "No se pueden insertar\nvalores vacíos", Toast.LENGTH_SHORT).show();

        }else{

            this.contents.add(txt.getText().toString());
            this.adaptador.notifyDataSetChanged();

        }

    }

    private void listenerListView(){

        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListView_3_Activity.this, "Seleccionado: " + lv3.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}