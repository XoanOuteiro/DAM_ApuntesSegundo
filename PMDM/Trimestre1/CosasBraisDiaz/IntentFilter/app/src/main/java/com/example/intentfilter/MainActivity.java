package com.example.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUrl;
    private Button btnWeb, btnWebImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extracted();
    }

    private void extracted() {
        etUrl = findViewById(R.id.etUrl);
        btnWeb = findViewById(R.id.btnWeb);
        btnWebImpl = findViewById(R.id.btnWebImpl);
    }


    public void onClickbtn(View view) {

        String url = etUrl.getText().toString();

        if (url.isEmpty()){
            Toast.makeText(this, "El campo URL no debe de estar vacío", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = null;

            if (view.getId() == R.id.btnWeb){

                intent = new Intent(this, Navegador.class);
                intent.putExtra("enlace", url);
                startActivity(intent);

            } else if (view.getId() == R.id.btnWebImpl) {

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            }
        }


    }
}