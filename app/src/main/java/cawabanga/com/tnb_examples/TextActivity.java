package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by croatan on 9.12.2015..
 */
public class TextActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        Button chkCmd = (Button)findViewById(R.id.bResults);
        final ToggleButton passTog = (ToggleButton)findViewById(R.id.tbPassword);
        final EditText input = (EditText) findViewById(R.id.etCommands);
        final TextView display = (TextView) findViewById(R.id.tvResults);

        passTog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passTog.isChecked()){
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else {
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        chkCmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = input.getText().toString();
                if (check.contentEquals("left")){
                    display.setGravity(Gravity.LEFT);
                }else if(check.contentEquals("center")){
                    display.setGravity(Gravity.CENTER);
                }else if(check.contentEquals("right")){
                    display.setGravity(Gravity.RIGHT);
                }
            }
        });


    }
}