package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by croatan on 8.3.2016. TNB_Examples.
 */
public class HttpExample extends AppCompatActivity {

    TextView httpStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpexample);
        httpStuff = (TextView) findViewById(R.id.tvHttp);
    }
}
