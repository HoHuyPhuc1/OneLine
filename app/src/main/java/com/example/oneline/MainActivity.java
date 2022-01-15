package com.example.oneline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_start, btn_option, btn_quit;
    public static Intent a;
    public static Activity selfinter;
    public static MediaPlayer backgroundMusic;
    MediaPlayer touch_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        backgroundMusic = MediaPlayer.create(MainActivity.this, R.raw.game_over);
//
//
//        backgroundMusic.setLooping(true);
//        backgroundMusic.setVolume(10.0f, 3.0f);
//        backgroundMusic.start();
            setContentView(R.layout.activity_main);
            Music();
            //set mau chu
            TextView t = findViewById(R.id.name);
            String text = "OneLine"; // O L
            SpannableString s = new SpannableString(text);
            ForegroundColorSpan O = new ForegroundColorSpan(Color.parseColor("#0E2952"));
            ForegroundColorSpan L = new ForegroundColorSpan(Color.parseColor("#0E2952"));
            s.setSpan(O, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s.setSpan(L, 3,4,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            t.setText(s);
            //
            selfinter = this;
//        a = new Intent(MainActivity.this,ChooseLevelActivity.class);
            btn_start = findViewById(R.id.btnStart);
            btn_option = findViewById(R.id.btnOption);
            btn_quit = findViewById(R.id.btnQuit);

            // Option
            btn_option.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    touch();
                    Intent intent = new Intent(MainActivity.this, OptionActivity.class);
                    backgroundMusic.stop();
                    startActivity(intent);

                }
            });

            // Quit
            btn_quit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    touch();
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//                    Intent startMain = new Intent(Intent.ACTION_MAIN);
//                    startMain.addCategory(Intent.CATEGORY_HOME);
//                    startActivity(startMain);
                    backgroundMusic.stop();
                    finish();
                }
            });

            // Start Game
            btn_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    touch();
                    Intent intent = new Intent(MainActivity.this, ChooseLevelActivity.class);
                    backgroundMusic.stop();
                    startActivity(intent);
                }
            });

    }
    private void touch(){
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        touch_menu = MediaPlayer.create(MainActivity.this, R.raw.touch_menu);
        touch_menu.setLooping(false);
        touch_menu.setVolume(10.0f, 10.0f);
        touch_menu.start();
    }
    private void Music(){
        backgroundMusic = MediaPlayer.create(MainActivity.this,R.raw.music_menu);
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(10.0f,10.0f);
        backgroundMusic.start();
    }
}