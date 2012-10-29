package com.sensorgateway;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class MyImageView extends View{

    public MyImageView(Context context) {
        super(context);
    }
    
    @Override
    public void onDraw(Canvas canvas) {
 	   Paint paint = new Paint();
        paint.setColor(Color.RED);   
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        SensorPoints[] myPath = { new SensorPoints(100, 100),new SensorPoints(200, 200),
					new SensorPoints(200, 500),new SensorPoints(400, 500),
					new SensorPoints(400, 200)};

		path.moveTo(myPath[0].x, myPath[0].y);
		for (int i = 1; i < myPath.length; i++){
			path.lineTo(myPath[i].x, myPath[i].y);
		}
		canvas.drawPath(path, paint);
    }

}
