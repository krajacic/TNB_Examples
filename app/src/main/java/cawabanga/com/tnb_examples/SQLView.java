package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by croatan on 5.3.2016. TNB_Examples.
 */
public class SQLView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlview);
        TextView tv = (TextView) findViewById(R.id.tvSQLinfo);
        HotOrNot info = new HotOrNot(this);
        try {
            info.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String data = info.getData();
        info.close();
        tv.setText(data);
    }
}