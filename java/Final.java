package com.example.rakel.datingfruit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class Final extends Activity {

    private ImageView imgFondo;
    private String foto;
    private InputStream recurso;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Discoteca.mediaPlayer.pause();

        imgFondo = (ImageView) findViewById(R.id.imagenFinal);

        foto = getIntent().getStringExtra("foto");
        if (foto.equals("bad")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.badend);
            mediaPlayer.start();
            recurso = getResources().openRawResource(R.raw.bad_end);
        } else if (foto.equals("worse")) {
            mediaPlayer = MediaPlayer.create(this, R.raw.badend);
            mediaPlayer.start();
            recurso = getResources().openRawResource(R.raw.worse_end);
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.truend);
            mediaPlayer.start();
            recurso = getResources().openRawResource(R.raw.true_end);
        }

        try {
            imgFondo.setImageBitmap(BitmapFactory.decodeStream(recurso));
        } catch (Exception e) {
            e.printStackTrace();
        }


        imgFondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                startActivity(new Intent(Final.this, Titulo.class));
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
