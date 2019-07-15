package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

public class jsonfile extends AppCompatActivity {
TextView jsondata;
public static final String jsondat="{\'employ\':{'name':'Vikrant','salary':2000,'married':'no'}}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonfile);
        jsondata=findViewById(R.id.jsonfiledata);
      try{
          JSONObject emp=(new JSONObject(jsondat)) .getJSONObject("employ");
          String name=emp.getString("name");
          int empsalary=emp.getInt("salary");
          String empstatus=emp.getString("married");
          String data="Name:"+name+"\nSalary:"+empsalary+"\nStatus"+empstatus;
          jsondata.setText(data);
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }


    }
}
