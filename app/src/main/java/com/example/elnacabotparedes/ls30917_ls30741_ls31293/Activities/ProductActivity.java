package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;


import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;
/**
 * Created by noa on 23/3/18.
 */
public class ProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdescription);

        Intent i = getIntent();
        String nombre = getIntent().getStringExtra("PRODUCT_NAME");
        TextView producto =(TextView)findViewById(R.id.product);
        producto.setText(nombre);

        Integer precio = getIntent().getIntExtra("PRODUCT_PRIZE", 99);
        TextView precioProducto =(TextView)findViewById(R.id.prizeRes);
        precioProducto.setText(String.valueOf(precio));

        String descripcion = getIntent().getStringExtra("PRODUCT_DESC");
        TextView descProduct =(TextView)findViewById(R.id.decription);
        descProduct.setText(descripcion);

    }
}
