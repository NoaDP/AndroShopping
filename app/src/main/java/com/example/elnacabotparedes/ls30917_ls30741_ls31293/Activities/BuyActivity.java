package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.CarritoModel;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.CustomAdapter;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

/**
 * Created by diego on 23/03/2018.
 */

public class BuyActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        ListView listView = (ListView)findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter(this.getApplicationContext());

        listView.setAdapter(customAdapter);

    }






}
