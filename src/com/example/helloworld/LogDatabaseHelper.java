package com.example.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

public class LogDatabaseHelper extends SQLiteOpenHelper {

	public static final String DATABASE_LOCATION = Environment.getExternalStorageDirectory()+"/log/";
	public static final String DATABASE_FILE_NAME = "commments.db";
	public static final String TABLE_NAME = "logger";

	
	public static final String COLUMN_DATE = "Date";
	public static final String COLUMN_DISCRIPTION = "Discription";
	public static final String COLUMN_TYPE = "Type";

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_NAME 
			+ "( " 
			+ COLUMN_DATE + " text, " 
			+ COLUMN_TYPE + " text" 
			+ COLUMN_DISCRIPTION + " text, " 
			+ ");";

	public LogDatabaseHelper(Context context) {
		super(context, DATABASE_LOCATION+DATABASE_FILE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

}
