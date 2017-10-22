package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//  (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    //  (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"
    public static final String DATABASE_NAME = "waitlist.db";

    //  (3) Create a static final int called DATABASE_VERSION and set it to 1
    public static final int DATABASE_VERSION = 1;

    //  (4) Create a Constructor that takes a context and calls the parent constructor
    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //  (5) Override the onCreate method
    @Override
    public void onCreate(SQLiteDatabase db) {
        // (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table
        String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " +
                WaitlistContract.WaitlistEntry.TABLE_NAME + " (" +
                WaitlistContract.WaitlistEntry._ID + " INTEGER PRIMARY_KEY AUTO_INCREMENT, " +
                WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME + " STRING NOT NULL, " +
                WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE + " INTEGER NOT NULL, " +
                WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                ")";

        // (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    // TODO (8) Override the onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // (9) Inside, execute a drop table query, and then call onCreate to re-create it
        String SQL_DROP_WAITLIST_TABLE = "DROP TABLE IF EXISTS " +
                WaitlistContract.WaitlistEntry.TABLE_NAME;

        db.execSQL(SQL_DROP_WAITLIST_TABLE);
        onCreate(db);
    }

}