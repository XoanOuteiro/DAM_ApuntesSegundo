package com.example.repasobd;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    private Activity activity;
    private List nameList;
    private List codesList;
    private int layout_custom;

    public CustomAdapter(@NonNull Activity activity, int resource, List<String> namesList, List<Integer> ccodesList) {
        super(activity, resource, namesList);

        this.activity = activity;
        this.codesList = ccodesList;
        this.nameList = namesList;
        this.layout_custom = resource;
    }

    //ASOCIA UN LAYOUT PERSONALIZADO A LA VIEW
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View fila = convertView;
        ViewHolder holder;

        if (fila == null){

            LayoutInflater inflater = activity.getLayoutInflater();

            fila = inflater.inflate(this.layout_custom, null);

            holder = new ViewHolder();
            holder.txtCodigo = fila.findViewById(R.id.txtNum);
            holder.txtName = fila.findViewById(R.id.txtName);

            fila.setTag(holder);

        } else {

            holder = (ViewHolder) fila.getTag();

        }

        holder.txtCodigo.setText(codesList.get(position).toString());

        holder.txtName.setText(nameList.get(position).toString());

        return fila;
    }

    //ESTE VIEWHOLDER VALE PARA AHORRAR RECURSOS
    static class ViewHolder {

        TextView txtCodigo;
        TextView txtName;

    }

}
