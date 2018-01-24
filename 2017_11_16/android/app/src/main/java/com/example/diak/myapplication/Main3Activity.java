package com.example.diak.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private Button btn_mentes;
    private EditText edit_adat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn_mentes = (Button) findViewById(R.id.btn_mentes);
        edit_adat = (EditText) findViewById(R.id.edit_txt_1);

        btn_mentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString("name", edit_adat.getText().toString());
                editor.commit();
                Intent vissza_menube = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(vissza_menube);
                Toast.makeText(Main3Activity.this, "Adat mentve!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
