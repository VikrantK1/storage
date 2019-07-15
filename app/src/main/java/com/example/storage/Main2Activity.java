package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {
EditText editText1,editText2;
TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);

    }
    public void saveData(View v)
    {
        String filename=editText1.getText().toString();
        String data=editText2.getText().toString();
        FileOutputStream fos;
        try{
            fos=openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readData(View v)
    {
        String filename=editText1.getText().toString();
        StringBuffer stringBuffer=new StringBuffer();
        try
        {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(openFileInput(filename)));
            String inputString;
            while ((inputString=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(inputString+"\n");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        text2.setText(stringBuffer);
    }
    public void saveDataExter(View v)
    {
        String filename=editText1.getText().toString();
        String data=editText2.getText().toString();
        FileOutputStream fos;
        try{
            File file=new File("/sdcard/"+filename);
            file.createNewFile();
            fos=new FileOutputStream(file);
            fos.write(data.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Save to External", Toast.LENGTH_SHORT).show();
    }
    public void readDataExter(View v)
    {
        String filename=editText1.getText().toString();
        String string = null;
        try
        {
            File file=new File("/sdcard/"+filename);
            FileInputStream fis=new FileInputStream(file);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fis));
            String inputString;
            while ((inputString=bufferedReader.readLine())!=null)
            {
                string+=inputString+"\n";
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        text2.setText(string);
        Toast.makeText(getApplicationContext(),"Read from External",Toast.LENGTH_SHORT);
    }
    public void nextpage(View v)
    {
        Intent intent =new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(intent);
    }
}
