package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.ProductAdapter;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.ProductModel;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import java.io.Serializable;
import java.util.List;

/**
 * Created by diego on 23/03/2018.
 */

public class BuyActivity extends AppCompatActivity {

    private ProductAdapter productAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        ListView listView = (ListView)findViewById(R.id.listView);

        productAdapter = new ProductAdapter(this.getApplicationContext());

        listView.setAdapter(productAdapter);

        Button buyButton = (Button)findViewById(R.id.buy);

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                List<ProductModel> products = productAdapter.getBoughtProducts();
                intent.putExtra("PRODUCTS", (Serializable) products);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        productAdapter.resetProducts();
    }
}
