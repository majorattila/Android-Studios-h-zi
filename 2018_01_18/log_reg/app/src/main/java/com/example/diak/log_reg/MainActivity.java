package com.example.diak.log_reg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btn_belepes, btn_regisztracio;
    private EditText idUserName, idPword;

    private AdatbazisSegito myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onClickListener();
    }

    public void init(){
        btn_belepes = (Button) findViewById(R.id.btn_belepes);
        btn_regisztracio = (Button) findViewById(R.id.btn_regisztracio);

        idUserName = (EditText) findViewById(R.id.idUserName);
        idPword = (EditText) findViewById(R.id.idPword);

        myDb = new AdatbazisSegito(this);
    }

    public void onClickListener(){

        btn_belepes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btn_regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent
                Intent adatfelvetel = new Intent(MainActivity.this, Regisztralas.class);
                startActivity(adatfelvetel);
                finish();
            }
        });
    }
/*
    public void adatLekerdezes(){
        Cursor result = myDb.adatLekerdezes();
        StringBuffer stringBuffer = new StringBuffer();
        if(result!=null && result.getCount()>0){
            while(result.moveToNext()){ //addig csinálja, amíg tart a dolog
                //KIÍRATÁS
                stringBuffer.append("ID: " + result.getString(0) + "\n");
                stringBuffer.append("Keresztnev: " + result.getString(1) + "\n");
                stringBuffer.append("Vezeteknev: " + result.getString(2) + "\n");
                stringBuffer.append("Jegy: " + result.getString(3) + "\n");
            }
            //txtV_eredmeny.setText(stringBuffer.toString());
            Toast.makeText(MainActivity.this, "Adat sikeresen lekérve", Toast.LENGTH_SHORT).show();
        }
    }
*/
    public void login(){
        String username = idUserName.getText().toString();
        String pword = idPword.getText().toString();

        Boolean eredmeny = myDb.login(username, pword);

        if(eredmeny){
            Toast.makeText(MainActivity.this,"Adat sikeresen lekérve!", Toast.LENGTH_SHORT).show();

            SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreference.edit();
            editor.putString("name", myDb.get_fullname(username));
            editor.commit();

            //intent
            Intent welcome = new Intent(MainActivity.this, Welcome.class);
            startActivity(welcome);
            finish();
        }else{
            Toast.makeText(MainActivity.this,"Hibás felhasználónév vagy jelszó!", Toast.LENGTH_SHORT).show();
        }
    }
}
