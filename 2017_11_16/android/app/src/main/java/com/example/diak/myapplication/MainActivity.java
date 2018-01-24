package com.example.diak.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //private gomb tipus változót
    //activityel való összekötés
    //gombra hozzatok létre egy onclick eseményt

    private Button btn_next, btn_mentes, btn_inform, btn_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onclickListener();
    }

    public void init(){
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_mentes = (Button) findViewById(R.id.btn_save);
        btn_inform = (Button) findViewById(R.id.btn_inform);
        btn_exit = (Button) findViewById(R.id.btn_exit);
    }

    public void onclickListener() {

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(gonext);
                finish();
            }
        });

        btn_mentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gosave = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(gosave);
                finish();
            }
        });

        btn_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                String informacio = sharedPreferences.getString("name", "");
                Toast.makeText(MainActivity.this, "SharedPreference adta: " + informacio, Toast.LENGTH_SHORT).show();
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
