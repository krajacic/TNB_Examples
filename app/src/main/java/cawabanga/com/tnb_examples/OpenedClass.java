package cawabanga.com.tnb_examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by croatan on 14.12.2015..
 */
public class OpenedClass extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    TextView question, test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread, setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        initialize();
        //Bundle gotBasket = getIntent().getExtras();
        //gotBread = gotBasket.getString("key"); //key is file name that we set for bread variable from Data class
        //question.setText(gotBread);
    }

    private void initialize() {
        question = (TextView) findViewById(R.id.tvQuestion);
        test = (TextView) findViewById(R.id.tvText);
        returnData = (Button) findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
        selectionList.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer", setData);
        person.putExtras(backpack);
        setResult(RESULT_OK, person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rCrazy:
                setData = "Probably right!";
                break;
            case R.id.rSexy:
                setData = "Definitely right!";
                break;
            case R.id.rBoth:
                setData = "Spot on!";
                break;
        }
        test.setText(setData);
    }
}
