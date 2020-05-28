package com.krealll.restservice.application.handlers;

import com.krealll.restservice.application.exceptions.BadArgumentsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


@RestControllerAdvice
public class BadArgumentsExceptionHandler implements ExceptionMapper<BadArgumentsException> {

    private static Logger logger = LogManager.getLogger(BadArgumentsExceptionHandler.class);

    @Override
    @ExceptionHandler(BadArgumentsException.class)
    public ResponseEntity<?> handle (BadArgumentsException e){
        logger.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(String.format("{\"error\":\"%s\"}", e.getMessage()));
    }
}