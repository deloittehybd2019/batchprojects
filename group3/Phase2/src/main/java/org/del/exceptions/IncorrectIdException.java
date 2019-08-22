package org.del.exceptions;


public class IncorrectIdException extends RuntimeException{

    public IncorrectIdException(String msg){
        super(msg);
    }

    public IncorrectIdException(String msg,Throwable e){
        super(msg,e);
    }
}
