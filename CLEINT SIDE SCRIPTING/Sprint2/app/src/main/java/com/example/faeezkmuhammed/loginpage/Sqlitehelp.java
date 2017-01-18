package com.example.faeezkmuhammed.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FAEEZ K MUHAMMED on 1/17/2017.
 */

public class Sqlitehelp extends SQLiteOpenHelper {

    public Sqlitehelp(Context context) {
        super(context,"login_db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("create table tbl_login (userid text primary key,pswd text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("drop table if exist tbl_login");
        onCreate(db);
    }
public boolean createaccount (String id,String pswd){

    SQLiteDatabase db=this.getWritableDatabase();
    long result=-1;
    ContentValues content =new ContentValues();
    content.put("userid",id);
    content.put("pswd",pswd);
    result=db.insert("tbl_login",null,content);
    if (result==-1)
    return false;
    else
        return true;

}
    public String check (String uid){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor=db.query("tbl_login",null,"userid=?",new String[]{uid},null,null,null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "not exist";
        }
        cursor.moveToFirst();
        String passworsd=cursor.getString(cursor.getColumnIndex("pswd"));
        cursor.close();

        return passworsd;


    }
}

