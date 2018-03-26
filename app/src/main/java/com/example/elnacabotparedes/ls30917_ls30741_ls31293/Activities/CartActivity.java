package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.CartAdapter;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.ProductModel;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private Integer totalPrize = 0;
    private List<ProductModel> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ListView listView = (ListView)findViewById(R.id.listView);

        // Atrapa la lista de productos lanzada desde la aactividad anterior
        products = (ArrayList<ProductModel>) getIntent().getSerializableExtra("PRODUCTS");

        // Añadimos el adapter pertinente al listview
        CartAdapter cartAdapter = new CartAdapter(getApplicationContext(), (ArrayList<ProductModel>) products);
        listView.setAdapter(cartAdapter);

        // Acumula el precio total de los items comprados
        for (ProductModel item : products){
            totalPrize = totalPrize + item.getAmount() * item.getPrize();
        }

        // Pone el precio total acumulado en la pantalla
        TextView accumulated = (TextView)findViewById(R.id.accumulated);
        accumulated.setText(totalPrize.toString().concat(" €"));

        // Da funcionalidad al boton para finalizar la compra
        Button acceptButton = (Button)findViewById(R.id.accept);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!products.isEmpty()) {
                    // Si hay productos en el carrito y se pulsa el boton, lanza un toast
                    String text = getApplicationContext().getString(R.string.success_buy);
                    Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                    products.clear();
                } else {
                    // Si no hay productos en el carrito y se pulsa el boton, lanza un toast diferente
                    String text = getApplicationContext().getString(R.string.no_products_buy);
                    Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                }
                finish();
            }
        });

        ImageView back = (ImageView)findViewById(R.id.backBar);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                onBackPressed();
            }
        });
    }
}
