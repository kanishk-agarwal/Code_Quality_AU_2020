package com.pantry_management.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GenerateDate {
	public static Date generateDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("DD/MM/YYYY");
		String date = sdf.format(new Date());
		try {
		return sdf.parse(date);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return new Date();
	}
	public static Date generateDate30DaysBefore() {
		Date curr=new Date();
		Calendar c = Calendar.getInstance();
	    c.setTime(curr);
	    c.add(Calendar.MONTH, -1);
	    SimpleDateFormat sdf=new SimpleDateFormat("DD/MM/YYYY");
	    String ds=sdf.format(c.getTime());
	    try {
			return sdf.parse(ds);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return new Date();
	 }
}
