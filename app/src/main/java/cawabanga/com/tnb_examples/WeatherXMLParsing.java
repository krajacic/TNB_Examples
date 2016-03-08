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

    static final String baseURL = "http://api.openweathermap.org/data/2.5/weather?q=";
    TextView tv;
    EditText city, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatherex);
        Button b = (Button) findViewById(R.id.bWeather);
        tv = (TextView) findViewById(R.id.tvWeather);
        city = (EditText) findViewById(R.id.etCity);
        country = (EditText) findViewById(R.id.etCountry);
    }

    @Override
    public void onClick(View v) {
        String cty = city.getText().toString();
        String cnt = country.getText().toString();

        StringBuilder URL = new StringBuilder(baseURL);
        URL.append(cty + "," + cnt + "&appid=44db6a862fba0b067b1930da0d769e98");
        String fullUrl = URL.toString();


    }
}
