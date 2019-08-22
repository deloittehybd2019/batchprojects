package com.ems.util;

public class InvalidSalaryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4855588821300858696L;
	public InvalidSalaryException(String msg)
	{
		super(msg);
	}
	public InvalidSalaryException(String msg,Throwable e)
	{
		super(msg,e);
	}

}
