package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by croatan on 4.3.2016. TNB_Examples.
 */
public class ExternalData extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener{

    private TextView canWrite, canRead;
    private String state;
    boolean canW, canR;
    Spinner spinner;
    String[] paths = {"Music", "Pictures", "Downloads"}; //Options where we can save our datas
    File path = null;
    File file = null;
    EditText saveFile;
    Button confirm, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externaldata);
        canWrite = (TextView)findViewById(R.id.tvCanWrite);
        canRead = (TextView)findViewById(R.id.tvCanRead);
        confirm = (Button) findViewById(R.id.bConfirmSaveAs);
        save = (Button) findViewById(R.id.bSaveFile);
        confirm.setOnClickListener(this);
        save.setOnClickListener(this);

        checkState();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths); //parameters (Context, type of spinner, string Array)

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void checkState() {
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
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int positionN = spinner.getSelectedItemPosition();
        switch (positionN){
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSaveFile:
                String f = saveFile.getText().toString();
                file = new File(path, f);
                checkState();
                if (canW == canR == true){
                    try {
                        InputStream is = getResources().openRawResource(R.drawable.ball);
                        OutputStream os = new FileOutputStream(file);
                        byte[] data = new byte[is.available()];
                        is.read(data);
                        os.write(data);
                        is.close();
                        os.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.bConfirmSaveAs:
                save.setVisibility(View.VISIBLE);
                break;
        }

    }
}
