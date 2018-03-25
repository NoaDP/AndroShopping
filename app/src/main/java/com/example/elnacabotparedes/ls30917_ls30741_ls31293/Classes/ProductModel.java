package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

import java.io.Serializable;

/**
 * Created by diego on 23/03/2018.
 */

public class ProductModel implements Serializable {
    String name;
    Integer prize;
    String description;
    Integer amount;
    Integer imgpath;

    public ProductModel(String name, Integer prize, String description, Integer imgpath) {
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.amount = 0;
        this.imgpath = imgpath;
    }

    public String getName(){
        return this.name;
    }

    public Integer getPrize(){
        return this.prize;
    }

    public String getDescription() { return this.description; }

    public Integer getImage() {return this.imgpath; }

    public Integer getAmount(){
        return this.amount;
    }

    public void setAmount(Integer amount){
        this.amount = amount;
    }

    public void itemSelected() {
        this.amount ++;
    }
}
