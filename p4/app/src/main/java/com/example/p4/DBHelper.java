package com.example.p4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, "Employee", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE EMPLOYEE(id TEXT PRIMARY KEY, name TEXT, salary TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS EMPLOYEE;");
        onCreate(db);
    }

    public void insert(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("INSERT INTO EMPLOYEE VALUES(1, 'Sricharan', '1000');");
    }

    public void delete(){
        int i=1;
        SQLiteDatabase db = this.getReadableDatabase();
        try{
            db.execSQL("DELETE FROM EMPLOYEE WHERE id = '"+ i + "';");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String retrieve(String i){
        int count=0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM EMPLOYEE WHERE id = '"+i+"';", null);
        String data = "";
        if(c.moveToFirst()){
            do{
                data+=c.getString(0);data+=" ";
                data+=c.getString(1);
            }while(c.moveToNext());
        }
        return data;
    }

    public void update(){

        String name="Srich";
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE EMPLOYEE SET name= '"+name+"' WHERE id = '"+1+"';");
    }
}
