package com.sensorgateway;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

public class LightActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        
        GraphViewData[] graphdatas = new GraphViewData[DisplayAllActivity.objCSV.datas.length]; 
    	for(int i = 0; i < graphdatas.length; i++)
    	{
    		graphdatas[i] = new GraphViewData(i,Double.parseDouble(DisplayAllActivity.objCSV.datas[i].lux));
    	}
    	GraphViewSeries exampleSeries = new GraphViewSeries(graphdatas);
        

        GraphView graphView = new LineGraphView(this // context
        		, "Light" // heading
        );
        graphView.addSeries(exampleSeries); // data

        LinearLayout layout = (LinearLayout) findViewById(R.id.GraphViewlay);
        layout.addView(graphView); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_light, menu);
        return true;
    }
    
    public void OnBack(View view) {
    	Intent intent = new Intent(this, DisplayAllActivity.class);
    	startActivity(intent);
    }
    
    public void OnRefresh(View view) {
    	this.recreate();    	
    }
}
