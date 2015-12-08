package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by croatan on 8.12.2015..
 */
public class VisibilityLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visivility_example);
    }

    public void lyricsButtonClicked(View view){
        TextView textView = (TextView) findViewById(R.id.visibility_textview);
        textView.setVisibility(View.VISIBLE);


    }

}
