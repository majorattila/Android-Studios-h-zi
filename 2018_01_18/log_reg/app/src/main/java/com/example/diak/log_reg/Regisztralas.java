package com.example.diak.log_reg;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regisztralas extends AppCompatActivity {

    private Button btn_belepes, btn_regisztracio;
    private EditText idUserName, idPword, idFullName;

    private AdatbazisSegito myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisztralas);

        init();
        onClickListener();
    }

    public void init(){
        btn_regisztracio = (Button) findViewById(R.id.btn_regisztracio);

        idUserName = (EditText) findViewById(R.id.idUserName);
        idPword = (EditText) findViewById(R.id.idPword);
        idFullName = (EditText) findViewById(R.id.idFullName);

        myDb = new AdatbazisSegito(this);
    }

    public void onClickListener(){

        btn_regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adatRogzites();
            }
        });
    }

    private void adatRogzites()
    {

        String username = idUserName.getText().toString();
        String pword = idPword.getText().toString();
        String full_name = idFullName.getText().toString();
        if(!username.isEmpty() && !pword.isEmpty() && !full_name.isEmpty()){

            //sikeres-e az adatrögzítés?
            Boolean eredmeny = myDb.adatRogzites(username, pword, full_name);

            //Vissza jelzés kiíratása
            if(eredmeny){
                Toast.makeText(Regisztralas.this, "Adatrögzítés sikeres", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Regisztralas.this, "Adatrögzítés nem sikeres", Toast.LENGTH_SHORT).show();
            }

            //Vissza ugrás a Main_activity -re
            Intent adatfelvetel = new Intent(Regisztralas.this, MainActivity.class);
            startActivity(adatfelvetel);
            finish();
        }else{
            Toast.makeText(Regisztralas.this, "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
        }
    }
}
