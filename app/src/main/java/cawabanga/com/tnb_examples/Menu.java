package cawabanga.com.tnb_examples;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by croatan on 9.12.2015. TNB_Examples.
 */
public class Menu extends ListActivity {

    String classes[] = { "BgMusicLayoutActivity", "TextActivity", "Email", "Camera", "Data", "GFX", "GFXSurface", "SoundStuff", "Slider", "Tabs", "SimpleBrowser", "SharedPrefs", "InternalData", "ExternalData", "SQLiteExample", "SQLView", "Accelerate" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //fullScreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setListAdapter(new ArrayAdapter<>(Menu.this, android.R.layout.simple_list_item_1, classes));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];
                try {
            Class ourClass = Class.forName("cawabanga.com.tnb_examples." + cheese);
            Intent ourIntent = new Intent(Menu.this, ourClass);
            startActivity(ourIntent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater blowUp =  getMenuInflater();
        blowUp.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutUs:
                Intent i = new Intent("cawabanga.com.tnb_examples.ABOUT");
                startActivity(i);
                break;
            case R.id.preferences:
                Intent p = new Intent("cawabanga.com.tnb_examples.PREFS");
                startActivity(p);
                break;
            case R.id.exit:
                finish();
                break;
        }
        return false;
    }
}
