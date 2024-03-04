package com.example.repaso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

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
    private AdaptadorCustomAlumnos adaptador;
    private ArrayList<Alumno> alumnos;
    private Alumno selectedAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fetchElements();

        // Cambiar ll de spCiclo a no visible hasta que curso == ciclo
        this.llspCiclo.setVisibility(View.GONE);

        //Asociar adaptador personalizado
        this.alumnos = new ArrayList<>();
        this.adaptador = new AdaptadorCustomAlumnos(this,
                R.layout.listview_custom_alumnos,
                alumnos);
        this.lvAlumnos.setAdapter(adaptador);
        registerForContextMenu(this.lvAlumnos);

        listenerSpCurso();
        listenerSpCiclo();
        listenerBtnGuardar();
        listenerItemsListView();

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch(v.getId()){

            case R.id.lvAlumnos:

                MenuInflater inflater = getMenuInflater();

                String nombre = "";

                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;

                try{

                    this.selectedAlumno = (Alumno) lvAlumnos.getAdapter().getItem(info.position);
                    nombre = this.selectedAlumno.getNombre();

                }catch(Exception ex){
                    Toast.makeText(this, "Error: " + ex, Toast.LENGTH_SHORT).show();
                }

                menu.setHeaderTitle(nombre);
                inflater.inflate(R.menu.custom_menu, menu);

                break;


        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        
        switch(item.getItemId()){
            
            case R.id.ctx_Eliminar:
                this.alumnos.remove(this.selectedAlumno);
                this.adaptador.notifyDataSetChanged();
                break;
                
            case R.id.ctx_Otras:
                Toast.makeText(this, "Pulsado otras ...", Toast.LENGTH_SHORT).show();
                break;
            
        }
        
        return super.onContextItemSelected(item);
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

    private void listenerItemsListView(){
        this.lvAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nombre = alumnos.get(position).getNombre();
                String curso = alumnos.get(position).getCurso();
                String ciclo = alumnos.get(position).getCiclo();

                if(ciclo == null) {
                    Toast.makeText(MainActivity.this, "Alumno: " + nombre + "\nCurso: " + curso, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Alumno: " + nombre + "\nCurso: " + curso + "\nCiclo: " + ciclo, Toast.LENGTH_SHORT).show();
                }

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

    private void listenerBtnGuardar(){
        this.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = txtAlumno.getText().toString();
                //cursoSeleccionado
                //cicloSeleccionado

                Alumno alumno;

                if(cicloSeleccionado == null){
                    alumno = new Alumno(nombre,cursoSeleccionado);

                }else{
                    alumno = new Alumno(nombre,cursoSeleccionado,cicloSeleccionado);

                }

                alumnos.add(alumno);
                //toastAlumnos();
                adaptador.notifyDataSetChanged();
                txtAlumno.setText("");
                //Toast.makeText(MainActivity.this, "Creado alumno " + nombre, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void toastAlumnos(){
        for (Alumno al : this.alumnos){
            Toast.makeText(this, al.getNombre() + " " + al.getCurso() + " " + al.getCiclo(), Toast.LENGTH_SHORT).show();
        }
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

        //Reiniciar ciclo seleccionado
        this.cicloSeleccionado = null;

        if (cursoSeleccionado.equals("Ciclo")){

            this.llspCiclo.setVisibility(View.VISIBLE);

        }else{

            this.llspCiclo.setVisibility(View.GONE);

        }


    }


}