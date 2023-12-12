package com.example.a2023_xoanmanueloterojorge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Activity_MasInfo extends AppCompatActivity {

    private static final int LLAMADA_TELEFONO = 0;
    private RadioButton rbtnOMS;
    private RadioButton rbtnWiki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_info);

        this.rbtnOMS = findViewById(R.id.rbtnOMS);
        this.rbtnWiki = findViewById(R.id.rbtnWiki);

    }

    public void masInfoClicked(View view) {

        if(view.getId() == R.id.btnOk){

            if(rbtnOMS.isChecked()) {

                callOMS();

            }else{

                searchWiki();

            }

        }else if(view.getId() == R.id.btnVolverAtras){

            this.finish();

        }
    }

    private void searchWiki() {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://es.wikipedia.org/wiki/Indice_de_masa_corporal"));

        if (intent.resolveActivity(getPackageManager()) != null){

            startActivity(intent);

        } else {//irresoluble

            Toast.makeText(this, "Esta acción no se puede realizar", Toast.LENGTH_SHORT).show();

        }
    }

    private void callOMS() {
        Intent intent;

        if (Build.VERSION.SDK_INT >= 23) {

            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

                //realizar la llamada
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)915555555"));
                startActivity(intent);

            } else { //solicitamos al SO la gestión del permiso

                //Solicitud de permiso generada por el SO
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONO);

            }

        } else {//En APIs anteriores a la 23

            //Realizar la acción correspondiente
            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)915555555"));
            startActivity(intent);

        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if ((requestCode == LLAMADA_TELEFONO)){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)915555555"));
                startActivity(intent);
                Toast.makeText(this, "El usuario ha concedido los permisos", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "El usuario ha denegado los permisos", Toast.LENGTH_SHORT).show();

            }
        }

    }
}