package com.sensorgateway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class MyImageView extends View{

	//String csvFile = "'foo':'bar','coolness':2.0, 'altitude':39000,'pilot':{'firstName':'Buzz','lastName':'Aldrin'},'mission':'apollo 11'";
	
	/*String csvFile = "27,Room114,0,60,40,50," +
					 "28,Room115,0,90,40,50," +
			 		 "29,Room116,2,75,90,60," +
					 "1,Room107,3,85,70,105," +
					 "3,Room109,3,100,120,95," +
				     "4,Room110,4,90,46,80," +
				     "5,RoomW,5,90,96,85," +
				     "6,RoomStairs,6,65,136,100," +
				     "7,RoomM,7,105,68,95," +
				     "8,Room121,8,95,100,90," +
				     "9,RoomKitchen,7,105,68,95," +
				     "10,Room118,7,95,68,95," +
				     "11,Room117,7,45,68,95," +
				     "12,Room117L,7,95,68,95,";
    
	*/
	
	
	public MyImageView(Context context) {
        super(context);
        
    }
    
    @Override
    public void onDraw(Canvas canvas) {
    	int n = 0;
    	Path path = null;
		Paint paint = null;
    	//DisplayAllActivity.objCSV.readCSV(csvFile);
		
    	DisplayAllActivity.objCSV.readValues();
    	while(DisplayAllActivity.objCSV.datas.length != n)
    	{
    		Room.CreateRoom(DisplayAllActivity.objCSV.datas[n]);
    		n++;
    	}
    	
    	for (int i = 1; i <= Room.roomCount; i++)
		{
			path = new Path();
			paint = new Paint();
			path.moveTo(Room.Rooms[i].sensorPoint.x1, Room.Rooms[i].sensorPoint.y1);
			paint.setStrokeWidth(5);
	        paint.setStyle(Paint.Style.STROKE);
	        paint.setColor(Room.Rooms[i].temperature.color);
			path.lineTo(Room.Rooms[i].sensorPoint.x2, Room.Rooms[i].sensorPoint.y2);
			canvas.drawPath(path, paint);
			
		}      
        
       /* SensorPoints[] myPath = { Room.Room114,	Room.Room116, Room.Room107,
        						  Room.Room109,Room.Room110, Room.RoomW,Room.RoomStairs,
        						  Room.RoomM,Room.Room121, Room.RoomKitchen, Room.Room118,
        						  Room.Room117,Room.Room117L,Room.Room120,Room.Room122,
        						  Room.Room123,Room.Room126, Room.RoomLobby,Room.Room104,
        						  Room.Room105, Room.RoomLobby,Room.Room129,Room.Room129M,
        						  Room.Room129A,Room.Room129B};

        */
    	
		
    }
    
}
