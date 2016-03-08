package cawabanga.com.tnb_examples;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by croatan on 8.3.2016. TNB_Examples.
 */
public class HttpExample extends AppCompatActivity {

    TextView httpStuff;
    HttpClient client;
    JSONObject json;

    final static String URL = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpexample);
        httpStuff = (TextView) findViewById(R.id.tvHttp);
        client = (HttpClient) new DefaultHttpClient();
        new Read().execute("text");
    }

    public JSONObject lastTweet(String username) throws ClientProtocolException, IOException, JSONException{
        StringBuilder url = new StringBuilder(URL);
        url.append(username);

        HttpGet get = new HttpGet(url.toString());
        HttpResponse r = client.execute(get);
        int status = r.getStatusLine().getStatusCode();
        if (status == 200 ){
            HttpEntity e = r.getEntity();
            String data = EntityUtils.toString(e);
            JSONArray timeline = new JSONArray(data);
            JSONObject last = timeline.getJSONObject(0);
            return last;
        }else{
            Toast.makeText(HttpExample.this, "error", Toast.LENGTH_LONG);
            return null;
        }
    }

    public class Read extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... params) {
            try {
                json = lastTweet("Croatan315");
                return json.getString(params[0]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            httpStuff.setText(s);
        }
    }

}
