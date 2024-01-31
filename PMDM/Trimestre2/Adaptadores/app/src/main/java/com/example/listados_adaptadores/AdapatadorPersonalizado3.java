package com.example.listados_adaptadores;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapatadorPersonalizado3 extends ArrayAdapter {

    private Activity activity;
    private ArrayList<Planeta> planetas;
    private int layout_personalizado;


    public AdapatadorPersonalizado3(@NonNull Activity activity, int layout_personalizado, ArrayList planetas) {
        super(activity, layout_personalizado);
        this.activity = activity;
        this.layout_personalizado = layout_personalizado;
        this.planetas = planetas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View fila = convertView
        ViewHolder holder;

        if(fila == null){

            LayoutInflater inflater = activity.getLayoutInflater();
            fila = inflater.inflate(layout_personalizado, null);

            holder = new ViewHolder;
            holder.tvPlanetas = fila.findViewById(R.id.tvPlanetas5);
            holder.imgPlanetas = fila.findViewById(R.id.imgView_5);

            fila.setTag(holder);

        }else{

            holder = (ViewHolder) fila.getTag();

        }

        holder.tvPlanetas.setText(planetas.get(position).getNombre());
        holder.imgPlanetas.setImageResource(planetas.get(position).getIdFoto());

        return fila;

    }
    static class ViewHolder{

        TextView tvPlanetas;
        ImageView imgPlanetas;

    }

}


