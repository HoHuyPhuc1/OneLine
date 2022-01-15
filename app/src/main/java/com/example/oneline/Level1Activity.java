package com.example.oneline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.zip.Deflater;

public class Level1Activity extends AppCompatActivity {
    MediaPlayer BackgroudMusic;
    Button btnmainmenu,btnresume;
    public static Activity selfinter;
    public static MediaPlayer backgroundMusic;
    int lvl;
    Button btnchose;
    ImageButton menu01, iconundo01;
    static TextView lv;
//public int s = bundle.getInt("lvl");
//public int getlv(){
//    return s;
//}

    static TextView countundo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Music();
        Bundle bundle = getIntent().getExtras();
        int s =  bundle.getInt("lvl");

        setContentView(R.layout.activity_level1);
        selfinter = this;
        menu01 = findViewById(R.id.menu01);
        lv = (TextView) findViewById(R.id.level);
        lv.setText(lv.getText()+" "+String.valueOf(s));
        countundo = findViewById(R.id.countundo01);
        lvl = s;

        menu01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(Gravity.CENTER);
            }
        });


    }



    Diem a;

    public void openDialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog);

        btnchose = dialog.findViewById(R.id.btnchoselevel);
        btnchose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseLevelActivity.selfinter.finish();
                Intent intent =new Intent(Level1Activity.this,ChooseLevelActivity.class);
                startActivity(intent);
//                ChooseLevelActivity.Musicbackground.start();
                Level1Activity.selfinter.finish();
                BackgroudMusic.stop();
            }

        });
        btnmainmenu = dialog.findViewById(R.id.btnmainmenu);
        btnmainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.selfinter.finish();

                Intent intent =  new Intent(Level1Activity.this, MainActivity.class);
                startActivity(intent);

                Level1Activity.selfinter.finish();
                ChooseLevelActivity.selfinter.finish();
                BackgroudMusic.stop();


//                MainActivity.backgroundMusic.start();
            }
        });
        btnresume = dialog.findViewById(R.id.btnresume);
        btnresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        Window window = dialog.getWindow();
        if(window == null) return;
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);
        dialog.show();
    }
    private void Music(){
        BackgroudMusic = MediaPlayer.create(Level1Activity.this,R.raw.music_game);
        BackgroudMusic.setLooping(true);
        BackgroudMusic.setVolume(10.0f,10.0f);

        BackgroudMusic.start();
    }
}