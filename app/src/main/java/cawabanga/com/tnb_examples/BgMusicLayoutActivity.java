package cawabanga.com.tnb_examples;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by croatan on 7.12.2015..
 */
public class BgMusicLayoutActivity extends AppCompatActivity {

    MediaPlayer mySound;  //we could use SoundPool but that class is for short clips like explosion or "click"

    @Override
    protected void onPause() {
        super.onPause();
        mySound.release();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bg_music);

        mySound = MediaPlayer.create(BgMusicLayoutActivity.this, R.raw.wonderful_world);
    }

    public void playMusic(View view){
        mySound.start();
    }

}
