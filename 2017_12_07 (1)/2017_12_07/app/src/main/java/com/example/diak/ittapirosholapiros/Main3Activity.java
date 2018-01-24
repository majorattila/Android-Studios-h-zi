package com.example.diak.ittapirosholapiros;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    Button btn_easy, btn_medium, btn_hard, btn_magyar, btn_francia;

    @Override
    public void onBackPressed()
    {
        Intent vissza_menube = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(vissza_menube);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
        onClickListener();
    }

    public void init(){
        btn_easy = (Button) findViewById(R.id.btn_easy);
        btn_medium = (Button) findViewById(R.id.btn_medium);
        btn_hard = (Button) findViewById(R.id.btn_hard);
        btn_magyar = (Button) findViewById(R.id.btn_magyar);
        btn_francia = (Button) findViewById(R.id.btn_francia);
    }

    public void onClickListener()
    {
        btn_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString("level", "easy");
                editor.commit();
            }
        });

        btn_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString("level", "medium");
                editor.commit();
            }
        });

        btn_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString("level", "hard");
                editor.commit();
            }
        });

        btn_magyar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString("card", "magyar");
                editor.commit();
            }
        });

        btn_francia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString("card", "french");
                editor.commit();
            }
        });
    }
}
