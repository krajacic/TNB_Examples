package cawabanga.com.tnb_examples;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by croatan on 9.12.2015..
 */
public class Menu extends ListActivity {

    String classes[] = { "BgMusicLayoutActivity", "TextActivity", "Email", "Camera", "Data", "example5", "example6" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));

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
}
