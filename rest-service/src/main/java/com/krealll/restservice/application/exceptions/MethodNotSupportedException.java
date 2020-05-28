package com.krealll.restservice.application.exceptions;

@Deprecated
public class MethodNotSupportedException extends RuntimeException {
    public MethodNotSupportedException(String reason){super(reason);}
}
