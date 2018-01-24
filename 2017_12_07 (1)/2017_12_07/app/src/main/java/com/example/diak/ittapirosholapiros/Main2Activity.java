package com.example.diak.ittapirosholapiros;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Main2Activity extends AppCompatActivity {

    Button btn_card_one, btn_card_two, btn_card_three;
    TextView textView_nyeremeny;

    private Animation beforgat, kiforgat, fadeout;
    CountDownTimer timer;

    int nyeremeny;

    String[] kartyak = new String[3];
    Random rnd = new Random();

    boolean timer_check = false;
    boolean check_timer_is_on = false;

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

        init();
        onclickListener();
        jatek_kezdese();
    }

    public void kartya_general()
    {

        this.kartyak = new String[]{"karo_asz", "pikk_tizes", "treff_kettes"};

        SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String str = sharedPreference.getString("card", "");

        if(str.equals("francia")){

            boolean piros_check = false;

            for (int i = 0; i < 3; i++) {
                boolean check_do_while = false; //ez azt adja vissza, hogy lefutott-e már a ciklus
                do{

                    kartyak[i] = "";

                    int val = rnd.nextInt(52);

                    if (val < 13) { //csak hamis, azaz csak olyan esetben fut le, mikor még nincs piros
                        kartyak[i] = "karo_";
                        piros_check = true;
                    } else if (val < 26) {
                        val -= 13;
                        kartyak[i] = "kor_";
                        piros_check = true;
                    } else if (val < 39) {
                        val -= 26;
                        kartyak[i] = "pikk_";
                    } else if (val < 52) {
                        val -= 39;
                        kartyak[i] = "treff_";
                    }

                    switch(val) //lényegtelen, hogy beállítja, mert hibás esetben úgy is felülírom
                    {
                        case 0: kartyak[i] += "asz"; break;
                        case 1: kartyak[i] += "kettes"; break;
                        case 2: kartyak[i] += "harmas"; break;
                        case 3: kartyak[i] += "negyes"; break;
                        case 4: kartyak[i] += "otos"; break;
                        case 5: kartyak[i] += "hatos"; break;
                        case 6: kartyak[i] += "hetes"; break;
                        case 7: kartyak[i] += "nyolcas"; break;
                        case 8: kartyak[i] += "kilences"; break;
                        case 9: kartyak[i] += "tizes"; break;
                        case 10: kartyak[i] += "bubi"; break;
                        case 11: kartyak[i] += "dama"; break;
                        case 12: kartyak[i] += "kiraly"; break;
                    }

                    check_do_while = true;

                }while(!piros_check); //addig megy, amíg nem lesz minimum egy piros - vagis amíg a piros_check negativ

            }

        }else{
            //pakli_merete = 2342352;
        }

    }

    public int hol_a_piros(){

        int ind = 0;
        for(int i = 0; i < this.kartyak.length; i++){
            if(this.kartyak[i].substring(0,4).equals("karo") || this.kartyak[i].substring(0,4).equals("kor_")){
                ind = i;
            }
        }
        return ind;
    }

    public void jatek_kezdese()
    {
        if(check_timer_is_on){
            timer.cancel();
        }

        //pénz kinyerése
        this.nyeremeny = Integer.parseInt(textView_nyeremeny.getText()+"");

        //kezdeti értékek beállítása
        kartya_general();

        //kezdő animáció

        //első körön vissza cserélem a kezdeti állapotba a képeket
        int resId = getResources().getIdentifier(kartyak[0], "drawable", getPackageName());

        switch(hol_a_piros()){
            case 0:
                btn_card_one.setBackgroundResource(resId);
                btn_card_two.setBackground(getResources().getDrawable(R.drawable.hatlap));
                btn_card_three.setBackground(getResources().getDrawable(R.drawable.hatlap));
            break;
            case 1:
                btn_card_one.setBackground(getResources().getDrawable(R.drawable.hatlap));
                resId = getResources().getIdentifier(kartyak[1], "drawable", getPackageName());
                btn_card_two.setBackgroundResource(resId);
                btn_card_three.setBackground(getResources().getDrawable(R.drawable.hatlap));
                break;
            case 2:
                btn_card_one.setBackground(getResources().getDrawable(R.drawable.hatlap));
                btn_card_two.setBackground(getResources().getDrawable(R.drawable.hatlap));
                resId = getResources().getIdentifier(kartyak[2], "drawable", getPackageName());
                btn_card_three.setBackgroundResource(resId);
                break;
        }
/*

        //a második fázisban pedig megforgatom a képeket
        switch(hol_a_piros()) {
            case 0:
                megfordit(1);
                btn_card_one.setBackground(getResources().getDrawable(R.drawable.hatlap));
                break;
            case 1:
                megfordit(2);
                btn_card_two.setBackground(getResources().getDrawable(R.drawable.hatlap));
                break;
            case 2:
                megfordit(3);
                btn_card_three.setBackground(getResources().getDrawable(R.drawable.hatlap));
                break;
        }
*/

        //pakli keverése
        timer = new CountDownTimer(Long.MAX_VALUE, 1000) {
            public void onTick(long millisUntilFinished) {
                mozgat(rnd.nextInt(3), rnd.nextInt(3));

                Context context = getApplicationContext();
                CharSequence text = kartyak[1];
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                check_timer_is_on = true;
            }

            public void onFinish() {

            }
        };

        timer.start();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 2 seconds
                timer.cancel();
                check_timer_is_on = false;
            }
        }, 5000);

    }

    public void init(){
        btn_card_one = (Button) findViewById(R.id.btn_card_one);
        btn_card_two = (Button) findViewById(R.id.btn_card_two);
        btn_card_three = (Button) findViewById(R.id.btn_card_three);

        textView_nyeremeny = (TextView) findViewById(R.id.textView_nyeremeny);

        beforgat = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.beforgat);
        kiforgat = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.kiforgat);
        fadeout = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.fade_out);
    }

    public void onclickListener() {

        btn_card_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_kartya(0)){
                    SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                    String str = sharedPreference.getString("level", "");

                    int bonus = 0;

                    if(str.equals("easy")){
                        bonus = 50;
                    }else if(str.equals("medium")){
                        bonus = 100;
                    }else{
                        bonus = 200;
                    }

                    textView_nyeremeny.setText((nyeremeny+bonus) + "");
                    megfordit(1);
                    jatek_kezdese();
                }
            }
        });

        btn_card_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_kartya(1)){
                    SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                    String str = sharedPreference.getString("level", "");

                    int bonus = 0;

                    if(str.equals("easy")){
                        bonus = 50;
                    }else if(str.equals("medium")){
                        bonus = 100;
                    }else{
                        bonus = 200;
                    }

                    textView_nyeremeny.setText((nyeremeny+bonus) + "");
                    megfordit(2);
                    jatek_kezdese();
                }
            }
        });

        btn_card_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_kartya(2)){
                    SharedPreferences sharedPreference = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                    String str = sharedPreference.getString("level", "");

                    int bonus = 0;

                    if(str.equals("easy")){
                        bonus = 50;
                    }else if(str.equals("medium")){
                        bonus = 100;
                    }else{
                        bonus = 200;
                    }

                    textView_nyeremeny.setText((nyeremeny+bonus) + "");
                    megfordit(3);
                    jatek_kezdese();
                }
            }
        });


        beforgat.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn_card_one.setBackgroundResource(R.drawable.hatlap);
                btn_card_one.startAnimation(kiforgat);
            }
        });
    }

    public void megfordit(int index)
    {

        int resId = getResources().getIdentifier(kartyak[index-1], "drawable", getPackageName());

        switch(index){
            case 1:
                btn_card_one.startAnimation(beforgat);
                btn_card_one.setBackgroundResource(resId);
                break;
            case 2:
                btn_card_two.startAnimation(beforgat);
                btn_card_two.setBackgroundResource(resId);
                break;
            case 3:
                btn_card_three.startAnimation(beforgat);
                btn_card_three.setBackgroundResource(resId);
                break;
        }
    }

    public boolean check_kartya(int kartya_no){
        return (kartyak[kartya_no].substring(0,4).equals("karo") ||
                kartyak[kartya_no].substring(0,4).equals("kor_"));
    }

    public void mozgat(int honnan, int hova)
    {
        String temp = kartyak[honnan];
        kartyak[honnan] = kartyak[hova];
        kartyak[hova] = temp;

        eltuntet(honnan);
    }

    public void eltuntet(int melyiket)
    {
        switch(melyiket)
        {
            case 0: btn_card_one.startAnimation(fadeout); break;
            case 1: btn_card_two.startAnimation(fadeout); break;
            case 2: btn_card_three.startAnimation(fadeout); break;
        }

        //ennek csak elsőre van vmi jelentősége - aztán már nem számít
        //timer.cancel();
    }
}


















/* ez csak sablon...
this.kartyak = new String[]{true, false, false};
*/


/*
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 2 seconds
                eltuntet();
            }
        }, 2000);
        */

        /*
        myTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                Main2Activity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        eltuntet();
                    }
                });
            }
        },0, 1000);
        */