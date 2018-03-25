package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import java.util.ArrayList;



public class ResumAdapter extends ArrayAdapter<CarritoModel> {

    private Context context;
    private ArrayList<CarritoModel> carrito;


    public ResumAdapter(Context context) {
        super(context, R.layout.layout_resum);
        this.carrito = new ArrayList<CarritoModel>();

    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if( row == null){

        }





        return row;
    }




}
