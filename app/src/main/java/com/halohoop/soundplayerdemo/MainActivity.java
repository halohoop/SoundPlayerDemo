package com.halohoop.soundplayerdemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        try {
            Uri myUri = Uri.parse("file:///sdcard/DCIM/camera_click.ogg"); // initialize Uri here
//            Uri myUri = Uri.parse("/mnt/sdcard/DCIM/test.ogg"); // initialize Uri here
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(getApplicationContext(), myUri);
            mediaPlayer.setVolume(0.1f, 0.1f);//貌似这个会大声一点
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click2(View view) {
        SoundPool.Builder builder = new SoundPool.Builder();
        final SoundPool mSoundPool = builder.build();
        final int load = mSoundPool.load("/mnt/sdcard/DCIM/camera_click.ogg", 1);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSoundPool.play(load, 0.1f, 0.1f, 1, 0, 1);//貌似这个会小声一点
            }
        }, 500);
    }
}
