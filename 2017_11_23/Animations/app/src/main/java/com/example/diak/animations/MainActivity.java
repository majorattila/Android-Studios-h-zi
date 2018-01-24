package com.example.diak.animations;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btn_fade_in, btn_fade_out, btn_bounce, btn_zoom_in, btn_zoom_out, btn_rotate, btn_animation;
    private Animation fade_in, fade_out, bounce, zoom_in, zoom_out, rotate;

    private ImageView imageV_formation, imageV_frame;

    private Boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        listener();
    }

    public void init(){
        btn_fade_in = (Button) findViewById(R.id.btn_fade_in);
        btn_fade_out = (Button) findViewById(R.id.btn_fade_out);
        btn_bounce = (Button) findViewById(R.id.btn_bounce);
        btn_zoom_in = (Button) findViewById(R.id.btn_zoom_in);
        btn_zoom_out = (Button) findViewById(R.id.btn_zoom_out);
        btn_rotate = (Button) findViewById(R.id.btn_rotate);
        btn_animation = (Button) findViewById(R.id.btn_animation);

        imageV_formation = (ImageView) findViewById(R.id.imageV_formation);
        imageV_frame = (ImageView) findViewById(R.id.imageV_frame);

        fade_in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
        bounce = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
        zoom_in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in);
        zoom_out = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_out);
        rotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
    }

    public void listener(){

        btn_fade_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageV_formation.startAnimation(fade_in);
            }
        });

        btn_fade_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageV_formation.startAnimation(fade_out);
            }
        });

        btn_bounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageV_formation.startAnimation(bounce);
            }
        });

        btn_zoom_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageV_formation.startAnimation(zoom_in);
            }
        });

        btn_zoom_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageV_formation.startAnimation(zoom_out);
            }
        });

        btn_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageV_formation.startAnimation(rotate);
            }
        });

        btn_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!running){
                    ((AnimationDrawable) imageV_frame.getBackground()).start();
                    running = true;
                }else{
                    ((AnimationDrawable) imageV_frame.getBackground()).stop();
                    running = false;
                }
            }
        });

    }
}
