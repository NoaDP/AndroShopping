package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.CarritoModel;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes.ResumAdapter;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import java.util.ArrayList;

public class ResumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resum);

        ListView listView = (ListView)findViewById(R.id.listView);


        ResumAdapter resumAdapter = new ResumAdapter(getApplicationContext());
        listView.setAdapter(resumAdapter);

    }
}
