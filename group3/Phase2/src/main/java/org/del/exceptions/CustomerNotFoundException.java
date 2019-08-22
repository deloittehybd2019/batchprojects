package org.del.exceptions;

public class CustomerNotFoundException  extends Exception{

    public CustomerNotFoundException(String msg){
        super(msg);
    }

    public CustomerNotFoundException(String msg,Throwable e){
        super(msg,e);
    }

}
