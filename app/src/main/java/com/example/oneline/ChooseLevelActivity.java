package com.example.oneline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChooseLevelActivity extends AppCompatActivity {
    public static int lv;
    public static MediaPlayer Musicbackground;
    MediaPlayer touch_menu;
    public static Activity selfinter;
    ImageButton img;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
        Music();
        Anhxa();
        // main menu
        selfinter = this;
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.selfinter.finish();
                Intent intent = new Intent(ChooseLevelActivity.this,MainActivity.class);
                Musicbackground.stop();
                startActivity(intent);

                finish();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch();
                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",1);
                intent.putExtras(bundle);
                lv = 1;
                Musicbackground.stop();
                startActivity(intent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch();
                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",2);
                intent.putExtras(bundle);
                lv = 2;
                Musicbackground.stop();
                startActivity(intent);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch();
                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",3);
                lv = 3;
                intent.putExtras(bundle);
                Musicbackground.stop();
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch();
                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",4);
                lv = 4;
                intent.putExtras(bundle);
                Musicbackground.stop();
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch();
                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",5);
                lv = 5;
                intent.putExtras(bundle);
                Musicbackground.stop();
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch();
                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",6);
                lv = 6;
                intent.putExtras(bundle);
                Musicbackground.stop();
                startActivity(intent);
            }
        });
    }
    private void touch(){
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        touch_menu = MediaPlayer.create(ChooseLevelActivity.this, R.raw.touch_menu);
        touch_menu.setLooping(false);
        touch_menu.setVolume(10.0f, 10.0f);
        touch_menu.start();
    }

    private void Music(){
        Musicbackground = MediaPlayer.create(ChooseLevelActivity.this,R.raw.music_choselvl);
        Musicbackground.setLooping(true);
        Musicbackground.setVolume(10.0f,10.0f);
        Musicbackground.start();
    }
    private void Anhxa(){
        img = findViewById(R.id.backstart);
        btn1 = findViewById(R.id.level01);
        btn2 = findViewById(R.id.level02);
        btn3 = findViewById(R.id.level03);
        btn4 = findViewById(R.id.level04);
        btn5 = findViewById(R.id.level05);
        btn6 = findViewById(R.id.level06);
    }
}