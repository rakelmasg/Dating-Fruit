package com.example.rakel.datingfruit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class Intro extends Activity {

    public static MediaPlayer mediaPlayer;
    private TextView texto;
    private String txt []={ "Es el lugar que escoge gente famosa como Kiwi Martin o Caqui Perry." +
            "\n\n Y esta noche tendré la suerte de poder entrar.",
            "Piñahán Mateo es mi amigo de la infancia.\n\nHa decidido invitarme para celebrar que" +
            " le hayan escogido como protagonista en una famosa serie de la tele.",
            "Piñahán es alguien confiable, siempre está de buen humor aunque a veces está un" +
            " poco en su mundo."};
    private int i=0;
    private ImageView imgLetrero, imgFondo, imgTexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mediaPlayer = MediaPlayer.create(this, R.raw.fuera);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        try {
            InputStream imagen1 = getResources().openRawResource(R.raw.letrero_juizzy);
            imgLetrero = (ImageView) findViewById(R.id.imagenLetrero);
            imgLetrero.setImageBitmap(BitmapFactory.decodeStream(imagen1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen2 = getResources().openRawResource(R.raw.puerta_disco);
            imgFondo = (ImageView) findViewById(R.id.imagenDiscoIntro);
            imgFondo.setImageBitmap(BitmapFactory.decodeStream(imagen2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen3 = getResources().openRawResource(R.raw.cuadro_grande);
            imgTexto = (ImageView) findViewById(R.id.imagenTexto);
            imgTexto.setImageBitmap(BitmapFactory.decodeStream(imagen3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        texto = (TextView) findViewById(R.id.texto);
        imgTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<txt.length) {
                    texto.setText(txt[i]);
                    i++;
                }else{
                    startActivity(new Intent(Intro.this, Dialogo_pineapple.class));
                }
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
