package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

/**
 * Created by noa on 23/3/18.
 */

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;


public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Escondemos la barra del titulo de la aplicacion
        getSupportActionBar().hide();

        // Inicializamos el timer de la aplicacion
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startApp();
                finish();
            }
        };
        // Ponemos el timer a 2000 para que tarde 2 segundos en cambiar de pantalla
        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }

    public void startApp (){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


}


