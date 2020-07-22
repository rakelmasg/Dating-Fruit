package com.example.rakel.datingfruit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class Dialogo_granada extends Activity {

    private TextView frase;
    private ImageView imgFondo, imgGranada, imgDialogo, imgVolver;
    private String txt[] = {"Tú:\n- Hm, hola y eso. Vengo con un amigo. ¿Pero de qué pera me hablas?",
            "Granada:\n- Jajaja es broma, cipollo. Pero ella sí que era un poco friki, antes me estaba hablado sobre una serie de chinos, Bladear Online o algo así.",
            "Granada:\n- Te dejo compae."
    };
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo_granada);

        try {
            InputStream imagen1 = getResources().openRawResource(R.raw.disco_blur);
            imgFondo = (ImageView) findViewById(R.id.imagenDiscoGranada);
            imgFondo.setImageBitmap(BitmapFactory.decodeStream(imagen1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen2 = getResources().openRawResource(R.raw.granada);
            imgGranada = (ImageView) findViewById(R.id.imagenGranada);
            imgGranada.setImageBitmap(BitmapFactory.decodeStream(imagen2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen3 = getResources().openRawResource(R.raw.cuadro);
            imgDialogo = (ImageView) findViewById(R.id.imagenDialogoGranada);
            imgDialogo.setImageBitmap(BitmapFactory.decodeStream(imagen3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen4 = getResources().openRawResource(R.raw.volver);
            imgVolver = (ImageView) findViewById(R.id.imgVolverGranada);
            imgVolver.setImageBitmap(BitmapFactory.decodeStream(imagen4));
        } catch (Exception e) {
            e.printStackTrace();
        }

        frase = (TextView) findViewById(R.id.fraseGranada);

        imgDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i < txt.length) {
                    frase.setText(txt[i]);
                    i++;
                } else {
                    startActivity(new Intent(Dialogo_granada.this, Discoteca.class));
                }
            }
        });

        imgVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dialogo_granada.this, Discoteca.class));
            }
        });

    }
}
