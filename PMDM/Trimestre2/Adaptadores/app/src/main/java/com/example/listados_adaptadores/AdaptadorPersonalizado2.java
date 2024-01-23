package com.example.listados_adaptadores;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorPersonalizado2 extends ArrayAdapter {

    private Activity activity;
    private String[] arrayPlanetas;
    private TypedArray arrayIdFotos;
    private int layout_personalizado;

    public AdaptadorPersonalizado2(@NonNull Activity context, int layout_personalizado, String[] arrayPlanetas, TypedArray arrayIdFotos) {

        super(context, layout_personalizado, arrayPlanetas);

        this.activity = context;
        this.arrayPlanetas = arrayPlanetas;
        this.arrayIdFotos = arrayIdFotos;
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
        tvPlanetas.setText(arrayPlanetas[position]);
        imgPlanetas.setImageDrawable(arrayIdFotos.getDrawable(position));


        return fila;
    }
}