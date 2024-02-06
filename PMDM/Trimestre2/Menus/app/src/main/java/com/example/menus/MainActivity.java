package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txt = findViewById(R.id.txt);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInf = getMenuInflater();
        menuInf.inflate(R.menu.menu_opciones, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInf = getMenuInflater();
        menuInf.inflate(R.menu.menu_contextual, menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){

            case R.id.opc_item1:
                Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.opc_item2:
                Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.opc_item3:
                Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show();
                break;

        }

        return true;

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.ctx_item1:
                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.ctx_item2:
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onContextItemSelected(item);
    }
}