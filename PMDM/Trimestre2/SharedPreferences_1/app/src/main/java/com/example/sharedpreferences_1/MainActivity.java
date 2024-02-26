package com.example.sharedpreferences_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnGuardarPref;
    private Button btnCargarPref;
    private EditText txtNombre;
    private EditText txtEmail;

    private SharedPreferences preferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnCargarPref = findViewById(R.id.cargar_pref);
        this.btnGuardarPref = findViewById(R.id.guardar_pref);
        this.txtNombre = findViewById(R.id.txtNombre);
        this.txtEmail = findViewById(R.id.txtEmail);

        this.preferencia = PreferenceManager.getDefaultSharedPreferences(this);

    }

    public void onClickBtn(View view) {

        switch(view.getId()){

            case R.id.guardar_pref:

                SharedPreferences.Editor editorPreferencia = this.preferencia.edit();
                editorPreferencia.putString("nombre",this.txtNombre.getText().toString());
                editorPreferencia.putString("email",this.txtEmail.getText().toString());
                editorPreferencia.apply();
                Toast.makeText(this, "Los datos se han guardado.", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cargar_pref:

                String nombre = this.preferencia.getString("nombre","Valor Defectivo Nombre...");
                String email = this.preferencia.getString("email", "Valor Defectivo Email...");
                Toast.makeText(this, nombre + "\n" + email, Toast.LENGTH_SHORT).show();

                break;

        }
    }
}