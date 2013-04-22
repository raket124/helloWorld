package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LogDatabase {
	private SQLiteDatabase database;
	private LogDatabaseHelper dbHelper;
	  
	public LogDatabase(Context context) {
		dbHelper = new LogDatabaseHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public String createComment(String input) {
		
		
		ContentValues values = new ContentValues();
	    values.put("Date", input);
	    long insertId = database.insert(dbHelper.getDBname(), null,values);
		
		/*
		String queryString = "INSERT INTO "+dbHelper.getDBname()+" (Date, Type, Discription) VALUES ";
		for (int i = 0; i < input.size(); i++) {
			queryString += "(";
			queryString += input.get(i).getDate()+",";
			queryString += input.get(i).getType()+",";
			queryString += input.get(i).getDiscription();
			queryString += "),";
		}
		*/
		
		//database.execSQL(queryString.substring(0, queryString.length()-1));
		//database.insert(dbHelper.getDBname(), null, values)
		//return queryString.substring(0, queryString.length()-1);
		/*
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
		long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null, values);
		Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS, allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
		cursor.moveToFirst();
		Comment newComment = cursorToComment(cursor);
		cursor.close();
		return newComment;
		*/
		return "";
	}
	
}
