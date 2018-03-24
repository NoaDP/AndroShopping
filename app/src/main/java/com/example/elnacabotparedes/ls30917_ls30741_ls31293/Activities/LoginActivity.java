package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;


import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

public class LoginActivity extends AppCompatActivity {

    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        entrar = (Button) findViewById(R.id.entrar);

        entrar.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Open();
            }
        });
    }


    public void Open(){
        Intent intent = new Intent(this, BuyActivity.class);
        startActivity(intent);

    }
}
