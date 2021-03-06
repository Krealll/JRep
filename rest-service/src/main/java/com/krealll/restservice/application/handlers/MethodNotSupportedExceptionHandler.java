package com.krealll.restservice.application.handlers;

import com.krealll.restservice.application.exceptions.MethodNotSupportedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Deprecated
public class MethodNotSupportedExceptionHandler implements ExceptionMapper<MethodNotSupportedException> {

        private static Logger logger = LogManager.getLogger(MethodNotSupportedExceptionHandler.class);

        @Deprecated
        @Override
        @ExceptionHandler(MethodNotSupportedException.class)
        public ResponseEntity<?> handle (MethodNotSupportedException e){
                logger.error(e.getMessage());
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(String.format("{\"error\":\"%s\"}", e.getMessage()));
        }
}
