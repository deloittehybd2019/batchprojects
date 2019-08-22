package com.ems.util;
import java.sql.Date;
import java.time.LocalDate;
public class Util {
	
	public static LocalDate convert(Date date)
	{
		LocalDate localDate=LocalDate.of(date.getYear(),date.getMonth(),date.getDay());
		return localDate;
	}
	
	public static Date convert(LocalDate date)
	{
		Date desired=new Date(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
		return desired;
	}

}
