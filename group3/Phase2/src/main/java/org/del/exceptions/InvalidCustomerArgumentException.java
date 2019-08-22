package org.del.exceptions;

public class InvalidCustomerArgumentException extends RuntimeException{

    public InvalidCustomerArgumentException(String msg){
        super(msg);
    }

    public InvalidCustomerArgumentException(String msg, Throwable ex){
        super(msg,ex);
    }

}
