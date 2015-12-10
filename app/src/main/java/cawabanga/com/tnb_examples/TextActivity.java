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
public class TextActivity extends AppCompatActivity implements View.OnClickListener{

    Button chkCmd;
    ToggleButton passTog;
    EditText input;
    TextView display;
    TextView caseDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        baconAndEggs(); //we create this method just to clear our code...initialization is on the bottom of code
        passTog.setOnClickListener(this); //now we can type here "this" because it gonna look in class and look for View.OnClickListener Method Implement
        chkCmd.setOnClickListener(this);


    }

    private void baconAndEggs() {
        chkCmd = (Button)findViewById(R.id.bResults);
        passTog = (ToggleButton)findViewById(R.id.tbPassword);
        input = (EditText) findViewById(R.id.etCommands);
        display = (TextView) findViewById(R.id.tvResults);
        caseDisplay = (TextView) findViewById(R.id.tvCase);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bResults: //That id is the same as chkCmd --> button findViewByID(R.id.bResults) and we got setOnClickListener on chkCmd
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
                    int numberCase = crazy.nextInt(3);
                    String randomString = String.valueOf(numberCase); //That's how we convert int to string (random number)
                    display.setText("WTF!!!!");
                    display.setTextSize(crazy.nextInt(75));
                    display.setTextColor(Color.rgb(crazy.nextInt(265),crazy.nextInt(265),crazy.nextInt(265)));
                    switch (numberCase){
                        case 0:
                            display.setGravity(Gravity.LEFT);
                            caseDisplay.setText(randomString);
                            break;
                        case 1:
                            display.setGravity(Gravity.CENTER);
                            caseDisplay.setText(randomString);
                            break;
                        case 2:
                            display.setGravity(Gravity.RIGHT);
                            caseDisplay.setText(randomString);
                            break;
                    }
                }else{
                    display.setText("invalid");
                    display.setGravity(Gravity.CENTER);

                }
                break;

            case R.id.tbPassword: //That id is the same as passTog --> button findViewByID(R.id.tbPassword) and we got setOnClickListener on passTog
                if (passTog.isChecked()){
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else {
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;

        }
    }
}
