package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

import java.io.Serializable;


//Clase producto se utiliza para almacenar toda la informacion necesaria para ser printada en los layout

public class ProductModel implements Serializable {
    private String name;            // nombre del producto
    private Integer prize;          // precio del producto
    private String description;     // descripcion del producto
    private Integer amount;         // cantidad del producto que quiere el cliente
    private Integer imgpath;        // imagen del producto

    // constructor
    public ProductModel(String name, Integer prize, String description, Integer imgpath) {
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.amount = 0;
        this.imgpath = imgpath;
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

    // recupera la imagen del producto
    public Integer getImage() {return this.imgpath; }

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
