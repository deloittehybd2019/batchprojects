package org.del.exceptions;

public class InvalidArgumentException extends RuntimeException {

    public InvalidArgumentException(String msg) {
        super(msg);
    }


    public InvalidArgumentException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
