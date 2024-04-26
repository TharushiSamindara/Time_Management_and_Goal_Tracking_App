package com.example.timemanagementandgoaltrackigapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context) :SQLiteOpenHelper(context,"TimeandGoal",null,1) {
    companion object {
        const val TABLE_NAME = "Users"
        private const val SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME +"(indexNo INTEGER,username TEXT,password TEXT)"
        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion:Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertData(
        indexNo: Int,
        username:String?,
        password:String?){

        val values = ContentValues()
        values.put("indexNo", indexNo)
        values.put("username", username)
        values.put("password", password)
        val db = this.writableDatabase
        db.insert(TABLE_NAME,null,values)
    }
}