package com.ems.util;

public class InvalidLengthException extends Exception{

	public InvalidLengthException(String msg){
        super(msg);
    }

    public InvalidLengthException(String msg,Throwable e){
        super(msg,e);
    }

}
