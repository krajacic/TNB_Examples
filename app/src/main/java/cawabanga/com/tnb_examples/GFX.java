package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by croatan on 16.12.2015..
 */
public class GFX extends AppCompatActivity {

    MyBringBack ourView;
    //PowerManager.WakeLock wL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //WakeLock
        //PowerManager pM = (PowerManager)getSystemService(Context.POWER_SERVICE);
        //wL = pM.newWakeLock(getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON),"Wake Up");
        //wL = pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Wake UP!")

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        super.onCreate(savedInstanceState);
        //wL.acquire();
        ourView = new MyBringBack(this);
        setContentView(ourView);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //wL.release();
    }
}
