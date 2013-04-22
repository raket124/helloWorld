package com.example.helloworld;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;

public class Logger {
	
	private List<LogItem> list;
	private File logFile;
	public Logger(){
		list = new ArrayList<LogItem>();
		
		try{
	    	File dir = new File(Environment.getExternalStorageDirectory()+"/log");
	    	if (!dir.exists()){
	    		dir.mkdirs();
	    	}
	    	logFile = new File(dir,"log.txt");
	    	if(!logFile.exists()){
	    		logFile.createNewFile();
	    	}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void append(LogItem logItem){
		list.add(logItem);
	}
	
	public void flush(){
		try
		{
	    	FileWriter fw = new FileWriter(logFile, true);
	    	for (LogItem item : list) {
	    		fw.append(item.toString()+"\n");
			}
	    	fw.flush();
	    	fw.close();
	    	cleanCurrentLogItems();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void cleanCurrentLogItems(){
		list = new ArrayList<LogItem>();
	}
	
	public void cleanLogFile(){
		try{
			FileWriter fw = new FileWriter(logFile);
			fw.write("");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String toString(){
		String input = "";
		String logFileLocation = "log file location: "+logFile.getAbsolutePath();
		String line = ""; for (int i = 0; i < logFileLocation.length(); i++) { line += "_"; }
		
		input += "log\n";
		input += logFileLocation+"\n";
		input += line+"\n";
    	for (LogItem item : list) {
    		input+=item.toString()+"\n";
		}
		return input;
	}
}
