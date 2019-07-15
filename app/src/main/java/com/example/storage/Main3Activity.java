package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storage.utlite.address;
import com.example.storage.utlite.database1;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
EditText name;
EditText data;
TextView text1,text2;
Button setdata,getonedata,update,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name=findViewById(R.id.name);
        data=findViewById(R.id.data);
        text1=findViewById(R.id.text10);
        text2=findViewById(R.id.text11);
        setdata=findViewById(R.id.setdata);
        getonedata=findViewById(R.id.get_one_data);
        update=findViewById(R.id.update_data);
        delete=findViewById(R.id.delete);
        call_function();

    }
    public void call_function()
    {
        final database1 db=new database1(Main3Activity.this);
       setdata.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String data12=name.getText().toString();
               String data123=data.getText().toString();
          db.insertData(data12,data123);
               Toast.makeText(getApplicationContext(),"data is Added in table\n"+data12+data123,Toast.LENGTH_SHORT).show();
           }
       });

       getonedata.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ArrayList<address> list =new ArrayList<>();
               address Address=new address();
               String name12=name.getText().toString();
               list =db.getonedata(name12);
               Address=list.get(0);
               String name21=Address.getname();

               Toast.makeText(getApplicationContext(),name21,Toast.LENGTH_LONG).show();
           }
       });
       delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name12=name.getText().toString();
               db.delete(name12);
           }
       });
       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name12=name.getText().toString();
               String data12=data.getText().toString();
               db.update(name12,data12);
           }
       });
    }
    public void getalldata(View v)
    {
        database1 db=new database1(Main3Activity.this);
        db.alldata();
    }
}
