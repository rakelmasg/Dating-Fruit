package com.example.rakel.datingfruit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class Dialogo_pineapple extends Activity {

    private TextView frase;
    private ImageView imgFondo, imgPineapple, imgDialogo, imgNombre;
    private String txt []={ "Tú:\n- ¡Buenas! Pues estoy un poco nervioso",
            "Piñahán:\n- No worries brah!!! Esta noche va a ser awesome!!",
            "Tú:\n- Puede que tengas razón, por cierto, enhorabuena por lo de la serie.",
            "Piñahán:\n- Ya ves brah!! Vigilantes de la Parra tiio! Al principio pensaba que no iba a ser" +
                    "compatible pero PAM ahí estuve en el casting.",
            "Piñahán:\n- Bueno, dejemos de hablar de mí, what about you brah? Estás preparado para" +
                    "triunfar esta noche?",
            "Tú:\n- No sé, no estoy acostumbrado a este tipo de cosas.",
            "Piñahán:\n- Que aburrido, c’mon verás como sí... Oye, no es esa Lady Coco? Te espero dentro!"};
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo_pineapple);

        try {
            InputStream imagen1 = getResources().openRawResource(R.raw.puerta_disco);
            imgFondo = (ImageView) findViewById(R.id.imagenDiscoFuera);
            imgFondo.setImageBitmap(BitmapFactory.decodeStream(imagen1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen2 = getResources().openRawResource(R.raw.pineapple);
            imgPineapple = (ImageView) findViewById(R.id.imagenPineapple);
            imgPineapple.setImageBitmap(BitmapFactory.decodeStream(imagen2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream imagen3 = getResources().openRawResource(R.raw.cuadro);
            imgDialogo = (ImageView) findViewById(R.id.imagenDialogoPineapple);
            imgDialogo.setImageBitmap(BitmapFactory.decodeStream(imagen3));
        } catch (Exception e) {
            e.printStackTrace();
        }


        frase =(TextView) findViewById(R.id.frasePineapple);

        imgDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<txt.length) {
                    frase.setText(txt[i]);
                    i++;
                }else{
                    Intro.mediaPlayer.pause();
                    Intent intent = new Intent(Dialogo_pineapple.this, Discoteca.class);
                    intent.putExtra("init", "init");
                    startActivity(intent);
                }
            }
        });

    }
}
