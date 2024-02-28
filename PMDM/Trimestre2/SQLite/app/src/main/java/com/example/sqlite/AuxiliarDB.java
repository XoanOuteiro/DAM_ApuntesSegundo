package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;

public class AuxiliarDB extends SQLiteOpenHelper {

    private String strCreateTable = "Create table usuarios(codigo int primary key, nombre varchar(25))";

    private Context ctx;

    public AuxiliarDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(strCreateTable);
        try {
            db.execSQL("INSERT INTO usuarios (codigo, nombre) values (1,'perez perez')");
        } catch (Exception ex) {
            Toast.makeText(ctx, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
