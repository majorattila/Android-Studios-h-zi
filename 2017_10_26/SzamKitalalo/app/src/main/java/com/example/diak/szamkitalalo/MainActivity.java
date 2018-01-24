package com.example.diak.szamkitalalo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.R.drawable.btn_star_big_off;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlus1, buttonPlus10, buttonMinus1, buttonMinus10, buttonTippel;
    private TextView textViewErtek;

    private ImageView imgV1,imgV2,imgV3,imgV4,imgV5,imgV6,imgV7;

    private int ertek;
    private int gondoltSzam;
    private int probalkozasokSzama;

    private AlertDialog.Builder szeretneUjJatekot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
        ujJatek();

    }


    private void ujJatek(){
        Random rnd = new Random();
        gondoltSzam = rnd.nextInt(101);

        Toast.makeText(getApplicationContext(),
                gondoltSzam + "",
                Toast.LENGTH_LONG).show();

        this.ertek = 50;
        this.textViewErtek.setText(ertek + "");

        probalkozasokSzama = 7;

    }

    private void lekapcsol(int i){
        switch (i){
            case 7: imgV7.setImageResource(btn_star_big_off);  break;
            case 6: imgV6.setImageResource(btn_star_big_off);  break;
            case 5: imgV5.setImageResource(btn_star_big_off);  break;
            case 4: imgV4.setImageResource(btn_star_big_off);  break;
            case 3: imgV3.setImageResource(btn_star_big_off);  break;
            case 2: imgV2.setImageResource(btn_star_big_off);  break;
            case 1: imgV1.setImageResource(btn_star_big_off);  break;
        }
    }


    private void Init(){
        this.buttonMinus1 = (Button)findViewById(R.id.buttonMinus);
        this.buttonMinus10 = (Button)findViewById(R.id.buttonMinus10);
        this.buttonPlus1 = (Button)findViewById(R.id.buttonPlus);
        this.buttonPlus10 = (Button)findViewById(R.id.buttonPlus10);
        this.buttonTippel = (Button)findViewById(R.id.buttonTippel);

        this.imgV1 = (ImageView)findViewById(R.id.imageView);
        this.imgV2 = (ImageView)findViewById(R.id.imageView2);
        this.imgV3 = (ImageView)findViewById(R.id.imageView3);
        this.imgV4 = (ImageView)findViewById(R.id.imageView4);
        this.imgV5 = (ImageView)findViewById(R.id.imageView5);
        this.imgV6 = (ImageView)findViewById(R.id.imageView6);
        this.imgV7 = (ImageView)findViewById(R.id.imageView7);

        this.textViewErtek = (TextView)findViewById(R.id.textViewSzam);

        this.buttonMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOnClick(v,-1);
            }
        });

        this.buttonMinus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOnClick(v,-10);
            }
        });

        this.buttonPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOnClick(v,1);
            }
        });

        this.buttonPlus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonOnClick(v,10);
            }
        });

        this.buttonTippel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eltaltaE()){
                    szeretneUjJatekot.setTitle("Gratulálunk, eltaláltad").show();
                }else{
                    if (probalkozasokSzama > 0){
                        lekapcsol(probalkozasokSzama--);
                    }else{
                        szeretneUjJatekot.setTitle("Luzer, nem nyert!").show();
                    }

                }
            }
        });

        this.szeretneUjJatekot = new AlertDialog.Builder(MainActivity.this);
        this.szeretneUjJatekot.setMessage("Szeretnél még egyet játszani?");
        this.szeretneUjJatekot.setNegativeButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ujJatek();
            }
        });
        this.szeretneUjJatekot.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        this.szeretneUjJatekot.setCancelable(false);
        this.szeretneUjJatekot.create();
    }

    private boolean eltaltaE(){
        if (gondoltSzam < ertek){
            Toast.makeText(getApplicationContext(),
                    "Kisebb számra gondoltam!",
                    Toast.LENGTH_SHORT).show();
        }else if (gondoltSzam > ertek){
            Toast.makeText(getApplicationContext(),
                    "Nagyobb számra gondoltam!",
                    Toast.LENGTH_SHORT).show();
        }else{ //talalat van!!!
            return true;
        }
        return false;
    }


    public void buttonOnClick(View v, int i){
        int lehetsegesErtek = ertek + i;
        if (lehetsegesErtek < 0){
            Toast.makeText(getApplicationContext(),
                    "Az érték nem lehet kisebb mint 0",
                    Toast.LENGTH_SHORT).show();
        }else if (lehetsegesErtek > 100){
            Toast.makeText(getApplicationContext(),
                    "Az érték nem lehet nagyobb mint 100",
                    Toast.LENGTH_SHORT).show();
        }else{
            ertek = lehetsegesErtek;
        }
        textViewErtek.setText(ertek+"");
    }

}
