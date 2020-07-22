package com.example.rakel.datingfruit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DBManager {

    // create table videogames(_id integer primary key autoincrement, name string not null, year string, genre string);
    public static final String CREATE_TABLE_FRASES = " create table frases ("
            +"_id integer primary key autoincrement, "
            +"frase string not null, "
            +"foto string not null, "
            +"tieneRespuestas int not null);"; //0=false 1=true

    public static final String CREATE_TABLE_RESPUESTAS = " create table respuestas ("
            +"id_frase integer, "
            +"respuesta string not null, "
            +"puntos integer not null, "
            +"contestacion string not null, "
            +"foto string not null," +
            " foreign key(id_frase) references frases(_id));";

    private DBHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insertarFrase (String frase, String foto, int tieneRespuestas) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("frase", frase);
        contentValues.put("foto", foto);
        contentValues.put("tieneRespuestas", tieneRespuestas);
        db.insert("frases", null, contentValues);
    }
    public void insertarRespuesta (int id_frase, String respuesta, int puntos, String contestacion, String foto) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_frase", id_frase);
        contentValues.put("respuesta", respuesta);
        contentValues.put("puntos", puntos);
        contentValues.put("contestacion", contestacion);
        contentValues.put("foto", foto);
        db.insert("respuestas", null, contentValues);
    }

    public void crearDatos(){
        db.execSQL("DROP TABLE respuestas;");
        db.execSQL("DROP TABLE  frases;");
        db.execSQL(CREATE_TABLE_FRASES);
        db.execSQL(CREATE_TABLE_RESPUESTAS);
        crearFrases();
        crearRespuestas();
    }

    public void crearFrases(){
        insertarFrase("Entre toda la gente hay un brillo que me deslumbra, ¿quién es ella?","0",0);
        insertarFrase("Ese traje es precioso, y lleva la rama recogida con un lazo.","",0);
        insertarFrase("Que adorable... ojalá la conociera.","",0);
        insertarFrase(" ...","",0);
        insertarFrase("Creo que me está mirando.","",0);
        insertarFrase("¿Es a mi?","",0);
        insertarFrase("Está viniendo. ¿Qué hago?","",0);
        insertarFrase("Pera:\n" +
                "- Hello...","",1);
        insertarFrase("No puedo evitar sonrojarme, no me esperaba esto.","",0);
        insertarFrase("Esperanza:\n" +
                "- Bueno, soy Esperanza. ¿Cuál es tu nombre?","",1);
        insertarFrase("Esperanza:\n" +
                "- En realidad, he venido a decirte que te has pringado ahí abajo.","1",0);
        insertarFrase("¡¿Qué?! Mierda. (Miro abajo)\nMi suerte tan buena como siempre...","",0);
        insertarFrase("Tú:\n" +
                "- ...","",0);
        insertarFrase("No lo encuentro, ¿A qué se refiere?","",0);
        insertarFrase("Esperanza:\n" +
                "- ...","",0);
        insertarFrase("Me está mirando fijamente en silencio.","",0);
        insertarFrase("Tú:\n" +
                "- Espera...","",0);
        insertarFrase("Esperanza:\n" +
                "- Lo soy.","",0);
        insertarFrase("Tú:\n" +
                "- Me estabas vacilando. ¿Verdad?","",0);
        insertarFrase("Esperanza:\n" +
                "- Y lo sigo haciendo jajaja.","1",0);
        insertarFrase("Tú:\n" +
                "- Hmf, vaya, pues si has venido a reírte de mí...","",0);
        insertarFrase("Esperanza:\n" +
                "- Ay no, no te vayas. ¡Lo siento!","0",0);
        insertarFrase("Esperanza:\n" +
                "- En verdad he venido a hablar contigo un rato, verás...","",0);
        insertarFrase("Esperanza:\n" +
                "- He venido con dos amigos y me está tocando estar de sujetavelas...","",0);
        insertarFrase("Esperanza:\n" +
                "- No sabía muy bien que hacer, entonces te he visto y, no sé, a la gente de esta sala ya me la conozco bien.","",1);
        insertarFrase("Tú:\n" +
                "- Em... ¿Y con quiénes decías que habías venido?","",0);
        insertarFrase("Esperanza:\n" +
                "- Con Kaki Perry y Naranja Estranja, están por allí.","",0);
        insertarFrase("Tú:\n" +
                "- Espera-","",0);
        insertarFrase("Esperanza:\n" +
                "- ¿Yo?","1",0);
        insertarFrase("Tú:\n" +
                "- ...","",0);
        insertarFrase("Tú:\n" +
                "- La broma me empieza a cansar.","",0);
        insertarFrase("Tú:\n" +
                "- ¿¡Has dicho Kaki Perry!? ¡La conoces!","",0);
        insertarFrase("Esperanza:\n" +
                "- Claro, somos amigas de la infancia, me ha invitado a venir aquí.","0",0);
        insertarFrase("Tú:\n" +
                "- ¿Es la primera vez que vienes?","",0);
        insertarFrase("Tú:\n" +
                "- Anda. Antes habías dicho que te conocías a la gente de esta sala.","",0);
        insertarFrase("Esperanza:\n" +
                "- ...","2",0);
        insertarFrase("Tú:\n" +
                "- ...","",0);
        insertarFrase("Esperanza:\n" +
                "- Vale. No es como si fuera alguien famoso como toda esta gente. Siento decepcionarte.","1",1);
        insertarFrase("Tú:\n" +
                "- A mí me ha traído mi amigo Piñahán, también somos amigos de la infancia,","",0);
        insertarFrase("Esperanza:\n" +
                "- Entonces te sentirás aquí tan raro como yo.","0",0);
        insertarFrase("Esperanza:\n" +
                "- Bueno... ¿Y en qué trabajas o estudias?","",1);
        insertarFrase("Tú:\n" +
                "- Vaya, bueno. ¿Y tú qué?","",0);
        insertarFrase("Esperanza:\n" +
                "- Yo me dedico al mundo de la ópera.","",0);
        insertarFrase("Tú:\n- Anda, ¿has actuando en el teatro real y eso?","",0);
        insertarFrase("Esperanza:\n" +
                "- En verdad, todavía no. Pero tengo esperanzas.","1",0);
        insertarFrase("Esperanza:\n" +
                "- Oye ¿Y qué series estás siguiendo?","0",1);
        insertarFrase("Esperanza:\n" +
                "- Oye, me voy un momento al baño. Ahora vuelvo, espera aquí","",0);
    }

    public void crearRespuestas(){
        insertarRespuesta(8,"¿Tú también con el Spanglish?",-5,"Pera:\n" +
                "- Era una broma, lo decía por la manera de hablar de tu amigo. Es igual.","2");
        insertarRespuesta(8,"Ey booi",20,"Pera:\n" +
                "- ¡Jajajaja no me esperaba eso! Qué genial.","1");
        insertarRespuesta(8,"I am hello too",10,"Pera:\n" +
                "- Tranqui, no hace falta que lo intentes","0");

        insertarRespuesta(10,"Soy Paparajote, encantado.",10,"Esperanza:\n" +
                "- Igualmente, Paparajote.","0");
        insertarRespuesta(10,"No sé, dímelo tú.",-10,"Esperanza:\n" +
                "- ¿Qué? ¿Cómo voy a saberlo?","2");
        insertarRespuesta(10,"Ai am mad saientist, its sou c-",20,"Esperanza:\n" +
                "- Uy no serás un otaco de esos.","1");

        insertarRespuesta(25,"Bueno, te perdono, pero por esta vez, eh.",20,"Esperanza:\n" +
                "- Claro, claro... jajaja","1");
        insertarRespuesta(25,"Anda, vente que te invito a algo.",-20,"Esperanza:\n" +
                "- Me puedo invitar yo, gracias.","2");
        insertarRespuesta(25,"A lo mejor no les conoces lo suficiente.",10,"Esperanza:\n" +
                "- ¡Qué rencoroso! No te enfades jajaja","1");

        insertarRespuesta(38,"¿Y mientes para caerme bien? Qué vergüenza.",-100,"Esperanza:\n" +
                "- Bueno, a lo mejor no me hubiera hecho falta hacerlo si la gente con dinero como tú fuerais tan #@$%*! ; Esperanza:\n" +
                "- Es igual, ya me voy. ; Tú:\n" +
                "- ¡Espera!","2");
        insertarRespuesta(38,"Ya somos dos.",10,"Esperanza:\n- ¿En decepcionarte?","1");
        insertarRespuesta(38,"¿Tú crees?",-10,"Esperanza:\n- Que si yo creo, qué.","2");

        insertarRespuesta(41,"Pues verás soy Youtuber.",-20,"Esperanza:\n" +
                "- Anda. ¿Y qué subes? ; Tú:\n" +
                "- Minecraft. ; Esperanza:\n" +
                "- Eugh...","2");
        insertarRespuesta(41,"Estudio para hacer bideojocs.",10,"Esperanza:\n" +
                "- ¿Pero eso es una carrera? No lo sabía.","1");
        insertarRespuesta(41,"Soy artista.",20,"Esperanza:\n" +
                "- ¡Vaya, regálame un dibujo! ... Es broma.","1");

        insertarRespuesta(46,"Sólo los vigilantes de la parra.",10,"Esperanza:\n" +
                "- Ahm, bueno, eso esta bien...","0");
        insertarRespuesta(46,"No veo series, sólo SAO.",100,"Esperanza:\n" +
                "- No me digas más.","0");
        insertarRespuesta(46,"En la tele veo Gran Manzano y el Plántame.",-40,"Esperanza:\n" +
                "- Eugh... vaya.","2");
    }

    public Cursor consultarFrase (int id) {
        String[] columnas = new String[]{"frase","foto","tieneRespuestas"};
        return db.query("frases", columnas, "_id="+id, null, null, null, null);
    }

    public Cursor consultarRespuestas (int idFrase) {
        String[] columnas = new String[]{"respuesta","puntos","contestacion","foto"};
        return db.query("respuestas", columnas, "id_frase="+idFrase, null, null, null, null);
    }
}
