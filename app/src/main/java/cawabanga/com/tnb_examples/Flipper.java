package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

/**
 * Created by croatan on 2.3.2016. TNB_Examples.
 */
public class Flipper extends AppCompatActivity implements View.OnClickListener{

    ViewFlipper flippy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);
        flippy = (ViewFlipper) findViewById(R.id.viewFlipper);
        flippy.setOnClickListener(this);
        //Content Will Auto Change Every .5 sec
        flippy.setFlipInterval(500);
        flippy.startFlipping();
    }

    @Override
    public void onClick(View v) {
        //Content (Button and textViews) will change after click on Flipper
        flippy.showNext();

    }
}
