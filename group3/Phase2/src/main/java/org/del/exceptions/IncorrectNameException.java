package org.del.exceptions;

public class IncorrectNameException extends RuntimeException {

    public IncorrectNameException(String name){
        super(name);
    }


    public IncorrectNameException(String name,Throwable ex){
        super(name,ex);
    }

}
