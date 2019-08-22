package com.ems.util;

public class InvalidDateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2876942908390087200L;
	public InvalidDateException(String msg)
	{
		super(msg);
	}
	public InvalidDateException(String msg,Throwable e)
	{
		super(msg,e);
	}
	
}
