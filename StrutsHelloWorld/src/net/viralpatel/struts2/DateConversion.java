package net.viralpatel.struts2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateConversion {
	public static void main(String[] args) throws Exception{
		String PATTERN="dd-MMM-yy";
		SimpleDateFormat dateFormat=new SimpleDateFormat();
		dateFormat.applyPattern(PATTERN);
		String date1=dateFormat.format(Calendar.getInstance().getTime());
		System.out.println(date1);
	}

}
