package com.ems.util;

public class InvalidSalaryException extends RuntimeException {
    public InvalidSalaryException(String msg) {
        super(msg);
    }

    public InvalidSalaryException(String msg, Throwable e) {
        super(msg, e);
    }
}
