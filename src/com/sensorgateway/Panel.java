package com.sensorgateway;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

class NewPanel extends View {
    public NewPanel(Context context, Canvas canvas) {
        super(context);
        //canvas.drawColor(Color.BLACK);
        //canvas.drawBitmap(_scratch, 10, 10, null);
       
        //canvas.drawCircle(20, 50, 25, paint);
    }

    @Override
    public void onDraw(Canvas canvas) {
        //Bitmap _scratch = BitmapFactory.decodeResource(getResources(), R.layout.activity_main_screen);
        canvas.drawColor(Color.BLACK);
        //canvas.drawBitmap(_scratch, 10, 10, null);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(20, 50, 25, paint);
    }
}

public class Panel extends View implements SurfaceHolder.Callback{

	private CanvasThread canvasthread;
	
	 public Panel(Context context) {
         super(context/*, attrs*/);
         // TODO Auto-generated constructor stub
//     getHolder().addCallback(this);
//     canvasthread = new CanvasThread(getHolder(), this, mainscreen);
     setFocusable(true);
 }

	 public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	        // TODO Auto-generated method stub
	 }
	 
	    
    public void surfaceCreated(SurfaceHolder holder)
    {
    	canvasthread.setRunning(true);
        canvasthread.start();
    }
 
    public void surfaceDestroyed(SurfaceHolder holder)
    {
    	boolean retry = true;
        canvasthread.setRunning(false);
        while (retry) {
                try {
                        canvasthread.join();
                        retry = false;
                } catch (InterruptedException e) {
                        // we will try it again and again...
                }
        }
    }
    
    @Override
	protected
    void onDraw(Canvas canvas) {
        
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(20, 50, 25, paint);


        Bitmap kangoo = BitmapFactory.decodeResource(getResources(),
                        R.drawable.first_floor);
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(kangoo, 10, 10, null);
       
    }

}
