package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySharePreferance();
            }
        });
    }
    public void displaySharePreferance()
    {
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username=pref.getString("username","Vikrant");
        String password=pref.getString("password","1234");
        boolean checkbox=pref.getBoolean("checkBox",false);
        String listPref=pref.getString("listpref","Default list prefs");
        StringBuilder data=new StringBuilder();
        data.append("UserName"+username+"\n");
        data.append("Password"+password+"\n");
        data.append("Keep ne Logged in"+String.valueOf(checkbox)+"\n");
        data.append("List prefrence: "+listPref);
        textView.setText(data.toString());
    }


}
