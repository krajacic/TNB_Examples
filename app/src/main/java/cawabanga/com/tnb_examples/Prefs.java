package cawabanga.com.tnb_examples;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by croatan on 15.12.2015..
 */
public class Prefs extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
