package com.ems.util;

public class InvalidDateException extends Exception{
	public InvalidDateException(String msg){
        super(msg);
    }

    public InvalidDateException(String msg,Throwable e){
        super(msg,e);
    }

}
