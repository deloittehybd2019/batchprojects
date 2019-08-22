package com.ems.util;

public class EmployeeNotFoundException extends Exception {


    public EmployeeNotFoundException(String msg) {
        super(msg);
    }

    public EmployeeNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }

}
