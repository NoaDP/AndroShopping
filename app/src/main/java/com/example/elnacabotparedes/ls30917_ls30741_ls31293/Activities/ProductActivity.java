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
        setContentView(R.layout.activity_product);

        String name = getIntent().getStringExtra("PRODUCT_NAME");
        TextView product =(TextView)findViewById(R.id.product);
        product.setText(name);

        Integer prize = getIntent().getIntExtra("PRODUCT_PRIZE", 99);
        TextView productPrize =(TextView)findViewById(R.id.prizeRes);
        productPrize.setText(String.valueOf(prize).concat(" €"));

        String description = getIntent().getStringExtra("PRODUCT_DESC");
        TextView productDescription =(TextView)findViewById(R.id.decription);
        productDescription.setText(description);

    }
}
