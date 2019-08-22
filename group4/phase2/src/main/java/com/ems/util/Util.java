package com.ems.util;

import java.sql.Date;
import java.time.LocalDate;

public class Util {

	public LocalDate convert(Date date) {
    LocalDate localdate=LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
	return localdate;
	}
	public Date convert(LocalDate date){
		Date desiredDate=new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
		return desiredDate;
		}

}
