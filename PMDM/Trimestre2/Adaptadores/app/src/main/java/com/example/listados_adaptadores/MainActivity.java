package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnListados(View view) {

        Intent i = new Intent();
        switch (view.getId()){

            case R.id.btn1_Spinner:
                i.setClass(this, Spinner_1_Activity.class);
                break;

        }

        startActivity(i);
    }
}