package br.com.usb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormateDate {
	
	 String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	

	
	public String ConvertDateToString(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		
		String stringDate = sdf.format(date);
		
		return stringDate;
	}
	
	
	public Date ConvertStringToDate(String stringDate){
		
		 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		 
		 Date date = null;
		 
		try {
			
			date = sdf.parse(stringDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return date;
		
	}
	
	public String getStringCurrentDate() {
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		Date today = Calendar.getInstance().getTime(); 
		
		String reportDate = df.format(today);
		
		return reportDate;
	}
	
	public String formaterData(String data) {
		
		return data.replace("T"," ");
		
	}
	
	public String getCurrentDateTOString() {
		
		Date date = new Date();
		
		String dateNow = ConvertDateToString(date);
		
		return dateNow;
	}
	

}

