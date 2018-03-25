package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        Button enterButton = (Button) findViewById(R.id.entrar);
        fillUserData();

        enterButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  EditText iemail = (EditText)findViewById(R.id.introemail);
                  String email = iemail.getText().toString();
                  EditText ipassword = (EditText)findViewById(R.id.intropassword);
                  String password = ipassword.getText().toString();


                  if(email.equals(userModel.getUsername()) && password.equals(userModel.getPassword())){
                      Open();
                  }else{
                      controlErrores(email,password);
                  }
              }
        });
    }

    private void fillUserData(){
        userModel = new UserModel("admin@salleurl.edu", "qwerty123");
    }

    public void Open(){
        Intent intent = new Intent(this, BuyActivity.class);
        startActivity(intent);
    }

    public void controlErrores(String email, String password){
        if(email.length() != 0) {  // comprueba que han llenado el campo de email
            if( password.length() != 0){  // comprueba que han llenado el campo de password
                if (password.length() < 6) {  // comprueba que el tamaño de la contraseña sea de minimo 6
                    String text = getResources().getString(R.string.error_caracters);
                    Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                    toast.show();
                } else {  // hay error tanto en el email como en el password ( error general)
                    String text = getResources().getString(R.string.error_general);
                    Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                    toast.show();
                }
            }else{
                String text = getResources().getString(R.string.error_password);
                Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                toast.show();
            }
        }else{
            String text = getResources().getString(R.string.error_email);
            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
