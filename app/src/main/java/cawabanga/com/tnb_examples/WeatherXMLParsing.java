package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by croatan on 8.3.2016. TNB_Examples.
 */
public class WeatherXMLParsing extends AppCompatActivity implements View.OnClickListener {

    String URL = "http://www.google.com/ig/api?weather=";
    TextView tv;
    EditText city, state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatherex);
        Button b = (Button) findViewById(R.id.bWeather);
        tv = (TextView) findViewById(R.id.tvWeather);
        city = (EditText) findViewById(R.id.etCity);
        state = (EditText) findViewById(R.id.etState);
    }

    @Override
    public void onClick(View v) {

    }
}
