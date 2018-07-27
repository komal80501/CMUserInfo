package com.example.cm.cmuserinfo.DataUtility;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "CMUSERINFODB";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String TABLE_UserInfo = "userinfo";

    // User Table Columns names
    private static final String userID = "userID";
    private static final String userName = "userName";
    private static final String mobileNo = "mobileNo";
    private static final String emailID = "emailID";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String userInfoTable = "CREATE TABLE " + TABLE_UserInfo + "("
                + userID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + userName + " TEXT,"
                + mobileNo + " TEXT,"
                + emailID + " TEXT"+")";
        db.execSQL(userInfoTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UserInfo);
    }

    public Long insertUser(UserInfo userInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(userName, userInfo.getUserName());
        contentValues.put(mobileNo, userInfo.getMobileNo());
        contentValues.put(emailID, userInfo.getEmailID());
        Long result = db.insert(TABLE_UserInfo, null, contentValues);
        return result;
    }

    public UserInfo getUserInfo(int ID) {
       UserInfo userInfo=new UserInfo();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_UserInfo +" where userID=" + ID;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor !=null)
            cursor.moveToFirst();

        userInfo.setUserName(cursor.getString(cursor.getColumnIndex(DBHandler.userName)));
        userInfo.setMobileNo(cursor.getString(cursor.getColumnIndex(DBHandler.mobileNo)));
        userInfo.setEmailID(cursor.getString(cursor.getColumnIndex(DBHandler.emailID)));
        userInfo.setID(cursor.getInt(cursor.getColumnIndex(DBHandler.userID)));

        // close db connection
        db.close();
        // return notes list
        return userInfo;
    }

    public UserInfo getIsUserExist(String userName,String mobileNo)
    {
        UserInfo userInfo=new UserInfo();
        String selectQuery = "SELECT  * FROM " + TABLE_UserInfo +" where userName='" + userName +"' and mobileNo='"+ mobileNo +"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor !=null)
        {
            cursor.moveToFirst();

            userInfo.setUserName(cursor.getString(cursor.getColumnIndex(DBHandler.userName)));
            userInfo.setMobileNo(cursor.getString(cursor.getColumnIndex(DBHandler.mobileNo)));
            userInfo.setEmailID(cursor.getString(cursor.getColumnIndex(DBHandler.emailID)));
            userInfo.setID(cursor.getInt(cursor.getColumnIndex(DBHandler.userID)));

        }else {

            userInfo.setID(0);
        }
        return userInfo;
    }
}
