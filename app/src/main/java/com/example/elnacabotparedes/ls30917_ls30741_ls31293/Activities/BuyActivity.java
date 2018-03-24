package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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

        ImageView back = (ImageView)findViewById(R.id.backBar);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                onBackPressed();
            }
        });

    }
}
