package com.ems.util;

public class InvalidLengthException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3463464943079121836L;
	public InvalidLengthException(String msg)
	{
		super(msg);
	}
	public InvalidLengthException(String msg,Throwable e)
	{
		super(msg,e);
	}
}
