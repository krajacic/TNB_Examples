package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by croatan on 1.3.2016. TNB_Examples.
 */
public class Tabs extends AppCompatActivity implements View.OnClickListener{

    TabHost th;
    TextView showResults;
    long start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        th = (TabHost) findViewById(R.id.tabHost);
        showResults = (TextView) findViewById(R.id.tvShowResults);

        Button newTab = (Button) findViewById(R.id.bAddTab);
        Button bStop = (Button) findViewById(R.id.bStopWatch);
        Button bStart = (Button) findViewById(R.id.bStartWatch);
        bStop.setOnClickListener(this);
        bStart.setOnClickListener(this);
        newTab.setOnClickListener(this);

        th.setup();
        TabHost.TabSpec specs = th.newTabSpec("tag1");
        specs.setContent(R.id.tab1);
        specs.setIndicator("StopWatch");
        th.addTab(specs);

        specs = th.newTabSpec("tag2");
        specs.setContent(R.id.tab2);
        specs.setIndicator("Tab 2");
        th.addTab(specs);

        specs = th.newTabSpec("tag3");
        specs.setContent(R.id.tab3);
        specs.setIndicator("Add a Tab");
        th.addTab(specs);
        start = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bAddTab:
                TabHost.TabSpec ourSpec = th.newTabSpec("tag1");
                ourSpec.setContent(new TabHost.TabContentFactory(){
                    @Override
                    public View createTabContent(String tag) {
                        TextView text = new TextView(Tabs.this);
                        text.setText("You've created new tab!");
                        return text;
                    }
                });
                ourSpec.setIndicator("New");
                th.addTab(ourSpec);
            break;

            case R.id.bStartWatch:
                start = System.currentTimeMillis();
            break;
            case R.id.bStopWatch:
                stop = System.currentTimeMillis();
                if (start != 0){
                    long result = stop - start;
                    int millis = (int) result;
                    int second = (int) result/1000;
                    int minutes = second/60;
                    millis = millis % 100;
                    second = second % 60;
                    showResults.setText(String.format("%d:%02d:%02d", minutes, second, millis));
                }
            break;
        }
    }
}
