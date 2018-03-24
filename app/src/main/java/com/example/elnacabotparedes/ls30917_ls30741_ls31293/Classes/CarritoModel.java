package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

import android.widget.ArrayAdapter;



public class CarritoModel{
    String name;
    Integer precio;
    Integer cantidad;


    public CarritoModel(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
