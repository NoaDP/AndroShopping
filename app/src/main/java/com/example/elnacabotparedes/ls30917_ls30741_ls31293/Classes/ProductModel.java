package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

/**
 * Created by diego on 23/03/2018.
 */

public class ProductModel {
    String name;
    Integer prize;

    public ProductModel(String name, Integer prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName(){
        return this.name;
    }

    public Integer getPrize(){
        return this.prize;
    }
}
