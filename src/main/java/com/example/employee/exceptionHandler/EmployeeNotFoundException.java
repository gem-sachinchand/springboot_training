package com.example.employee.exceptionHandler;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String s) {
        super(s);
    }
}
