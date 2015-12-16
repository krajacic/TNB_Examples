package cawabanga.com.tnb_examples;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean music = getPrefs.getBoolean("checkBoxKey",true);
        if (music == true){
            mySound.start();
        }

    }

    public void playMusic(View view){
        mySound.start();
    }

}
