package com.krealll.restservice.application.handlers;

import org.springframework.http.ResponseEntity;

public interface ExceptionMapper<T> {
    ResponseEntity<?> handle(T exceptionType);
}
