package com.example.diak.ittapirosholapiros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {

    @Override
    public void onBackPressed()
    {
        Intent vissza_menube = new Intent(Main4Activity.this, MainActivity.class);
        startActivity(vissza_menube);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
}
