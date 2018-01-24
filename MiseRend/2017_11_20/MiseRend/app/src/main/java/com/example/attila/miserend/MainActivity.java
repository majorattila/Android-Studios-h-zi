package com.example.attila.miserend;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.MainThread;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //private gomb tipus változót
    //activityel való összekötés
    //gombra hozzatok létre egy onclick eseményt

    private Button btn_bejovetel, btn_kyrie, btn_gloria, btn_zsoltar, btn_dicsoites, btn_felajanlas, btn_sanctus, btn_agnus_dei, btn_aldozas, btn_kimenetel;
    private TextView textView_bejovetel, textView_kyrie, textView_gloria, textView_zsoltar, textView_dicsoites, textView_felajanlas, textView_sanctus, textView_agnus_dei, textView_aldozas, textView_kimenetel;
    private AlertDialog.Builder kilepes;

    @Override
    public void onBackPressed()
    {
        kilepes.setTitle("Kilépés").show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onclickListener();
        kiir();
    }

    public void init(){
        textView_bejovetel = (TextView) findViewById(R.id.textView_bejovetel);
        textView_kyrie = (TextView) findViewById(R.id.textView_kyrie);
        textView_gloria = (TextView) findViewById(R.id.textView_gloria);
        textView_zsoltar = (TextView) findViewById(R.id.textView_zsoltar);
        textView_dicsoites = (TextView) findViewById(R.id.textView_dicsoites);
        textView_felajanlas = (TextView) findViewById(R.id.textView_felajanlas);
        textView_sanctus = (TextView) findViewById(R.id.textView_sanctus);
        textView_agnus_dei = (TextView) findViewById(R.id.textView_agnus_dei);
        textView_aldozas = (TextView) findViewById(R.id.textView_aldozas);
        textView_kimenetel = (TextView) findViewById(R.id.textView_kimenetel);

        btn_bejovetel = (Button) findViewById(R.id.btn_bejovetel);
        btn_kyrie = (Button) findViewById(R.id.btn_kyrie);
        btn_gloria = (Button) findViewById(R.id.btn_gloria);
        btn_zsoltar = (Button) findViewById(R.id.btn_zsoltar);
        btn_dicsoites = (Button) findViewById(R.id.btn_dicsoites);
        btn_felajanlas = (Button) findViewById(R.id.btn_felajanlas);
        btn_sanctus = (Button) findViewById(R.id.btn_sanctus);
        btn_agnus_dei = (Button) findViewById(R.id.btn_agnus_dei);
        btn_aldozas = (Button) findViewById(R.id.btn_aldozas);
        btn_kimenetel = (Button) findViewById(R.id.btn_kimenetel);
    }

    public void onclickListener() {

        btn_bejovetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "bejovetel");
                startActivity(gonext);
                finish();
            }
        });

        btn_kyrie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "kyrie");
                startActivity(gonext);
                finish();
            }
        });

        btn_gloria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "gloria");
                startActivity(gonext);
                finish();
            }
        });

        btn_zsoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "zsoltar");
                startActivity(gonext);
                finish();
            }
        });

        btn_dicsoites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "dicsoites");
                startActivity(gonext);
                finish();
            }
        });

        btn_felajanlas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "felajanlas");
                startActivity(gonext);
                finish();
            }
        });

        btn_sanctus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "sanctus");
                startActivity(gonext);
                finish();
            }
        });

        btn_agnus_dei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "agnus_dei");
                startActivity(gonext);
                finish();
            }
        });

        btn_aldozas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "aldozas");
                startActivity(gonext);
                finish();
            }
        });

        btn_kimenetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "kimenetel");
                startActivity(gonext);
                finish();
            }
        });


        this.kilepes = new AlertDialog.Builder(MainActivity.this);
        this.kilepes.setMessage("Biztosan ki akar lépni?");
        this.kilepes.setNegativeButton("Igen", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                finish();
            }
        });

        this.kilepes.setPositiveButton("Nem", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                init();
                onclickListener();
            }
        });
        this.kilepes.setCancelable(false);
        this.kilepes.create();
    }

    public void kiir(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String bejovetel = sharedPreferences.getString("bejovetel", "");
        textView_bejovetel.setText(bejovetel);

        String kyrie = sharedPreferences.getString("kyrie", "");
        textView_kyrie.setText(kyrie);

        String gloria = sharedPreferences.getString("gloria", "");
        textView_gloria.setText(gloria);

        String zsoltar = sharedPreferences.getString("zsoltar", "");
        textView_zsoltar.setText(zsoltar);

        String dicsoites = sharedPreferences.getString("dicsoites", "");
        textView_dicsoites.setText(dicsoites);

        String felajanlas = sharedPreferences.getString("felajanlas", "");
        textView_felajanlas.setText(felajanlas);

        String sanctus = sharedPreferences.getString("sanctus", "");
        textView_sanctus.setText(sanctus);

        String agnus_dei = sharedPreferences.getString("agnus_dei", "");
        textView_agnus_dei.setText(agnus_dei);

        String aldozas = sharedPreferences.getString("aldozas", "");
        textView_aldozas.setText(aldozas);

        String kimenetel = sharedPreferences.getString("kimenetel", "");
        textView_kimenetel.setText(kimenetel);
    }
}
