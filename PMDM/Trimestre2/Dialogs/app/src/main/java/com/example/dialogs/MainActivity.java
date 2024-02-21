package com.example.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static int NOTIFICACION_1 = 1;

    private Button btnDia_1;
    private Button btnDia_2;
    private Button btnDia_3;
    private Button btnDia_4;
    private Button btnDia_5;
    private Button btnDia_52;
    private Button btnDia_6;
    private Button btnNotif_1;
    private Button btnAct_2;
    private ArrayList<String> eleccionColores = new ArrayList<>();
    private boolean[] arrayRes ;

    private int selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.finds();
    }

    private void finds() {

        this.btnDia_1 = findViewById(R.id.btnDia_1);
        this.btnDia_2 = findViewById(R.id.btnDia_2);
        this.btnDia_3 = findViewById(R.id.btnDia_3);
        this.btnDia_4 = findViewById(R.id.btnDia_4);
        this.btnDia_5 = findViewById(R.id.btnDia_5);
        this.btnDia_52 = findViewById(R.id.btnDia_52);
        this.btnDia_6 = findViewById(R.id.btnDia_6);
        this.btnNotif_1 = findViewById(R.id.btnNotif_1);
        this.btnAct_2 = findViewById(R.id.btnAct_2);

    }

    public void onClickBtnDia(View view) {

        switch (view.getId()) {

            case R.id.btnDia_1:

                dialogo_mensaje();

                break;

            case R.id.btnDia_2:

                dialogo_ventana_1boton();

                break;

            case R.id.btnDia_3:

                dialogo_ventana_2botones();

                break;

            case R.id.btnDia_4:

                dialogo_ventana_3botones();

                break;

            case R.id.btnDia_5:

                dialogo_lista_simple();

                break;

            case R.id.btnDia_52:

                dialogo_lista_boton_ok();

                break;

            case R.id.btnDia_6:

                dialogo_checkbox();

                break;


            case R.id.btnNotif_1:

                notificacion();

                break;


            case R.id.btnAct_2:

                notificacionActivity();

                break;

        }

    }

    private void dialogo_mensaje() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setMessage("Esto es un MENSAJE DE AVISO DEL BLAblaBLA")
                .setTitle("Alerta ERROR Maligno!!")
                .show();
    }

    private void dialogo_ventana_1boton() {

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setMessage("Esto es un mensaje de ALERTA")
                .setTitle("ALERTA MALIGNA BOTON")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        Toast t = Toast.makeText(MainActivity.this,"Pulsado OK",Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.TOP, 0,0);
                        t.show();

                    }
                });
        ventana.show();
    }

    private void dialogo_ventana_2botones() {

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setMessage("Esto es un mensaje de ALERTA")
                .setTitle("ALERTA MALIGNA BOTON")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        customToast();

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        Toast.makeText(MainActivity.this, "Pulsaste Cancel...", Toast.LENGTH_SHORT).show();

                    }
                });
        ventana.show();

    }

    private void dialogo_ventana_3botones() {

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setMessage("Esto es un mensaje de ALERTA")
                .setTitle("ALERTA MALIGNA BOTON")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        Toast.makeText(MainActivity.this, "Pulsaste OK!", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //TODO operaciones pertinentes
                        Toast.makeText(MainActivity.this, "Pulsaste Cancel...", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNeutralButton("Acerca de", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, "Pulsaste Acerca de :)", Toast.LENGTH_SHORT).show();

                    }
                });
        ventana.show();
    }

    private void dialogo_lista_simple() {

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setCancelable(false)
                .setItems(R.array.colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, getResources().getStringArray(R.array.colores)[which], Toast.LENGTH_SHORT).show();

                    }
                });
        ventana.show();

    }

    private void dialogo_lista_boton_ok() {

        selected = 0;

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setCancelable(false)
                .setSingleChoiceItems(R.array.colores, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        selected = which;

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, getResources().getStringArray(R.array.colores)[selected], Toast.LENGTH_SHORT).show();

                    }
                });
        ventana.show();

    }


    private void dialogo_checkbox() {

        //this.eleccionColores.clear();       //Seria mejor con un array de booleans

        this.arrayRes = new boolean[getResources().getStringArray(R.array.colores).length];

        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.jupiter)
                .setCancelable(false)
                .setMultiChoiceItems(getResources().getStringArray(R.array.colores), null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

/*                        if(isChecked){
                            eleccionColores.add(getResources().getStringArray(R.array.colores)[which]);
                        }else{
                            eleccionColores.remove(getResources().getStringArray(R.array.colores)[which]);
                        }*/

                        arrayRes[which] = isChecked;

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

/*                        String result = recorrerChecbox();

                        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();*/

                        String result = getBooleanParse();
                        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

                    }
                });
        ventana.show();

    }

    private String getBooleanParse(){

        String returnable = "Has seleccionado: ";

        for(int i = 0; i < this.arrayRes.length; i++){

            if(this.arrayRes[i]){

                returnable = returnable.concat("\n"+getResources().getStringArray(R.array.colores)[i]);

            }
        }
        return returnable;
    }

    private void resetToFalse(){

        for(boolean b : this.arrayRes){

            b = false;

        }

    }

    private String recorrerChecbox(){

        String returnable = "Has seleccionado: ";

        for (String s: this.eleccionColores) {

            returnable = returnable.concat("\n"+s );

        }

        return returnable;

    }

    private void customToast(){

        LinearLayout toast = findViewById(R.id.ll_toast);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_personalizada,toast);
        TextView txtv = view.findViewById(R.id.txt_mensaje_toast);
        txtv.setText("Hola mundo");
        Toast toastF = new Toast(this);
        toastF.setDuration(Toast.LENGTH_SHORT);
        toastF.setGravity(Gravity.TOP,0,0);
        toastF.setView(view);
        toastF.show();

    }

    private void notificacion(){

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.jupiter);

            Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.jupiter)
                .setTicker("Soy el mensaje opcional")
                .setContentTitle("Titulo notificación")
                .setContentText("Contenido...")
                .setLargeIcon(largeIcon);

        Intent intent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE);

        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = builder.build();

        notificationManager.notify(NOTIFICACION_1,notification);
    }

    private void notificacionActivity(){

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.jupiter);

        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.jupiter)
                .setTicker("Soy el mensaje opcional")
                .setContentTitle("Titulo notificación")
                .setContentText("Contenido...")
                .setLargeIcon(largeIcon);

        Intent intent = new Intent(this, Activity_2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE);

        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = builder.build();

        notificationManager.notify(NOTIFICACION_1,notification);


    }
}