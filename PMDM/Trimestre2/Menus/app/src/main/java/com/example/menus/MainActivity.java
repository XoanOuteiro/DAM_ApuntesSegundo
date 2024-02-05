package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInf = getMenuInflater();
        menuInf.inflate(R.menu.menu_opciones, menu);

        return super.onCreateOptionsMenu(menu);
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
}