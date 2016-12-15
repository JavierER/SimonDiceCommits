package com.example.javii.simondicecommit;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start;
    Handler display1 = new Handler();
    Handler display2 = new Handler();
    Button[] botones;

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
    }

    public void Click(View v) {
        int posicion;
        int id = v.getId();
        final Button b = (Button) v;

        if (id == R.id.bazul) {
            v.setBackgroundResource(R.color.azulOscuro);
            posicion = 0;

        } else if (id == R.id.brojo) {
            v.setBackgroundResource(R.color.rojoOscuro);
            posicion = 1;

        } else if (id == R.id.bverde) {
            v.setBackgroundResource(R.color.verdeOscuro);
            posicion = 2;

        } else {
            v.setBackgroundResource(R.color.amarilloOscuro);
            posicion = 3;
        }
    }
}

