package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;

/**
 * Created by croatan on 4.3.2016. TNB_Examples.
 */
public class ExternalData extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextView canWrite, canRead;
    private String state;
    boolean canW, canR;
    Spinner spinner;
    String[] paths = {"Music", "Pictures", "Downloads"}; //Options where we can save our datas
    File path = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externaldata);
        canWrite = (TextView)findViewById(R.id.tvCanWrite);
        canRead = (TextView)findViewById(R.id.tvCanRead);
        state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED )){
            //Media mounted means that we can read and write
            canRead.setText("true");
            canWrite.setText("true");
            canW = canR = true;
        } else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            //read but CAN NOT Write
            canRead.setText("true");
            canWrite.setText("false");
            canW = false;
            canR =  true;
        } else {
            canRead.setText("false");
            canWrite.setText("false");
            canW = canR = false;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths); //parameters (Context, type of spinner, string Array)

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int position = spinner.getSelectedItemPosition();
        switch (position){
            case 0:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
