package com.example.helloworld;


import java.util.ArrayList;
import java.util.List;

import db.LogDatabase;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	AlertDialog alertDialog;
	Logger log;
	Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        
        log = new Logger();
        
    	
        spinner = (Spinner) findViewById(R.id.my_spinner);
    	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, LogItem.getEnumValues());
    	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner.setAdapter(dataAdapter);
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
    	
    	EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

    	LogItem a = new LogItem(LogItem.Type.valueOf((String)spinner.getSelectedItem()), message);
    	editText.setText("");
    	log.append(a);
    	alertDialog.setMessage("logged");
		alertDialog.show();

    }
    
    public void showMessage(View view) {
    	alertDialog.setMessage(log.toString());
		alertDialog.show();
    }
    public void cleanMessage(View view) {
    	log.cleanLogFile();
    	alertDialog.setMessage("Cleaned");
		alertDialog.show();
    }
    public void pushMessage(View view) {
    	log.flush();
    	alertDialog.setMessage("Worked");
		alertDialog.show();
    }
    
}
