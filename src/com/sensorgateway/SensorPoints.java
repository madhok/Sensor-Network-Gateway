package com.sensorgateway;
enum LEVEL
{
	HIGH,
	AVERAGE,
	LOW
}

public class SensorPoints {

	float x, y;
	
	public SensorPoints(float _x, float _y) {
		x = _x;
		y = _y;
	}
}
