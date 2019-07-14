package com.example.storage;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class pref extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }
}
