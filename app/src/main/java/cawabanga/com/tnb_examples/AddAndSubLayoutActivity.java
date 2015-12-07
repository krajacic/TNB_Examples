package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by croatan on 7.12.2015..
 */
public class AddAndSubLayoutActivity extends AppCompatActivity {

    int counter;
    Button add, sub;
    TextView display;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_and_sub);

        counter = 0;
        add = (Button) findViewById(R.id.add_button);
        sub = (Button) findViewById(R.id.sub_button);
        display = (TextView) findViewById(R.id.count);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter++;
                display.setText("Your total is " + counter);

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter--;
                display.setText("Your total is " + counter);

            }
        });

    }

}
