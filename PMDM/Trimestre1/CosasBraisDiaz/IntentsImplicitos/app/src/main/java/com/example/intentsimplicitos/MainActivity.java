package com.example.intentsimplicitos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int LLAMADA_TELEFONO = 0;
    private static final int LLAMADA_TELEFONO2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickBtn(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btn_listaContactos:
                //generar la acción del intent implicto: ACTION_VIEW
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
                break;
            case R.id.btn_dial:
                //generar la acción del intent implícito: ACTION_DIAL
                intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
                break;
            case R.id.btn_dial_numero_premarcado:
                //generar la acción del intent implícito: ACTION_DIAL
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+34)986111111"));
                startActivity(intent);
                break;
            case R.id.btn_llamar_numero_premarcado:
                //generar la acción del intent implícito: ACTION_CALL

                //averiguar si tiene permiso:
                if (Build.VERSION.SDK_INT >= 23){

                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){

                        //realizar la llamada
                        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)685749875"));
                        startActivity(intent);

                    } else { //solicitamos al SO la gestión del permiso

                        //Solicitud de permiso generada por el SO
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONO);

                    }

                } else {//En APIs anteriores a la 23

                    //Realizar la acción correspondiente
                    intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)685749875"));
                    startActivity(intent);

                }
                break;

            case R.id.btn_llamar_numero_premarcado2:

                //Versión con una librería de compatibilidad como es AppActivityCompact

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){

                    //realizar la llamada
                    intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)685749875"));
                    startActivity(intent);

                } else { //solicitamos al SO la gestión del permiso

                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONO2);

                }

                break;

            case R.id.btn_carga_URL:

                //Carga una URL

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.xunta.gal"));

                if (intent.resolveActivity(getPackageManager()) != null){

                    startActivity(intent);

                } else {//irresoluble

                    Toast.makeText(this, "Esta acción no se puede realizar", Toast.LENGTH_SHORT).show();

                }

                break;

            case R.id.btn_maps:
                //Abrir el maps

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:42.25,-8.68"));
                intent.setPackage("com.google.android.apps.map");

                if (intent.resolveActivity(getPackageManager()) != null){

                    startActivity(intent);

                } else {//irresoluble

                    Toast.makeText(this, "Esta acción no se puede realizar", Toast.LENGTH_SHORT).show();

                }

                break;

            default:
                Toast.makeText(this, "Error al ejecutar", Toast.LENGTH_SHORT).show();
        }
    }


    //Método en donde recibimos la respuesta que ha dado el usuario
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if ((requestCode == LLAMADA_TELEFONO)){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //acciones correspondientes al permiso concedido
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)685749875"));
                startActivity(intent);
                Toast.makeText(this, "El usuario ha concedido los permisos", Toast.LENGTH_SHORT).show();
            } else {
                //acciones correspondientes al permiso NO concedido
                Toast.makeText(this, "El usuario ha denegado los permisos", Toast.LENGTH_SHORT).show();
            }
        }

    }
}