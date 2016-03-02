package cawabanga.com.tnb_examples;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by croatan on 1.3.2016. TNB_Examples.
 */
public class SimpleBrowser extends AppCompatActivity implements View.OnClickListener{

    EditText url;
    WebView ourBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplebrowser);

        ourBrowser = (WebView) findViewById(R.id.wvBrowser);


        ourBrowser.getSettings().setJavaScriptEnabled(true); //mostly for sites like YT
        ourBrowser.getSettings().setLoadWithOverviewMode(true); //completely zoom out website
        ourBrowser.getSettings().setUseWideViewPort(true);
        ourBrowser.setWebViewClient(new WebViewClient()); //To prevent opening website in other Browser like Chrome
        try {
            ourBrowser.loadUrl("https://www.google.com");
        }
        catch (Exception e){
            e.printStackTrace();
        }


        Button go = (Button)findViewById(R.id.bGo);
        Button back = (Button)findViewById(R.id.bBack);
        Button forward = (Button)findViewById(R.id.bForward);
        Button refresh = (Button)findViewById(R.id.bRefresh);
        Button clean = (Button)findViewById(R.id.bClean);
        url = (EditText)findViewById(R.id.etURL);
        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        clean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bGo:
                String theWebsite = url.getText().toString();
                ourBrowser.loadUrl(theWebsite);
                //hiding the keyboard after using EditText (URL)
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
                break;
            case R.id.bBack:
                if (ourBrowser.canGoBack())
                ourBrowser.goBack();
                break;
            case R.id.bForward:
                if (ourBrowser.canGoForward())
                    ourBrowser.goBack();
                break;
            case R.id.bRefresh:
                ourBrowser.reload();
                break;
            case R.id.bClean:
                ourBrowser.clearHistory();
                break;
        }
    }
}
