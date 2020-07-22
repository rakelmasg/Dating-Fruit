package com.example.rakel.datingfruit;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.InputStream;


public class Respuestas_waifu extends Activity {

    ProgressBar progreso;
    ImageView imgFondo, imgFruta, imgVolver, imgCorazon, imgRespuesta1,imgRespuesta2,imgRespuesta3;
    TextView respuesta1, respuesta2, respuesta3;
    DBManager db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas_waifu);


        try {
            InputStream imagen1 = getResources().openRawResource(R.raw.disco_blur);
            imgFondo = (ImageView) findViewById(R.id.imagenDiscoRespuestas);
            imgFondo.setImageBitmap(BitmapFactory.decodeStream(imagen1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen2 = getResources().openRawResource(R.raw.pera0);
            imgFruta = (ImageView) findViewById(R.id.imagenWaifuRespuestas);
            imgFruta.setImageBitmap(BitmapFactory.decodeStream(imagen2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen3 = getResources().openRawResource(R.raw.volver);
            imgVolver = (ImageView) findViewById(R.id.imgVolverRespuestas);
            imgVolver.setImageBitmap(BitmapFactory.decodeStream(imagen3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen4 = getResources().openRawResource(R.raw.heart);
            imgCorazon = (ImageView) findViewById(R.id.corazonRespuestas);
            imgCorazon.setImageBitmap(BitmapFactory.decodeStream(imagen4));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            InputStream imagen5 = getResources().openRawResource(R.raw.opcion);
            imgRespuesta1 = (ImageView) findViewById(R.id.imgRespuesta1);
            imgRespuesta1.setImageBitmap(BitmapFactory.decodeStream(imagen5));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen6 = getResources().openRawResource(R.raw.opcion);
            imgRespuesta2 = (ImageView) findViewById(R.id.imgRespuesta2);
            imgRespuesta2.setImageBitmap(BitmapFactory.decodeStream(imagen6));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen7 = getResources().openRawResource(R.raw.opcion);
            imgRespuesta3 = (ImageView) findViewById(R.id.imgRespuesta3);
            imgRespuesta3.setImageBitmap(BitmapFactory.decodeStream(imagen7));
        } catch (Exception e) {
            e.printStackTrace();
        }

        progreso = (ProgressBar) findViewById(R.id.progresoRespuestas);
        progreso.setProgress(Estado.puntos);

        respuesta1 = (TextView) findViewById(R.id.respuesta1);
        respuesta2 = (TextView) findViewById(R.id.respuesta2);
        respuesta3 = (TextView) findViewById(R.id.respuesta3);
        db = new DBManager(this);
        cursor = db.consultarRespuestas(Estado.id_frase_Waifu);
        cursor.moveToNext();
        respuesta1.setText(cursor.getString(0));
        cursor.moveToNext();
        respuesta2.setText(cursor.getString(0));
        cursor.moveToNext();
        respuesta3.setText(cursor.getString(0));

        respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesar(0);
            }
        });

        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesar(1);
            }
        });

        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesar(2);
            }
        });
    }

    private void procesar(int pos) {
        cursor.moveToPosition(pos);
        Estado.puntos += cursor.getInt(1);
        Estado.id_frase_Waifu +=1;
        Intent intent;
        intent = new Intent(Respuestas_waifu.this, Dialogo_waifu.class);
        intent.putExtra("contestacion", cursor.getString(2));
        intent.putExtra("foto", cursor.getString(3));
       startActivity(intent);
    }
}