package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.ListView;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.ProductAdapter;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.ProductModel;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import java.io.Serializable;
import java.util.List;


public class BuyActivity extends AppCompatActivity {

    public static ProductAdapter productAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        // Creamos el listview y le añadimos nuestro adapter customizado
        ListView listView = (ListView)findViewById(R.id.listView);
        productAdapter = new ProductAdapter(this);
        listView.setAdapter(productAdapter);

        // Da la funcionalidad al boton de back de la esquina superior izquierda
        ImageView back = (ImageView)findViewById(R.id.backBar);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                onBackPressed();
            }
        });

        // Da funcionalidad al boton de comprar
        Button buyButton = (Button)findViewById(R.id.buy);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un intent para ir a la siguiente actividad
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                List<ProductModel> products = productAdapter.getBoughtProducts();
                // Envia la lista de productos seleccionados por el usuario a la siguiente actividad
                intent.putExtra("PRODUCTS", (Serializable) products);
                startActivity(intent);
            }
        });
    }

    public void DestroyList() {
        super.onResume();
        // Vacia el carrito al volver a esta actividad.
        productAdapter.resetProducts();
    }
}
