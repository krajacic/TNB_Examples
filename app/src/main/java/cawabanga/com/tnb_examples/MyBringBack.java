package cawabanga.com.tnb_examples;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

/**
 * Created by croatan on 16.12.2015..
 */
public class MyBringBack extends View {

    Bitmap gBall;


    public MyBringBack(Context context) {
        super(context);

        gBall = BitmapFactory.decodeResource(getResources(), R.drawable.tennis_ball);
    }
}
