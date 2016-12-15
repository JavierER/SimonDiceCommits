package com.example.javii.simondicecommit;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start;
    Handler display1 = new Handler();
    Handler display2 = new Handler();
    Button[] botones;

    MediaPlayer sonidos[];
    int numeros[];
    int orden[];
    int pulsados = 0;
    private int tiempoEncendido = 600;
    private int tiempoApagado = 1200;
    boolean enabledPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orden = new int[4];
        numeros = new int[4];
        botones = new Button[4];
        start = (Button) findViewById(R.id.bplay);
        botones[0] = (Button) findViewById(R.id.bazul);
        botones[1] = (Button) findViewById(R.id.brojo);
        botones[2] = (Button) findViewById(R.id.bverde);
        botones[3] = (Button) findViewById(R.id.bamarillo);
        sonidos = new MediaPlayer[4];
        sonidos[0]=MediaPlayer.create(this,R.raw.allahu);
        sonidos[1]=MediaPlayer.create(this,R.raw.sonido1);
        sonidos[2]=MediaPlayer.create(this,R.raw.mariosalto);
        sonidos[3]=MediaPlayer.create(this,R.raw.mariomoneda);
    }

    public void Click(View v) {
        int posicion;
        int id = v.getId();
        final Button b = (Button) v;

        if (id == R.id.bazul) {
            v.setBackgroundResource(R.color.azul);
            sonidos[0].start();
            posicion = 0;

        } else if (id == R.id.brojo) {
            v.setBackgroundResource(R.color.rojo);
            sonidos[1].start();
            posicion = 1;

        } else if (id == R.id.bverde) {
            v.setBackgroundResource(R.color.verde);
            sonidos[2].start();
            posicion = 2;

        } else {
            v.setBackgroundResource(R.color.amarillo);
            sonidos[3].start();
            posicion = 3;
        }

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                reiniciar(b.getId());
            }
        },500);

        if(enabledPlay) {
            orden[pulsados] = posicion;
            pulsados++;
            if (pulsados == 4) {
                check();

            }
        }
    }

    public void empezar(View v) {
        enabledPlay=true;
        for (int i = 0; i < numeros.length; i++) {

            numeros[i] = (int) (Math.random() * 4);
            final Button b=botones[numeros[i]];
            System.out.println(numeros[i]);

            if(b.getId()==R.id.bazul){
                display1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundResource(R.color.azul);

                    }
                },tiempoEncendido);



            }else if(b.getId()==R.id.brojo){
                display1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundResource(R.color.rojo);
                    }
                },tiempoEncendido);
            }else if(b.getId()==R.id.bverde){

                display1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundResource(R.color.verde);

                    }
                },tiempoEncendido);
            }else {

                display1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundResource(R.color.amarillo);

                    }
                },tiempoEncendido);
            }

            final Button boton= b;

            display2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    reiniciar(boton.getId());
                }
            },tiempoApagado);

            tiempoEncendido+=300;
            tiempoApagado+=600;


        }


    }

    public void reiniciar(int id) {
        if (id == R.id.bazul) {
            botones[0].setBackgroundResource(R.color.azulOscuro);

        } else if (id == R.id.brojo) {
            botones[1].setBackgroundResource(R.color.rojoOscuro);

        } else if (id == R.id.bverde) {
            botones[2].setBackgroundResource(R.color.verdeOscuro);

        } else {
            botones[3].setBackgroundResource(R.color.amarilloOscuro);

        }
    }

    public void check(){
        int acertados=0;
        for(int i=0;i<numeros.length;i++){
            if(numeros[i]!=orden[i]){
                Toast.makeText(this, "Defeat", Toast.LENGTH_LONG).show();

            }else{
                acertados++;

            }
            if(acertados==4){
                Toast.makeText(this, "You Win.", Toast.LENGTH_LONG).show();

            }
            enabledPlay=false;
            pulsados=0;
            numeros=new int[4];
            orden=new int[4];

        }
    }
}

