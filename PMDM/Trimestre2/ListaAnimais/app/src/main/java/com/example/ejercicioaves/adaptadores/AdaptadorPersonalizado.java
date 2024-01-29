package com.example.ejercicioaves.adaptadores;

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

import com.example.ejercicioaves.R;

public class AdaptadorPersonalizado  extends ArrayAdapter {

    private Activity activity;
    private String[] nombreAves;
    private String[] infoAves;
    private TypedArray arrayIdAves;
    private TypedArray arrayIdPuntos;
    private int layout_personalizado;

    private TextView nombreAve;
    private View view;
    public AdaptadorPersonalizado(@NonNull Activity activity, int layout_personalizado,  String[] nombreAves, TypedArray arrayIdAves, String[] infoAves, TypedArray arrayIdPuntos) {
        super(activity, layout_personalizado, nombreAves);

        this.activity = activity;
        this.nombreAves = nombreAves;
        this.infoAves = infoAves;
        this.arrayIdAves = arrayIdAves;
        this.layout_personalizado = layout_personalizado;
        this.arrayIdPuntos = arrayIdPuntos;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();

        this.view = inflater.inflate(layout_personalizado, null);

        //Capturamos las etiquetas del layout personalizado
        ImageView imgAves = view.findViewById(R.id.imgAves);
        this.nombreAve = view.findViewById(R.id.tvNombreAve);
        TextView infoAve = view.findViewById(R.id.tvInfoAve);
        ImageView imgPuntoRaro = view.findViewById(R.id.imgPuntoRaro);

        imgAves.setImageDrawable(arrayIdAves.getDrawable(position));
        nombreAve.setText(nombreAves[position]);
        infoAve.setText(infoAves[position]);
        imgPuntoRaro.setImageDrawable(arrayIdPuntos.getDrawable(position));



        setStyle(position);

        return view;
    }

    private void setStyle(int position) {

        setBackground(position);

    }


    private void setBackground(int position) {

        if (position%2 != 0){

            nombreAve.setTextColor(activity.getResources().getColor(R.color.letraGris));
            view.setBackgroundColor(activity.getResources().getColor(R.color.azulclaro));

        } else {

            nombreAve.setTextColor(activity.getResources().getColor(R.color.letraAzul));
            view.setBackgroundColor(activity.getResources().getColor(R.color.azuloscuro));

        }

    }
}
