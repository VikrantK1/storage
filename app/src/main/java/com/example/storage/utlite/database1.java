package com.example.storage.utlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class database1 extends SQLiteOpenHelper {
   static String DB="Database";
     String Table="item";
    String Id="id";
     String Data="Data";
     Integer count=0;
     String name12="name";
     static   int  version=1;
     int iddata=1;
     Context context;

    public database1(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public database1(Context context) {

        super(context, DB, null,version );
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

     String createTable="CREATE TABLE "+Table+"("+Id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+name12+" varchar(30),"+Data+" varchar(45)"+");";
        sqLiteDatabase.execSQL(createTable);
        Toast.makeText(context,"Table is Created",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table);

        onCreate(sqLiteDatabase);
    }
    //Insert in Sql
    public void insertData(String name1,String  data1)
    {
    SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(name12,name1);
        values.put(Data,data1);
        db.insert(Table,null,values);
        db.close();
        Toast.makeText(context,"Data is inserted",Toast.LENGTH_SHORT).show();

    }
    //Delete From Sql
    public void delete(String name1)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        db.delete(Table,name12+"=?", new String[] {name1});
        Toast.makeText(context,"Data is deleted",Toast.LENGTH_SHORT).show();

        db.close();
    }
    //Update in Sql
    public void update(String name1,String data)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(name12,name1);
        values.put(Data,data);
        db.update(Table,values,name12+"=?",new String[] {name1});
        db.close();
    }
    public List<address> alldata()
    {
        List<address> list= new ArrayList<address>();
        SQLiteDatabase db=this.getReadableDatabase();
        String data="SELECT * FROM "+Table;
        Cursor  cursor=db.rawQuery(data,null);
        if (cursor!=null && cursor.moveToFirst())
        {
            do {
                address address=new address();
                 int id=cursor.getInt(cursor.getColumnIndexOrThrow(Id));
                 String name13=cursor.getString(cursor.getColumnIndexOrThrow(name12));
               String data23=cursor.getString(cursor.getColumnIndexOrThrow(Data));
              Toast.makeText(context,id+" "+name13+" "+data23,Toast.LENGTH_LONG).show();
             list.add(address);
            }while (cursor.moveToNext());
        }
        db.close();
        return list;
    }
    //get one Data
  public ArrayList<address> getonedata(String name1){
        ArrayList<address> list=new ArrayList<address>();
       //list=null;
    SQLiteDatabase db=this.getReadableDatabase();
      Cursor cursor = db.query(Table,new String[] {Id,name12,Data},name12+"=?",new String[] {name1},null,null,null);
         if(cursor!=null && cursor.moveToFirst())
         {
             address address1=new address();
             address1.id=cursor.getInt(cursor.getColumnIndexOrThrow(Id));
             address1.name=cursor.getString(cursor.getColumnIndexOrThrow(name12));
             address1.data=cursor.getString(cursor.getColumnIndexOrThrow(Id));
             list.add(address1);
         }



         Toast.makeText(context,"quary is Wrong",Toast.LENGTH_SHORT).show();
        return list;
    }
   public  int getcount()
   {
       SQLiteDatabase db=this.getReadableDatabase();
       count=0;
       String count123="SELECT * FROM "+Table;
       Cursor cursor=db.rawQuery(count123,null);
       return cursor.getCount();
   }
}
