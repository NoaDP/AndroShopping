package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

public class LoginActivity extends AppCompatActivity {

    Button entrar;
    String email;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        entrar = (Button) findViewById(R.id.entrar);

        entrar.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                EditText iemail = (EditText)findViewById(R.id.introemail);
                email = iemail.getText().toString();
                EditText ipassword = (EditText)findViewById(R.id.intropassword);
                password = ipassword.getText().toString();

                if(email.equals("admin@salleurl.edu") && password.equals("qwerty123")){
                    Open();
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(), "FUNCIONA", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
    
    public void Open(){
        Intent intent = new Intent(this, BuyActivity.class);
        startActivity(intent);

    }
}
