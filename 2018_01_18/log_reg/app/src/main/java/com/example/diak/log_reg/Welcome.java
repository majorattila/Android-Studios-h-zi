package com.example.diak.log_reg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    private TextView lblWelcome;
    private Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Init();
        OnClickListener();
    }

    public void echoUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String fullname = sharedPreferences.getString("name", "");
        lblWelcome.setText("Üdvözöllek: " + fullname);
    }

    public void Init(){
        lblWelcome = (TextView) findViewById(R.id.lblWelcome);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
    }

    public void OnClickListener(){
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();

                editor.remove("name");
                editor.clear();
                editor.commit();

                //intent
                Intent main = new Intent(Welcome.this, MainActivity.class);
                startActivity(main);
                finish();
            }
        });
    }
}
