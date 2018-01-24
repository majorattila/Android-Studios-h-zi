package com.example.diak.szamologep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button egy,ketto, harom, negy, ot, hat, het,
            nyolc, kilenc, nulla, osszeadas, kivonas, szorzas, osztas, vegeredmeny;

    private int memoria = 0;
    private EditText szam;
    private String szam2 = "";
    private int elso_szam = 0, masodik_szam = 0, eredmeny = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        egy = (Button) findViewById(R.id.button_egy);
        ketto = (Button) findViewById(R.id.button_ketto);
        harom = (Button) findViewById(R.id.button_harom);
        negy = (Button) findViewById(R.id.button_negy);
        ot = (Button) findViewById(R.id.button_ot);
        hat = (Button) findViewById(R.id.button_hat);
        het = (Button) findViewById(R.id.button_het);
        nyolc = (Button) findViewById(R.id.button_nyolc);
        kilenc = (Button) findViewById(R.id.button_kilenc);
        nulla = (Button) findViewById(R.id.button_nulla);
        osszeadas = (Button) findViewById(R.id.button_osszeadas);
        kivonas = (Button) findViewById(R.id.button_kivonas);
        szorzas = (Button) findViewById(R.id.button_szorzas);
        osztas = (Button) findViewById(R.id.button_osztas);
        vegeredmeny = (Button) findViewById(R.id.button_egyenlo);
        szam = (EditText) findViewById(R.id.editText_vegeredmeny);

        egy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "1";
                szam.setText("" + szam2);
            }
        });
        ketto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "2";
                szam.setText("" + szam2);
            }
        });
        harom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "3";
                szam.setText("" + szam2);
            }
        });
        negy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "4";
                szam.setText("" + szam2);
            }
        });
        ot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "5";
                szam.setText("" + szam2);
            }
        });
        hat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "6";
                szam.setText("" + szam2);
            }
        });
        het.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "7";
                szam.setText("" + szam2);
            }
        });
        nyolc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "8";
                szam.setText("" + szam2);
            }
        });
        kilenc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "9";
                szam.setText("" + szam2);
            }
        });
        nulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                szam2 += "0";
                szam.setText("" + szam2);
            }
        });
        osszeadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elso_szam = Integer.parseInt(szam2);
                memoria +=  Integer.parseInt(szam2);
                szam2 = "";
                szam.setText("");
            }
        });
        kivonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elso_szam = Integer.parseInt(szam2);
                szam.setText("");
            }
        });
        szorzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elso_szam = Integer.parseInt(szam2);
                szam.setText("");
            }
        });
        osztas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elso_szam = Integer.parseInt(szam2);
                szam.setText("");
            }
        });
        vegeredmeny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elso_szam = Integer.parseInt(szam2);
                szam.setText(memoria+"");
            }
        });


    }
}
