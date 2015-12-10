package cawabanga.com.tnb_examples;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

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
                display.setText(check);
                if (check.contentEquals("left")){
                    display.setGravity(Gravity.LEFT);
                }else if(check.contentEquals("center")){
                    display.setGravity(Gravity.CENTER);
                }else if(check.contentEquals("right")){
                    display.setGravity(Gravity.RIGHT);
                }else if(check.contentEquals("blue")){
                    display.setTextColor(Color.BLUE);
                }else if(check.contains("WTF")){
                    Random crazy = new Random();
                    display.setText("WTF!!!!");
                    display.setTextSize(crazy.nextInt(75));
                    display.setTextColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265),crazy.nextInt(265)));
                }else{
                    display.setText("invalid");
                    display.setGravity(Gravity.CENTER);

                }
            }
        });


    }
}
