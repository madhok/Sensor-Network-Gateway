package com.sensorgateway;

//import com.google.android.maps.OverlayItem;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.view.View;
import android.content.Intent;

import android.view.View.OnTouchListener;

@SuppressLint("DrawAllocation")
public class MainScreen extends Activity {
	
	private ImageView Imagebldg23;
	public final static int mButtonHeight = 100;
    public final static int mButtonWidth = 80;

	//public Canvas canvas;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_screen);
        Spinner s = (Spinner) findViewById(R.id.spinner1);
        String aParameters[] = getResources().getStringArray(R.array.parameters_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item , aParameters);
        s.setAdapter(adapter);
        Imagebldg23 =  (ImageView) findViewById(R.id.imageView1); 
        Imagebldg23.setOnTouchListener(new OnTouchListener() {
        	public boolean onTouch(View v, MotionEvent event) {
        		int x = (int) event.getX();
   		        int y = (int) event.getY();
   		     NextImage(v);
   		        return true;
        	}
        });
    }  
        
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_screen, menu);
        return true;
    }
    
    public void NextImage(View view) {
    	Intent intent = new Intent(this, DisplayAllActivity.class);
    	startActivity(intent);
    } 
    
    public void startOverlay(View view)
    {
    	MyImageView imageview = new MyImageView(this);
    	LinearLayout  mainLayout= (LinearLayout)findViewById(R.id.linearLayout1);
    	RelativeLayout overLayout = (RelativeLayout) mainLayout.findViewById(R.id.Relativelayout1);
    	overLayout.addView(imageview);
    	setContentView(mainLayout);
    }
}




 


