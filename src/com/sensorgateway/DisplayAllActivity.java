package com.sensorgateway;

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
		//set Room data
		//Room.setRoomdata(objCSV.datas);
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
