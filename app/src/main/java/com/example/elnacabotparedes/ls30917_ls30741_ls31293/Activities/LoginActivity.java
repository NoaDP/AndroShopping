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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private UserModel userModel;
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Esta linia permite quitar el actionBar
        getSupportActionBar().hide();

        // recuperamos  el boton enter
        Button enterButton = (Button) findViewById(R.id.entrar);
        fillUserData();

        // controlamos la accion de la ventana a partir de que se clica el 'entrar'
        enterButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  // recuperamos la informacion tanto en el campo de email, como de contraseña
                  EditText iemail = (EditText)findViewById(R.id.introemail);
                  String email = iemail.getText().toString();
                  EditText ipassword = (EditText)findViewById(R.id.intropassword);
                  String password = ipassword.getText().toString();

                  // comprobamos si ha introducido correctamente el email y la contraseña
                  if(email.equals(userModel.getUsername()) && password.equals(userModel.getPassword())){
                      // funcion que nos deriva a la pagina de buyActivity
                      Open();
                  }else{
                      // funcion que controla errores a la hora de iniciar sesion
                      errorsMessage(email,password);
                  }
              }
        });
    }


    // Funcion que rellena la clase userModel con los parametros que son necesarios del usuario
    private void fillUserData(){
        userModel = new UserModel("admin@salleurl.edu", "qwerty123");
    }


    // Funcion que se realiza si el usuario ha entrado con los datos correctos.
    // Conduce a la siguiente actividad que es BuyActivity
    public void Open(){
        Intent intent = new Intent(this, BuyActivity.class);
        startActivity(intent);
    }


    // Funcion que controla posibles erroes a la hora de introducir email y contraseña
    public void errorsMessage(String email, String password){

        // comprueba que han llenado el campo de email
        if(email.length() != 0) {

            //comprueba el formato del email sea el correcto (ejemplo@dominio.com)
            if(validateEmail(email)){

                // comprueba que han llenado el campo de password
                if( password.length() != 0){

                    // comprueba que el tamaño de la contraseña sea de minimo 6
                    if (password.length() < 6) {

                        // Cogemos la el parametro de string.xml para el mensaje correspondiente
                        String text = getResources().getString(R.string.error_caracters);
                        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        // Hay error tanto en el email como en el password ( error general)
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
                String text = getResources().getString(R.string.error_format);
                Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
                toast.show();
            }
        }else{
            String text = getResources().getString(R.string.error_email);
            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    //valida el email con el formato correcto
    public boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
