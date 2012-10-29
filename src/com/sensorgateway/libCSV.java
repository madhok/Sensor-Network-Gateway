package com.sensorgateway;

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
}


