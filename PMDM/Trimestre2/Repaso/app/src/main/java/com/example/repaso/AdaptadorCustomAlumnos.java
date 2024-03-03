package com.example.repaso;

import android.app.Activity;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class AdaptadorCustomAlumnos extends ArrayAdapter {

    private ArrayList<Alumno> alumnos;
    private Activity activity;
    private int layout_custom;

    public AdaptadorCustomAlumnos(@NonNull Activity activity, int layout_custom, ArrayList<Alumno> alumnos){
        super(activity,layout_custom,alumnos);
        this.activity = activity;
        this.layout_custom = layout_custom;
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater inflater = activity.getLayoutInflater();

        //Inflamos una fila segun nuestro layout
        View fila = inflater.inflate(layout_custom, null);

        //Recuperamos las vistas
        TextView txtNombre = fila.findViewById(R.id.txtNombreAlumno);
        TextView txtCurso = fila.findViewById(R.id.txtCurso);
        TextView txtCiclo = fila.findViewById(R.id.txtCiclo);

        ImageView icon = fila.findViewById(R.id.iconAlumno);

        //Seteamos los valores per fila
        txtNombre.setText(this.alumnos.get(position).getNombre());
        txtCurso.setText(this.alumnos.get(position).getCurso());

        //Comprobación txtCiclo
        if (txtCurso.getText().toString().equals("Ciclo")) {

            txtCiclo.setText(this.alumnos.get(position).getCiclo());

        } else {

            txtCiclo.setVisibility(View.GONE);

        }

        //Comprobación icono
        int idIcono = txtCurso.getText().toString().equals("ESO") ? R.drawable.icono_eso : R.drawable.icono_resto;
        icon.setImageDrawable(ContextCompat.getDrawable(activity,idIcono));

        return fila;

    }

}
