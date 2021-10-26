package com.example.signupsignin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlpr(context  : Context) : SQLiteOpenHelper(context,"accounts.dp",null,1) {
    var sqLiteDatabase: SQLiteDatabase =writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if(db!=null){
            db.execSQL("create table Accounts (id integer primary key autoincrement,Name text,UserName text,Mobile text,Password text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
    fun savedat(name:String,username:String,mobile:String,password:String):Int{
        var c:Cursor=sqLiteDatabase.query("Accounts",null,"UserName=?", arrayOf(username),null,null,null)

       if(c.count>0) {  val cv= ContentValues()
        cv.put("Name",name)
        cv.put("UserName",username)
        cv.put("Mobile",mobile)
        cv.put("Password",password)
        sqLiteDatabase.insert("Accounts",null,cv)
        return 1}
        else{return -1}

    }
    @SuppressLint("Range")
    fun read(username:String):ArrayList<String>{
        var c:Cursor=sqLiteDatabase.query("Accounts",null,"UserName=?", arrayOf(username),null,null,null)
        c.moveToFirst()
        var name=c.getString(c.getColumnIndex("Name"))
        var mobile=c.getString(c.getColumnIndex("Mobile"))
        var userName=c.getString(c.getColumnIndex("UserName"))
        var info= arrayListOf<String>(name,mobile,userName)
       // var info="Your Name:$name\nYour UserName:$userName\nYour Mobile Number:$mobile"
        return info
    }
    fun check(username: String,password:String):Int
    {
        var c:Cursor =sqLiteDatabase.query("Accounts",null,"UserName=?", arrayOf(username),null,null,null)
       if(c.count>0L){
           var c1:Cursor =sqLiteDatabase.query("Accounts",null,"Password=?", arrayOf(password),null,null,null)
           if(c1.count>0L)
           {return 1}
           else{return 0}
       }
        else{
            return -1
        }
    }
//    @SuppressLint("Range")
//    fun readData(): ArrayList<Notess> {
//        val list: ArrayList<Notess> = ArrayList()
//        val db = this.readableDatabase
//        val query = "Select * from Notes"
//        val result = db.rawQuery(query, null)
//        if (result.moveToFirst()) {
//            do {
//                val not = Notess()
//                not.note = result.getString(result.getColumnIndex("Note"))
//                not.id= result.getInt(result.getColumnIndex("id")).toString()
//                list.add(not)
//            }
//            while (result.moveToNext())
//        }
//        return list
//    }
//
//
//
//    fun del(s1: String) {
//        sqLiteDatabase = writableDatabase
//        sqLiteDatabase.delete("Notes", "id=?", arrayOf(s1))
//    }
//    fun edit(s1:String,s2:String){
//        sqLiteDatabase=writableDatabase
//        val cv= ContentValues()
//        cv.put("Note",s2)
//        sqLiteDatabase.update("Notes",cv,"id=?", arrayOf(s1))
//    }

}

