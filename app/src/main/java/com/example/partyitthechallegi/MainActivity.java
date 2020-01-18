package com.example.partyitthechallegi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {

    SoundPool sp;
    MediaPlayer mm;
    int explosion = 0;
    Random crazy = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        View v = new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        setContentView(v);


        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        explosion = sp.load(this, R.raw.soundtrack, 1);

        mm = MediaPlayer.create(this, R.raw.backgroundmusic);

        v.setBackgroundColor(Color.rgb(crazy.nextInt(256), crazy.nextInt(250), crazy.nextInt(256)));


    }

    @Override
    public boolean onLongClick(View v) {
        mm.start();
        return false;
    }

    @Override
    public void onClick(View v) {

        if (explosion != 0) {
            sp.play(explosion, 1, 1, 1, 0, 1);
            v.setBackgroundColor(Color.rgb(crazy.nextInt(256), crazy.nextInt(250), crazy.nextInt(256)));


        }

    }
}
