package com.example.rakel.datingfruit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class Dialogo_platanos extends Activity {

    private TextView frase;
    private ImageView imgFondo, imgPlatanos, imgDialogo, imgVolver;
    private int state = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo_platanos);

        try {
            InputStream imagen1 = getResources().openRawResource(R.raw.disco_blur);
            imgFondo = (ImageView) findViewById(R.id.imagenDiscoPlatanos);
            imgFondo.setImageBitmap(BitmapFactory.decodeStream(imagen1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen2 = getResources().openRawResource(R.raw.banana_pj_2);
            imgPlatanos = (ImageView) findViewById(R.id.imagenPlatanos);
            imgPlatanos.setImageBitmap(BitmapFactory.decodeStream(imagen2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen3 = getResources().openRawResource(R.raw.cuadro);
            imgDialogo = (ImageView) findViewById(R.id.imagenDialogoPlatanos);
            imgDialogo.setImageBitmap(BitmapFactory.decodeStream(imagen3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen4 = getResources().openRawResource(R.raw.volver);
            imgVolver = (ImageView) findViewById(R.id.imgVolverPlatanos);
            imgVolver.setImageBitmap(BitmapFactory.decodeStream(imagen4));
        } catch (Exception e) {
            e.printStackTrace();
        }

        frase = (TextView) findViewById(R.id.frasePlatanos);

        imgDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state == 0) {
                   frase.setText("Tú:\n- ¿Perdona?");
                    state = 1;
                } else if (state == 1) {
                    try {
                        InputStream imagen5 = getResources().openRawResource(R.raw.banana_pj);
                        imgPlatanos.setImageBitmap(BitmapFactory.decodeStream(imagen5));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    frase.setText("Plátanos:\n- Ay meneño, hablaba al pollaboba de mi hermano que está mamao " +
                            "y se pegó un estampido, mira, estoy ocupao, ahora no puedo hablar.");
                    state = 2;
                } else {
                    startActivity(new Intent(Dialogo_platanos.this, Discoteca.class));
                }
            }
        });

        imgVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dialogo_platanos.this, Discoteca.class));
            }
        });

    }
}
