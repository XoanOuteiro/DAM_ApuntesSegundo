package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AuxiliarDB auxiliarDB = new AuxiliarDB(this,"BD",null,1);
        this.db = auxiliarDB.getWritableDatabase();
    }

    public void onClickBtn(View view) {

        switch(view.getId()){

            case R.id.txt:
                Toast.makeText(this, "No no aqui no es eh", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_Guardar:

                try{
                    db.execSQL("Insert into usuarios (codigo, nombre) values (2, 'Juan Rodríaguez')");
                }catch(Exception ex){
                    Toast.makeText(this, "Inserción errónea", Toast.LENGTH_SHORT).show();
                }

                ContentValues registroNuevo = new ContentValues();
                registroNuevo.put("codigo",3);
                registroNuevo.put("nombre","María Gómez");
                long l = db.insert("usuarios",null,registroNuevo);

                if (l==-1){
                    Toast.makeText(this, "Insersción PARAMETRIZADA errónea", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_Modificar:

                try{
                    db.execSQL("Update usuarios set nombre='zzzz' where codigo=1");
                }catch(SQLException e){
                    Toast.makeText(this, "MODIFICACIÓN ERRÓNEA", Toast.LENGTH_SHORT).show();
                }

                ContentValues registroAModificar = new ContentValues();
                registroAModificar.put("nombre","AAAAAAAAAAAA");
                int j = db.update("usuarios",registroAModificar,"codigo=1",null);


                if (j == 0){
                    Toast.makeText(this, "MODIFICACION ERRONEA", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_Eliminar:
                try{
                    db.execSQL("Delete from usuarios where codigo=3");
                }catch (Exception e){
                    Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                int i = db.delete("usuarios","codigo=2",null);
                if(i == 0){
                    Toast.makeText(this, "ELIMINACION PARAMETRIZADA errónea", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_Consulta1:

                break;

            case R.id.btn_Consulta2:

                break;


        }
    }
}