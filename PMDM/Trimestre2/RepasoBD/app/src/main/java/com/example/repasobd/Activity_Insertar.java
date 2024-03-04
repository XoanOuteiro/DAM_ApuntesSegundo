package com.example.repasobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Insertar extends AppCompatActivity {

    private SQLiteDatabase db;
    private EditText txtCodigo;
    private EditText txtNombre;
    private Button btnInsertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        SQLiteOpenHelper dbHelper = new SQLiteHelper(this, "Usuarios",null,1);
        this.db = dbHelper.getWritableDatabase();

        this.txtCodigo = findViewById(R.id.txtCodigo);
        this.txtNombre = findViewById(R.id.txtNombre);
        this.btnInsertar = findViewById(R.id.btnInsertar);

        this.btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String nombre = txtNombre.getText().toString();
                    int codigo = Integer.parseInt(txtCodigo.getText().toString());

                    ContentValues registroNuevo = new ContentValues();
                    registroNuevo.put("codigo", codigo);
                    registroNuevo.put("nombre", nombre);
                    long l = db.insert("Usuarios", null, registroNuevo);

                    if (l == -1) {

                        Toast.makeText(Activity_Insertar.this, "Error al insertar", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(Activity_Insertar.this, "Inserción correcta", Toast.LENGTH_SHORT).show();

                    }

                }catch(Exception e){

                    Toast.makeText(Activity_Insertar.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


}