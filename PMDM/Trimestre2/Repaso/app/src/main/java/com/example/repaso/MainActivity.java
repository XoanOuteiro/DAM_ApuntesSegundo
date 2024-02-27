package com.example.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*

        ---Botones

     */
    private Button btnGuardar;

    /*

        ---Spinners

     */
    private Spinner spCurso;
    private Spinner spCiclo;

    /*

        ---Linear Layouts

     */
    private LinearLayout llspCiclo;

    /*

        ---Edit Text

     */
    private EditText txtAlumno;

    /*

        ---List View

     */
    private ListView lvAlumnos;

    /*

        ---Atributos de intercambio global

     */
    private String cursoSeleccionado;
    private String cicloSeleccionado;


    /*

        ---Atributos dinamicos de lista

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fetchElements();

        // Cambiar ll de spCiclo a no visible hasta que curso == ciclo
        this.llspCiclo.setVisibility(View.GONE);

        listenerSpCurso();

    }

    private void listenerSpCurso() {
        this.spCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                cursoSeleccionado = getResources().getStringArray(R.array.CURSOS)[position];

                //Comprobar si se ha seleccionado o no Ciclo para mostrarlo o ocultarlo
                comprobarSeleccionCurso();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void listenerSpCiclo(){
        this.spCiclo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                cicloSeleccionado = getResources().getStringArray(R.array.CICLOS)[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void fetchElements(){

        this.btnGuardar = findViewById(R.id.btnGuardar);
        this.spCurso = findViewById(R.id.spCurso);
        this.spCiclo = findViewById(R.id.spCiclo);
        this.llspCiclo = findViewById(R.id.llSpCiclo);
        this.txtAlumno = findViewById(R.id.txtAlumno);
        this.lvAlumnos = findViewById(R.id.lvAlumnos);

    }

    private void comprobarSeleccionCurso(){

        if (cursoSeleccionado.equals("Ciclo")){

            this.llspCiclo.setVisibility(View.VISIBLE);

        }else{

            this.llspCiclo.setVisibility(View.GONE);

        }


    }


}