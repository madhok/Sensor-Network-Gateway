package com.sensorgateway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.StrictMode;
import android.util.Log;

public class libCSV  
{
	public bldgdata [] datas;
			
	public  Boolean readCSV(String strCSVPath )
	{
		int row = 0;
		String[] temp;
		String delimiter = ",";
		temp = strCSVPath.split(delimiter);
		datas = new bldgdata[temp.length/bldgdata.nFIELDS];
		for(int i = 0; i < temp.length; row++)		
		{				
			datas[row] = new bldgdata();
			//get next token and store it in the array
			datas[row].nReadingid = row + 1;
			datas[row].localityID = temp[i++].toString();
			datas[row].name = temp[i++].toString();
			datas[row].parentLocalityId = temp[i++].toString();
			datas[row].centigrade = temp[i++].toString();	
			datas[row].lux = temp[i++].toString();
			datas[row].kPascals = temp[i++].toString();
			
		}
		return true;
	}
	
	private String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
	
	public void readValues()
	{
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 		
		
		HttpClient httpclient = new DefaultHttpClient();		 
		String url = "http://cmu-sds.herokuapp.com/sensor_readings/23100015?start_time=1359581004000&end_time=1359582134000&tuples=4";
        HttpGet httpget = new HttpGet(url); 
        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                result = result.substring(0, result.length()-1);
                JSONArray rows = new JSONArray(result); // Get all JSONArray rows
                datas = new bldgdata[rows.length()];
                for(int i=0; i < rows.length(); i++) { // Loop over each each row
                    datas[i] = new bldgdata();
                	JSONObject row = rows.getJSONObject(i); // Get row object
                    datas[i].id = row.getString("id");
                    datas[i].loc = row.getString("loc"); // Get duration sub object
                    datas[i].average_timestamp = row.getString("average_timestamp"); // Get distance sub object
                    datas[i].first = row.getString("first");
                    datas[i].last = row.getString("last");
                    datas[i].min = row.getString("min");
                    datas[i].max = row.getString("max");
                    datas[i].average = row.getString("average");
                }
            }
 
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}


