package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by croatan on 15.2.2016. project name: TNB_Examples.
 */
public class GFXSurface extends AppCompatActivity {

    MyBringBackSurface ourSurfaceView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurfaceView = new MyBringBackSurface(this);
        setContentView(ourSurfaceView);
    }
}

