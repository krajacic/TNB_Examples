package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;

/**
 * Created by croatan on 8.3.2016. TNB_Examples.
 */
public class HttpExample extends AppCompatActivity {

    TextView httpStuff;
    HttpClient client;

    final static String URL = "https://api.twitter.com/1.1/statuses/user_timeline.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpexample);
        httpStuff = (TextView) findViewById(R.id.tvHttp);
        client = (HttpClient) new DefaultHttpClient();
    }

    public JSONObject lastTweet(String username) throws ClientProtocolException, IOException, JSONException{
        StringBuilder url = new StringBuilder(URL);

        HttpGet get = new HttpGet(url.toString());
    }
}
