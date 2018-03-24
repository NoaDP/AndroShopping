package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.AppCompatActivity;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

public class LoginActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Button b = (Button)findViewById(R.id.entrar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText iemail = (EditText)findViewById(R.id.introemail);
                String email = iemail.getText().toString();

                if(email.equals("hola")){
                    //INTENT
                }else{

                    Toast toast = Toast.makeText(getApplicationContext(), "FUNCIONA", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });



    }




}
