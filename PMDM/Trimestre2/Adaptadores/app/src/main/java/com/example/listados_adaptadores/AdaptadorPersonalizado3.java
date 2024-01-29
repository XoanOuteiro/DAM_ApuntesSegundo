package com.example.listados_adaptadores;

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

import java.util.ArrayList;

public class AdaptadorPersonalizado3 extends ArrayAdapter {

    private Activity activity;
    private ArrayList<Planeta> arrayPlanetas;
    private int layout_personalizado;

    public AdaptadorPersonalizado3(@NonNull Activity context, int layout_personalizado, ArrayList planetas) {

        super(context, layout_personalizado, planetas);

        this.activity = context;
        this.arrayPlanetas = planetas;
        this.layout_personalizado = layout_personalizado;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //inflamos nuestro layout personalizado
        LayoutInflater inflater = activity.getLayoutInflater();

        View fila = inflater.inflate(layout_personalizado, null);
        //capturamos los ids de queda componente de nuestro layout
        TextView tvPlanetas = fila.findViewById(R.id.tvPlanetas5);
        ImageView imgPlanetas = fila.findViewById(R.id.imgView_5);

        //insertar cada valor (planeta/imagen) en su correspondiente id
        tvPlanetas.setText(this.arrayPlanetas.get(position).getNombre());
        imgPlanetas.setImageResource(this.arrayPlanetas.get(position).getIdFoto());


        return fila;
    }
}