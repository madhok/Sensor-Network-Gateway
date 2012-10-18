package com.sensorgateway;

//import com.google.android.maps.OverlayItem;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.view.View;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View.OnTouchListener;

public class MainScreen extends Activity {

	
	private ImageView Imagebldg23;
	private Bitmap mBitmap;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        
        Spinner s = (Spinner) findViewById(R.id.spinner1);
        String aParameters[] = getResources().getStringArray(R.array.parameters_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item , aParameters);
        s.setAdapter(adapter);
        
        ImageView imageView = (ImageView) findViewById(R.id.imageView1);
        imageView.setOnTouchListener(new OnTouchListener() {
        	public boolean onTouch(View v, MotionEvent event) {
        		int x = (int) event.getX();
   		        int y = (int) event.getY();
   		     NextImage(v);
   		        return true;
        	}
        });
        Imagebldg23 = (ImageView)findViewById(R.id.imageView1);	
        
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither= false;       
        options.inInputShareable=true;
        options.inTempStorage=new byte[8*1024];

       mBitmap =BitmapFactory.decodeResource(MainScreen.this.getResources(),R.drawable.first_floor, options);
       Imagebldg23.setImageBitmap(mBitmap);
        
//        View overlay = (View) findViewById(R.id.overlay);
//        int opacity = 200; // from 0 to 255
//        overlay.setBackgroundColor(0xFFFFFF00); // yellow
//        LinearLayout.LayoutParams params =
//            new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, 100);
//        params.gravity = Gravity.BOTTOM;
//        overlay.setLayoutParams(params);
//        overlay.invalidate(); // update the view
        
//        Resources r = getResources();
//        Drawable[] layers = new Drawable[2];
//        layers[0] = r.getDrawable(R.drawable.first_floor);
//        layers[1] = r.getDrawable(R.drawable.second_floor);
//        LayerDrawable layerDrawable = new LayerDrawable(layers);
//        Imagebldg23.setImageDrawable(layerDrawable);
//        
        
        //List<Overlay> mapOverlays = Imagebldg23.getOverlays();
       // Drawable drawable = this.getResources().getDrawable(R.drawable.first_floor);
       // MapItemizedOverlay itemizedoverlay = new MapItemizedOverlay(drawable, this);
       // Point point = new Point();
       // OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
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
    
    
  
}


 

