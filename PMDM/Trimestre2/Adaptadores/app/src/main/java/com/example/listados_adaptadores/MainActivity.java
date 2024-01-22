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

            case R.id.btn2_SpinnerAdaptador:
                i.setClass(this, Spinner_2_Activity.class);
                break;

            case R.id.btn3_SpinnerAdaptadorRecurso:
                i.setClass(this, Spinner_3_Activity.class);
                break;

            case R.id.btn4_SpinnerDinamico:
                i.setClass(this,Spinner_4_Activity.class);
                break;

            case R.id.btn5_SpinnerDinamico:
                i.setClass(this, Spinner_5_Activity.class);
                break;

            case R.id.btn1_listView:
                i.setClass(this, ListView_1_Activity.class);
                break;

            case R.id.btn2_listView:
                i.setClass(this, ListView_2_Activity.class);
                break;

            case R.id.btn3_listView:
                i.setClass(this, ListView_3_Activity.class);
                break;

            case R.id.btn4_listView:
                i.setClass(this, ListView_4_Activity.class);
                break;
        }

        startActivity(i);
    }
}