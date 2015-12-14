package cawabanga.com.tnb_examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by croatan on 14.12.2015..
 */
public class Data extends AppCompatActivity implements View.OnClickListener {

    Button start, startFor;
    EditText sendET;
    TextView gotAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        initialize();
    }

    private void initialize(){
        start = (Button) findViewById(R.id.bSA);
        startFor = (Button) findViewById(R.id.bSAFR);
        sendET = (EditText) findViewById(R.id.etSend);
        gotAnswer = (TextView) findViewById(R.id.tvGot);
        start.setOnClickListener(this);
        startFor.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSA:
                String bread = sendET.getText().toString();
                Bundle basket = new Bundle();
                basket.putString("key", bread); //key is filename and bread is value
                Intent a = new Intent(Data.this, OpenedClass.class);
                a.putExtras(basket);
                startActivity(a);
                break;
            case R.id.bSAFR:

                break;
        }
    }
}
