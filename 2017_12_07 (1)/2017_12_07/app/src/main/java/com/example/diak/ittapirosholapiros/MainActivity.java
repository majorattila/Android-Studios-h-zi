package com.example.diak.ittapirosholapiros;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_start, btn_settings, btn_info;
    private TextView textView_bejovetel, textView_kyrie, textView_gloria, textView_zsoltar, textView_dicsoites, textView_felajanlas, textView_sanctus, textView_agnus_dei, textView_aldozas, textView_kimenetel;
    private AlertDialog.Builder kilepes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onclickListener();
    }

    public void init(){
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_settings = (Button) findViewById(R.id.btn_settings);
        btn_info = (Button) findViewById(R.id.btn_info);
    }

    public void onclickListener() {

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gonext = new Intent(MainActivity.this, Main2Activity.class);
                gonext.putExtra("ID", "bejovetel");
                startActivity(gonext);
                finish();
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gonext = new Intent(MainActivity.this, Main3Activity.class);
                gonext.putExtra("ID", "kyrie");
                startActivity(gonext);
                finish();
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gonext = new Intent(MainActivity.this, Main4Activity.class);
                gonext.putExtra("ID", "gloria");
                startActivity(gonext);
                finish();
            }
        });
    }
}
