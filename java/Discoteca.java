package com.example.rakel.datingfruit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;


public class Discoteca extends Activity {

    private ImageView fondo, imgPera, imgVolver, imgPlatanos, imgGranada;
    public static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discoteca);

        if (getIntent().getStringExtra("init") != null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.disco);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }

        try {
            InputStream imagen1 = getResources().openRawResource(R.raw.disco_blur);
            fondo = (ImageView) findViewById(R.id.fondo);
            fondo.setImageBitmap(BitmapFactory.decodeStream(imagen1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen2 = getResources().openRawResource(R.raw.volver);
            imgVolver = (ImageView) findViewById(R.id.imgVolverDisco);
            imgVolver.setImageBitmap(BitmapFactory.decodeStream(imagen2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen3 = getResources().openRawResource(R.raw.pera0);
            imgPera = (ImageView) findViewById(R.id.pera);
            imgPera.setImageBitmap(BitmapFactory.decodeStream(imagen3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen4 = getResources().openRawResource(R.raw.banana_pj_2);
            imgPlatanos = (ImageView) findViewById(R.id.platanos);
            imgPlatanos.setImageBitmap(BitmapFactory.decodeStream(imagen4));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen5 = getResources().openRawResource(R.raw.granada);
            imgGranada = (ImageView) findViewById(R.id.granada);
            imgGranada.setImageBitmap(BitmapFactory.decodeStream(imagen5));
        } catch (Exception e) {
            e.printStackTrace();
        }


        imgPera.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Discoteca.this, Dialogo_waifu.class));
                    }
                }
        );

        imgGranada.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Discoteca.this, Dialogo_granada.class));
                    }
                }
        );

        imgPlatanos.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Discoteca.this, Dialogo_platanos.class));
                    }
                }
        );

        imgVolver.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.pause();
                        startActivity(new Intent(Discoteca.this, Titulo.class));
                    }
                }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;

    }
}
