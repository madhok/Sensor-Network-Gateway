package com.sensorgateway;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

public class TemperatureActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);   	
    	setContentView(R.layout.activity_temperature);
    	
    	GraphViewData[] graphdatas = new GraphViewData[DisplayAllActivity.objCSV.datas.length]; 
    	for(int i = 0; i < graphdatas.length; i++)
    	{
    		graphdatas[i] = new GraphViewData(i,Double.parseDouble(DisplayAllActivity.objCSV.datas[i].centigrade));
    	}
    	GraphViewSeries exampleSeries = new GraphViewSeries(graphdatas);
        
        GraphView graphView = new LineGraphView(this // context
        		, "Temperature" // heading
        );
        
       // graphView.setVerticalLabels(new String[] {"high", "middle", "low"});  
        graphView.addSeries(exampleSeries); // data
        
        LinearLayout layout = (LinearLayout) findViewById(R.id.GraphViewlay);
        layout.addView(graphView);  
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_temperature, menu);
        return true;
    }
    
    public void OnBack(View view) {
    	Intent intent = new Intent(this, DisplayAllActivity.class);
    	startActivity(intent);
    }
    
    public void OnRefresh(View view) {
    	this.recreate();    	
    }
    
    public String getURIvalues(Uri urlpath)
    {   	
    	Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.google.com"));
    	String strCSV = "";
    	return strCSV;
    }
}
