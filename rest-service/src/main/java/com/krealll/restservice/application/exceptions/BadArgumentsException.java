package com.krealll.restservice.application.exceptions;

public class BadArgumentsException extends RuntimeException {
    public BadArgumentsException(String reason){super(reason);}
}
