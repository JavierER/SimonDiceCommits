package com.example.javii.simondicecommit;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start;
    Handler display1=new Handler();
    Handler display2=new Handler();
    Button[]botones;

    int numeros[];
    int orden[];
    int pulsados=0;
    private int tiempoEncendido=600;
    private int tiempoApagado=1200;
    boolean enabledPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
