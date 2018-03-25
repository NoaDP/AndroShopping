package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

/**
 * Created by noa on 23/3/18.
 */

//cargamos los recursos necesarios para realizar la actividad
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

//creamos la clase
public class SplashActivity extends AppCompatActivity{

    @Override
    //inicializamos la clase
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // seleccionamos el layout que deseamos mostrar por pantalla
        setContentView(R.layout.activity_splash);

        // Escondemos la barra del titulo de la aplicacion
        getSupportActionBar().hide();

        // Inicializamos el timer de la aplicacion que realizara el cambio de actividad una vez transcurra
        //el tiempo definido en el timer, es decir, 2 segundos
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startApp();
                //matamos la ventana de splash
                finish();
            }
        };

        // Ponemos el timer a 2000 para que tarde 2 segundos en cambiar de pantalla
        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }

    //llamamos a la actividad de login para iniciar la app
    public void startApp (){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


}


