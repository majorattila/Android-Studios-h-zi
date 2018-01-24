package com.example.attila.miserend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button btn_mentes;
    private EditText edit_adat;

    @Override
    public void onBackPressed()
    {
        Intent vissza_menube = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(vissza_menube);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_mentes = (Button) findViewById(R.id.btn_mentes);
        edit_adat = (EditText) findViewById(R.id.edit_txt_1);

        String newString;
        Bundle extras = getIntent().getExtras();
        newString= extras.getString("ID");


        SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String str = sharedPreference.getString(newString+"", "");
        edit_adat.setText(str);

        btn_mentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();

                String newString;
                Bundle extras = getIntent().getExtras();
                newString= extras.getString("ID");

                /*
                if(extras == null) {
                    newString= null;
                } else {
                    newString= extras.getString("ID");
                }
                */

                editor.putString(newString, edit_adat.getText().toString());
                editor.commit();
                Intent vissza_menube = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(vissza_menube);
                Toast.makeText(Main2Activity.this, "Adat mentve!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
