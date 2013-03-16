package com.sensorgateway;

import android.R.color;
import android.graphics.Color;


public class Temperature 
{
	public LEVEL level;
	public int color;
	public double value;
	public Temperature(String strCentigrade)
	{
		 value = Double.parseDouble( strCentigrade );
		 if(value <= 80)
		 {
			 level = LEVEL.LOW;
			 color = Color.BLUE;
		 }
		 else if(value < 100)
		 {
			 level = LEVEL.AVERAGE;
			 color = Color.GREEN;
		 }
		 else 
		 {
			 level = LEVEL.HIGH;
			 color = Color.RED;
		 } 
	}
}