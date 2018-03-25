package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

import java.io.Serializable;


//Clase producto se utiliza para almacenar toda la informacion necesaria para ser printada en los layout

public class ProductModel implements Serializable {
    String name;            // nombre del producto
    Integer prize;          // precio del producto
    String description;     // descripcion del producto
    Integer amount;         // cantidad del producto que quiere el cliente


    // constructor
    public ProductModel(String name, Integer prize, String description) {
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.amount = 0;
    }

    // recuperar el nombre del producto
    public String getName(){
        return this.name;
    }

    // recuperar el precio del producto
    public Integer getPrize(){
        return this.prize;
    }

    // recuperar la descripcion del producto
    public String getDescription() { return this.description; }

    // recuperar la cantidad del producto
    public Integer getAmount(){
        return this.amount;
    }

    // inicializar el parametro de amount que es la cantidad de ese producto
    public void setAmount(Integer amount){
        this.amount = amount;
    }

    // aumentar la cantidad del producto en concreto
    public void itemSelected() {
        this.amount ++;
    }
}
