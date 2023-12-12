package com.example.a2023_xoanmanueloterojorge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView logoView;
    private LinearLayout optionsLayout;
    private RadioButton rbtnCalcularInformacion;
    private RadioButton rbtnMasInformacion;
    private RadioGroup rbtgMainMenu;
    private Button btnMainAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inits
        this.logoView = findViewById(R.id.logoView);
        this.optionsLayout = findViewById(R.id.optionsLayout);
        this.rbtnCalcularInformacion = findViewById(R.id.rbtnCalcularIMC);
        this.rbtnMasInformacion = findViewById(R.id.rbtnMasInfo);
        this.rbtgMainMenu = findViewById(R.id.rbtgMainMenu);
        this.btnMainAction = findViewById(R.id.btnMainAction);


        //Triggers
        this.logoView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                logoView.setVisibility(View.GONE);
                optionsLayout.setVisibility(View.VISIBLE);

                return false;
            }

        });

        this.rbtgMainMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if (checkedId == R.id.rbtnCalcularIMC) {

                    btnMainAction.setText(R.string.calcular_imc);

                } else {

                    btnMainAction.setText(R.string.mas_informacion);

                }
            }
        });
    }

    public void btnClicked(View view) {

        if (view.getId()==R.id.btnMainAction) {

            if (rbtnCalcularInformacion.isChecked()) {

                Intent intent = new Intent(this, Activity_CalcularIMC.class);
                startActivity(intent);

            } else {

                Intent intent = new Intent(this, Activity_MasInfo.class);
                startActivity(intent);

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, resultCode, Toast.LENGTH_SHORT).show();

        if(resultCode == Activity_Resultado.RESULT_CANCELED){

            this.finish();

        }

    }
}