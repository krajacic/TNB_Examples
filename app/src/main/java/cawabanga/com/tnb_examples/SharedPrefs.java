package cawabanga.com.tnb_examples;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by croatan on 2.3.2016. TNB_Examples.
 */
public class SharedPrefs extends AppCompatActivity implements View.OnClickListener{

    EditText sharedData;
    TextView dataResults;
    public static String filename = "MySharedString"; //Static means that this filename will NEVER change, Public - so other activities can access this filename
    SharedPreferences someData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedprefs);
        setupVariables();
        someData = getSharedPreferences(filename, 0);
    }

    private void setupVariables() {
        Button save = (Button)findViewById(R.id.bSave);
        Button load = (Button)findViewById(R.id.bLoad);
        sharedData = (EditText)findViewById(R.id.etSharedPrefs);
        dataResults = (TextView)findViewById(R.id.tvLoadSharedPrefs);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSave:
                String stringData = sharedData.getText().toString();
                SharedPreferences.Editor editor = someData.edit();
                editor.putString("sharedStringKey", stringData); // (key, value)
                editor.commit();
                break;
            case R.id.bLoad:
                break;
        }
    }
}
