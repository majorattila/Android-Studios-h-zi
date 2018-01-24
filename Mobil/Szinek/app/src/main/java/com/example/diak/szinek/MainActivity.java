package com.example.diak.szinek;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity {

    private Button button_piros;
    private Button button_sarga;
    private Button button_zold;
    private Button button_kek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_piros = (Button) findViewById(R.id.button_piros);
        button_sarga = (Button) findViewById(R.id.button_sarga);
        button_zold = (Button) findViewById(R.id.button_zold);
        button_kek = (Button) findViewById(R.id.button_kek);

        button_piros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = ((ColorDrawable)button_piros.getBackground()).getColor();
                button_piros.setBackgroundColor(((ColorDrawable)getWindow().getDecorView().getBackground()).getColor());
                getWindow().getDecorView().setBackgroundColor(color);
            }
        });

        button_sarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = ((ColorDrawable)button_sarga.getBackground()).getColor();
                button_sarga.setBackgroundColor(((ColorDrawable)getWindow().getDecorView().getBackground()).getColor());
                getWindow().getDecorView().setBackgroundColor(color);
            }
        });

        button_zold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = ((ColorDrawable)button_zold.getBackground()).getColor();
                button_zold.setBackgroundColor(((ColorDrawable)getWindow().getDecorView().getBackground()).getColor());
                getWindow().getDecorView().setBackgroundColor(color);
            }
        });

        button_kek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = ((ColorDrawable)button_kek.getBackground()).getColor();
                button_kek.setBackgroundColor(((ColorDrawable)getWindow().getDecorView().getBackground()).getColor());
                getWindow().getDecorView().setBackgroundColor(color);
            }
        });
    }


}
