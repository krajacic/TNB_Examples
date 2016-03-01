package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by croatan on 1.3.2016. TNB_Examples.
 */
public class SimpleBrowser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplebrowser);

        WebView ourBrowser = (WebView) findViewById(R.id.wvBrowser);
        ourBrowser.loadUrl("https://www.google.com");
        ourBrowser.setWebViewClient(new WebViewClient()); //To prevent opening website in other Browser like Chrome

    }
}
