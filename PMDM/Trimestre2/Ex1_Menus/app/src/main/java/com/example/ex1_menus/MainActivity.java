package com.example.ex1_menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity_Auxiliar {

    private TextView txt;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txt = findViewById(R.id.txt);
        registerForContextMenu(txt);

        this.img = findViewById(R.id.img);
        registerForContextMenu(img);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inftxt = getMenuInflater();

        if(v.getId() == txt.getId()){

            inftxt.inflate(R.menu.menu_contextual_texto, menu);

        }else{

            inftxt.inflate(R.menu.menu_contextual_imagen, menu);

        }

    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_opciones, menu);

        return super.onCreateOptionsMenu(menu);
    }*/

    public void btnClicked(View view) {

        Intent it = new Intent(this,Activity_2.class);
        startActivity(it);

    }
}