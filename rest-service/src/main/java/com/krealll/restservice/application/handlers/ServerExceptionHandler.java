package com.krealll.restservice.application.handlers;

import com.krealll.restservice.application.exceptions.ServerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServerExceptionHandler implements ExceptionMapper<ServerException> {

    private static Logger logger = LogManager.getLogger(ServerExceptionHandler.class);

    @Override
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<?> handle (ServerException e){
        logger.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(String.format("{\"error\":\"%s\"}", e.getMessage()));
    }
}
