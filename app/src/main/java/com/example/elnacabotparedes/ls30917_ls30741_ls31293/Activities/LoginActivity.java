package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.UserModel;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

public class LoginActivity extends AppCompatActivity {

    private UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        Button entrar = (Button) findViewById(R.id.entrar);
        datosUsuario();

        entrar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  EditText iemail = (EditText)findViewById(R.id.introemail);
                  String email = iemail.getText().toString();
                  EditText ipassword = (EditText)findViewById(R.id.intropassword);
                  String password = ipassword.getText().toString();

                  if(email.equals(userModel.getUsername()) && password.equals(userModel.getPassword())){
                      Open();
                  }else{
                      Toast toast = Toast.makeText(getApplicationContext(), "FUNCIONA", Toast.LENGTH_SHORT);
                      toast.show();
                  }
              }
        });
    }


    private void datosUsuario(){
        userModel = new UserModel("admin@salleurl.edu", "qwerty123");
    }

    public void Open(){
        Intent intent = new Intent(this, BuyActivity.class);
        startActivity(intent);

    }

}
