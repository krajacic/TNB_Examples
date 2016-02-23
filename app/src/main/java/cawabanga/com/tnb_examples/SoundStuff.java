package cawabanga.com.tnb_examples;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by croatan on 23.2.2016. TNB_Examples.
 */
public class SoundStuff extends AppCompatActivity implements View.OnClickListener {

    SoundPool sp;
    int explosion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = new View(this);
        v.setOnClickListener(this);
        setContentView(v);
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        explosion = sp.load(this, R.raw.booom, 1);

    }

    public void onClick(View v){
        if (explosion != 0)
        sp.play(explosion, 1, 1, 0, 0,1);
    }
}
