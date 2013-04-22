package com.example.helloworld;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LogItem {
	@SuppressLint("SimpleDateFormat")
	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	public static enum Type {steering, speed};
	
	private Type type;
	private String discription;
	private Date date;
	
	public LogItem(Type type, String discription){
		this.type = type;
		this.discription = discription;
		this.date = Calendar.getInstance().getTime();
	}
	
	public String toString(){
		return "["+df.format(date)+"] ["+type+"] ["+discription+"]";
	}
	
	public static List<String> getEnumValues(){
		Type[] enumList = Type.values();
		List<String> returnList = new ArrayList<String>();
		for (Type t : enumList) {
			returnList.add(t.toString());
		}
		return returnList;
	}
	
	public String getType(){
		return type.toString();
	}
	public String getDiscription(){
		return discription;
	}
	public String getDate(){
		return df.format(date);
	}
}
