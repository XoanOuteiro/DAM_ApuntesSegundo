package com.example.ex1_onclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvStatus;
    //private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init
        this.tvStatus = this.findViewById(R.id.statusView);

        /*
        btn1.findViewById(R.id.btnSi);
        btn2.findViewById(R.id.btnNo);
        btn3.findViewById(R.id.btnAveces);
        */

    }

    /*
    public void onClickSi(View view) {
        //operaciones para gestionar la pulsacion del btn Si
        this.tvStatus.setText("Pulsaste el botón Si");
    }

    public void onClickNo(View view) {
        //operaciones para gestionar la pulsacion del btn No
        this.tvStatus.setText("Pulsaste el botón No");
    }

    public void onClickAveces(View view) {
        //operaciones para gestionar la pulsacion del btn A veces
        this.tvStatus.setText("Pulsaste el botón A veces");
    }
    */

    public void onClickBtn(View view){

        if(view.getId()==R.id.btnSi){

            this.tvStatus.setText("Pulsaste el botón Si");

        }else if(view.getId()==R.id.btnNo){

            this.tvStatus.setText("Pulsaste el botón No");

        }else if(view.getId()==R.id.btnAveces){

            this.tvStatus.setText("Pulsaste el botón A veces");

        }


    /*
        switch (view.getId()){

            case R.id.btnSi:

                this.tvStatus.setText("Pulsaste el botón Si");
                break;

            case R.id.btnNo:

                this.tvStatus.setText("Pulsaste el botón No");
                break;

            case R.id.btnAveces:

                this.tvStatus.setText("Pulsaste el botón A veces");
                break;

        }
    */
    }
}