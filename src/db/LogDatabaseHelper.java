package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LogDatabaseHelper extends SQLiteOpenHelper{
	private static final String DBname = "logDB";
	private final String DATABASE_CREATE = "create table "
		+ DBname 
		+ "(" 
		+ "Date text, "
		//+ "Type text, "
		//+ "Discription text "
		+ ");";
	
	public LogDatabaseHelper(Context context){
		super(context, DBname+"File.db", null, 1);
		//super(context, Environment.getExternalStorageDirectory()+"/log/log.db", null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + DBname);
		onCreate(db);
	}
	
	public String getDBname(){
		return DBname;
	}
}