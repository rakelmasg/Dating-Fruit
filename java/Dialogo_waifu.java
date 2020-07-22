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


public class Dialogo_waifu extends Activity {

    TextView nombre, frase;
    ProgressBar progreso;
    DBManager db;
    Cursor cursor;
    String contestacion;
    String contestacionArray[];
    ImageView imgFondo, imgFruta, imgDialogo, imgVolver, imgCorazon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo_waifu);
        db = new DBManager(this);

        try {
            InputStream imagen1 = getResources().openRawResource(R.raw.disco_blur);
            imgFondo = (ImageView) findViewById(R.id.imagenDiscoDialogoWaifu);
            imgFondo.setImageBitmap(BitmapFactory.decodeStream(imagen1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen2 = getResources().openRawResource(R.raw.pera0);
            imgFruta = (ImageView) findViewById(R.id.imagenWaifu);
            imgFruta.setImageBitmap(BitmapFactory.decodeStream(imagen2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen3 = getResources().openRawResource(R.raw.cuadro);
            imgDialogo = (ImageView) findViewById(R.id.imagenDialogoWaifu);
            imgDialogo.setImageBitmap(BitmapFactory.decodeStream(imagen3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen4 = getResources().openRawResource(R.raw.volver);
            imgVolver = (ImageView) findViewById(R.id.imgVolverWaifu);
            imgVolver.setImageBitmap(BitmapFactory.decodeStream(imagen4));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen5 = getResources().openRawResource(R.raw.heart);
            imgCorazon = (ImageView) findViewById(R.id.corazonWaifu);
            imgCorazon.setImageBitmap(BitmapFactory.decodeStream(imagen5));
        } catch (Exception e) {
            e.printStackTrace();
        }

        nombre = (TextView) findViewById(R.id.nombreWaifu);
        if (Estado.id_frase_Waifu < 10) {
            nombre.setText("     Pera");
        }

        progreso = (ProgressBar) findViewById(R.id.progreso);
        progreso.setProgress(Estado.puntos);

        frase = (TextView) findViewById(R.id.fraseWaifu);
        cursor = db.consultarFrase(Estado.id_frase_Waifu);
        cursor.moveToNext();

        contestacion = getIntent().getStringExtra("contestacion");
        if (contestacion == null) {
            frase.setText(cursor.getString(0));
            cambiarImagen(cursor.getString(1));
        } else {
            cambiarImagen(getIntent().getStringExtra("foto"));
            contestacionArray = contestacion.split(" ; ");
            frase.setText(contestacionArray[0]);
            if (contestacionArray.length == 1) {
                contestacion = "";
            } else {
                String aux[] = {contestacionArray[1], contestacionArray[2]};
                contestacionArray = aux;
            }
        }

        imgDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contestacion == null) {
                    if (cursor.getInt(2) == 0) {
                        Estado.id_frase_Waifu += 1;
                        if (Estado.id_frase_Waifu >= Estado.MAX_ID_FRASE) {
                            Intent intent = new Intent(Dialogo_waifu.this, Final.class);
                            intent.putExtra("foto", "bad");
                            startActivity(intent);
                        } else {
                            cursor = db.consultarFrase(Estado.id_frase_Waifu);
                            cursor.moveToNext();
                            frase.setText(cursor.getString(0));
                            cambiarImagen(cursor.getString(1));
                            if (Estado.id_frase_Waifu >= 10) {
                                nombre.setText("Esperanza");
                            }

                        }
                    } else {
                        startActivity(new Intent(Dialogo_waifu.this, Respuestas_waifu.class));
                    }
                } else if (contestacion == "") {
                    if (!comprobarFinJuego()) {
                        frase.setText(cursor.getString(0));
                        cambiarImagen(cursor.getString(1));
                        contestacion = null;
                    }
                } else {
                    frase.setText(contestacionArray[0]);
                    if (contestacionArray.length == 2) {
                        String aux[] = {contestacionArray[1]};
                        contestacionArray = aux;
                    } else {
                        contestacion = "";
                    }

                }
            }
        });

        imgVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dialogo_waifu.this, Discoteca.class));
            }
        });

    }

    private boolean comprobarFinJuego() {
        Intent intent;
        if (Estado.puntos >= 100) {
            intent = new Intent(Dialogo_waifu.this, Final.class);
            intent.putExtra("foto", "true");
            startActivity(intent);
            return true;
        } else if (Estado.puntos <= 0) {
            intent = new Intent(Dialogo_waifu.this, Final.class);
            intent.putExtra("foto", "worse");
            startActivity(intent);
            return true;
        }
        return false;
    }

    private void cambiarImagen(String img) {
        InputStream imagenAux;
        if (!img.equals("")) {
            if (img.equals("0")) {
                imagenAux = getResources().openRawResource(R.raw.pera0);
            } else if (img.equals("1")) {
                imagenAux = getResources().openRawResource(R.raw.pera1);
            } else {
                imagenAux = getResources().openRawResource(R.raw.pera2);
            }
            try {
                imgFruta.setImageBitmap(BitmapFactory.decodeStream(imagenAux));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
