package com.example.intentsimplicitos_api22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int LLAMADA_TELEFONICA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onClickBtn(View view){

        Intent intent;
        switch (view.getId()){

            case R.id.btnContactos:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
                break;


            case R.id.btnDial:
                intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
                break;

            case R.id.btnDialConNumero:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+34)091"));
                startActivity(intent);
                break;

            case R.id.btnLlamarNumero:
                /*intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:091"));
                startActivity(intent);
                break;*/

                if (Build.VERSION.SDK_INT >= 23) {
                    if(checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){

                        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:091"));
                        startActivity(intent);

                    }else{

                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONICA);

                    }
                }
                break;

            case R.id.btnURL:

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.blender.org/"));
                startActivity(intent);
                break;


            case R.id.btnGoogleMaps:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:42.25, -8.68"));
                intent.setPackage("com.google.android.apps.map");

                if(intent.resolveActivity(getPackageManager()) != null){

                    startActivity(intent);

                }else{

                    Toast.makeText(this, "No se puede acceder a google maps", Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if((requestCode == LLAMADA_TELEFONICA)){

            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:091"));
                startActivity(intent);
                Toast.makeText(this, "Los permisos fueron concedidos", Toast.LENGTH_SHORT).show();

            }else{

                Toast.makeText(this, "Permisos denegados", Toast.LENGTH_SHORT).show();

            }

        }
    }
}