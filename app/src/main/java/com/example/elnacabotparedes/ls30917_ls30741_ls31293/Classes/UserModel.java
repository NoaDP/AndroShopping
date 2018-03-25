package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

/**
 * Created by elnacabotparedes on 24/3/18.
 */

public class UserModel {
    String username;
    String password;

    public UserModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }


}
