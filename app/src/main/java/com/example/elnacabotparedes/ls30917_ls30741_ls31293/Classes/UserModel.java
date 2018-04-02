package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;


//Clase UserModel para guardar la informacion del usuario para que se pueda iniciar sesion

public class UserModel {
    private String username;   // campo del email (admin@salleurl.edu)
    private String password;   // campo de la contraseña (qwerty123)

    //constuctor
    public UserModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    //recuperar el nombre usuario
    public String getUsername(){
        return this.username;
    }

    //recuperar el la contraseña
    public String getPassword(){
        return this.password;
    }


}
