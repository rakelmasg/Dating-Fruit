package com.example.rakel.datingfruit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;


public class Creditos extends Activity {

    ImageView imgFondo, imgVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        try {
            InputStream imagen1 = getResources().openRawResource(R.raw.cuadro_creditos);
            imgFondo = (ImageView) findViewById(R.id.imagenFondoCreditos);
            imgFondo.setImageBitmap(BitmapFactory.decodeStream(imagen1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen2 = getResources().openRawResource(R.raw.volver);
            imgVolver = (ImageView) findViewById(R.id.imgVolverCreditos);
            imgVolver.setImageBitmap(BitmapFactory.decodeStream(imagen2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        imgVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Creditos.this, Titulo.class);
                i.putExtra("creditos","creditos");
                startActivity(i);
            }
        });
    }
}
