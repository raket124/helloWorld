package com.example.helloworld;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LogDatabase {
	private SQLiteDatabase database;
	private LogDatabaseHelper dbHelper;
	private String[] allColumns = { 
			LogDatabaseHelper.COLUMN_DATE,
			LogDatabaseHelper.COLUMN_TYPE,
			LogDatabaseHelper.COLUMN_DISCRIPTION};

	public LogDatabase(Context context) {
		dbHelper = new LogDatabaseHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
}
