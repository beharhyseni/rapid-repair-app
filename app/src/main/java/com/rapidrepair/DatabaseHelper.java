package com.rapidrepair;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.annotation.Target;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "serviceUser.db";
    private static final String TABLE_NAME = "serviceuser";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_PASS = "password";

    public static String getColumnLocation() {
        return COLUMN_LOCATION;
    }

    private static final String COLUMN_LOCATION = "location";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table " + TABLE_NAME + " (id integer primary key not null , " +
            "name text not null , email text not null , phone integer not null , password text not null , location text not null);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertServiceUser(ServiceUser serviceUser) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from serviceuser";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(COLUMN_NAME, serviceUser.getName());
        values.put(COLUMN_EMAIL, serviceUser.getEmail());
        values.put(COLUMN_LOCATION, serviceUser.getLocation());
        values.put(COLUMN_PASS, serviceUser.getPassword());
        values.put(COLUMN_PHONE, serviceUser.getPhone());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String emailAddress) {
        db = this.getReadableDatabase();
        String query = "select email, password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String ea, pass;
        pass = "Password Not Found";
        if (cursor.moveToFirst()) {
            do {
                ea = cursor.getString(0);
                ;
                if (ea.equals(emailAddress)) {
                    pass = cursor.getString(1);
                    break;

                }

            }
            while (cursor.moveToNext());
        }
        return pass;
    }
}
