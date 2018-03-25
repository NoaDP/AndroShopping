package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

//importamos las librerias necesarias para realizar la actividad
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
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

    //iniciamos la actividad
    protected void onCreate(Bundle savedInstanceState) {

        //cargamos el layout de la actividad
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdescription);

        //llamamos al intent que ha creado la pantalla para cargar la información del producto que se muestra
        //por pantalla
        Intent i = getIntent();

        //cargamos el nombre
        String nombre = getIntent().getStringExtra("PRODUCT_NAME");
        TextView producto = (TextView) findViewById(R.id.product);

        //mostramos el nombre del producto
        producto.setText(nombre);

        //cargamos el precio
        Integer precio = getIntent().getIntExtra("PRODUCT_PRIZE", 99);
        TextView precioProducto = (TextView) findViewById(R.id.prizeRes);

        //mostramos el precio del producto
        precioProducto.setText(String.valueOf(precio));

        //cargamos la descripcion del producto
        String descripcion = getIntent().getStringExtra("PRODUCT_DESC");
        TextView descProduct = (TextView) findViewById(R.id.decription);

        //muestra la descripcion del producto
        descProduct.setText(descripcion);

        //cargamos la descripcion del producto
        Integer img = getIntent().getIntExtra("PRODUCT_IMG", 000);
        ImageView imgProduct = (ImageView) findViewById(R.id.prodImg);

        //muestra la descripcion del producto
        imgProduct.setImageResource(img);


        //hacemos que la flecha de back haga la funcion back por defecto de android
        ImageView back = (ImageView) findViewById(R.id.backBar);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                onBackPressed();
            }
        });
    }
}
