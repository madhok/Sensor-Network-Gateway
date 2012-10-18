package com.sensorgateway;

import java.io.Serializable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;


//import android.view.Menu;
//import android.content.Intent;
import android.content.Intent;

public class DisplayAllActivity extends Activity {
	
	public static libCSV objCSV =  new libCSV();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_parameter);
        //Temporary CSV file data 
        setdata();
        
    } 
    
    public void setdata()
    {
		 String csvFile = "1,NASA Ames Research Center,0,80,100,50," +
						 "2,Sustainability Base,2, 75, 109, 60," +
						 "3,North Building,3, 85, 106,105," +
						 "4, Heating Zone,3, 100, 110,95," +
					     "5, Floor 0 Cooling Zone,4, 90, 116,80," +
					     "6, Meeting Room 0 Lighting Zone,5, 80, 96,85," +
					     "7, Meeting Room 1 Lighting Zone,6, 65, 86,100," +
					     "8, Meeting Room 2 Lighting Zone,7, 105, 108,95," +
					     "9, Meeting Room 3 Lighting Zone,8, 95, 100,90";
		
		objCSV.readCSV(csvFile);
		// set the button data
		Button btnTemperature = (Button) findViewById(R.id.btnTemperature);        
		btnTemperature.setText(objCSV.datas[objCSV.datas.length - 1].centigrade.toString()); 
		
		Button btnPressure = (Button) findViewById(R.id.btnPressure);        
		btnPressure.setText(objCSV.datas[objCSV.datas.length - 1].kPascals.toString()); 
		
		Button btnLight = (Button) findViewById(R.id.btnLight);        
		btnLight.setText(objCSV.datas[objCSV.datas.length - 1].lux.toString()); 
    }
    
    public void OnBack(View view) {
    	Intent intent = new Intent(this, MainScreen.class);
    	startActivity(intent);
    }
    
    public void OnRefresh(View view) {
    	this.recreate();    	
    }
    
    public void OnTemperature(View view) {
    	Intent intent = new Intent(this, TemperatureActivity.class);
    	startActivity(intent);
    }
    
    public void OnPressure(View view) {
    	Intent intent = new Intent(this, PressureActivity.class);
    	startActivity(intent);
    }
    
    public void OnLight(View view) {
    	Intent intent = new Intent(this, LightActivity.class);
    	startActivity(intent);
    }
}
