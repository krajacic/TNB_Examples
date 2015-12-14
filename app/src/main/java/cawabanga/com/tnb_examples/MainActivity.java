package cawabanga.com.tnb_examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button gravity_layout, add_and_sub_layout, bg_music_layout, visibility_layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        gravity_layout = (Button) findViewById(R.id.gravity_button);
        add_and_sub_layout = (Button) findViewById(R.id.add_and_sub_button);
        bg_music_layout = (Button) findViewById(R.id.bg_music_button);
        visibility_layout = (Button) findViewById(R.id.visibility_button);

        gravity_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(new Intent(MainActivity.this, GravityLayoutActivity.class));
            }
        });

        add_and_sub_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(new Intent(MainActivity.this, AddAndSubLayoutActivity.class));
            }
        });

        bg_music_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(new Intent(MainActivity.this, BgMusicLayoutActivity.class));
            }
        });

        visibility_layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                startActivity(new Intent(MainActivity.this, VisibilityLayoutActivity.class));
            }
        });

        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent bgMusicIntent = new Intent("cawabanga.com.tnb_examples.MENU"); //inside of () MUST be the same name as action name in AndroidManifest.xml
                    startActivity(bgMusicIntent);
                }

            }

        };
        timer.start();



    }
}
