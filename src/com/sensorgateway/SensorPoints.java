package com.sensorgateway;
enum LEVEL
{
	HIGH,
	AVERAGE,
	LOW
}

public class SensorPoints {

	float x1, y1,x2, y2;
	
	public SensorPoints(float _x1, float _y1,float _x2, float _y2) 
	{
		x1 = _x1;
		y1 = _y1;
		x2 = _x2;
		y2 = _y2;		
	}
}
