package com.exam.faeezkmuhammed.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FAEEZ K MUHAMMED on 2/11/2017.
 */

public class Databasehelper extends SQLiteOpenHelper {
    public Databasehelper(Context context) {
        super(context, "logindb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tbl_login(emailid text primarykey,firstname text,lastname text,address text,mobile text,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table tbl_login if not exist");onCreate(db);

    }
    public boolean signup(String email,String fname,String lname,String address,String mobile,String password){
        ContentValues content=new ContentValues();
        SQLiteDatabase db=getWritableDatabase();
        long resultset=-1;

        content.put("email",email);
        content.put("firstname",fname);
        content.put("lastname",lname);
        content.put("address",address);
        content.put("mobile",mobile);
        content.put("password",password);
        resultset=db.insert("tbl_login",null,content);
        if(resultset==-1)
        return false;
        else
            return true;
    }
    public String check (String eid){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor=db.query("tbl_login",null,"email=?",new String[]{eid},null,null,null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "not found";
        }
        cursor.moveToFirst();
        String passworsd=cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();

        return passworsd;


    }

}
