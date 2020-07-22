package com.example.rakel.datingfruit;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class Titulo extends AppCompatActivity {

    private DBManager db;
    private ImageView imgFondo, imgPlay, imgCreditos;
    public static MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titulo);

        Estado.puntos = 20;
        Estado.id_frase_Waifu = 1;

        if (mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(this, R.raw.titulo);


        try {
            InputStream imagen = getResources().openRawResource(R.raw.portada);
            imgFondo = (ImageView) findViewById(R.id.imagenTitulo);
            imgFondo.setImageBitmap(BitmapFactory.decodeStream(imagen));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen = getResources().openRawResource(R.raw.play);
            imgPlay = (ImageView) findViewById(R.id.imagenPlay);
            imgPlay.setImageBitmap(BitmapFactory.decodeStream(imagen));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen = getResources().openRawResource(R.raw.creditos);
            imgCreditos = (ImageView) findViewById(R.id.imagenCreditos);
            imgCreditos.setImageBitmap(BitmapFactory.decodeStream(imagen));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (getIntent().getStringExtra("creditos") == null) {
            mediaPlayer.setLooping(true);
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
        }

        db = new DBManager(this);
        db.crearDatos();
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                startActivity(new Intent(Titulo.this, Intro.class));
            }
        });

        imgCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Titulo.this, Creditos.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }


}

