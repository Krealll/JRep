package com.krealll.restservice.service;

import com.krealll.restservice.application.handlers.MethodNotSupportedExceptionHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DivisionService implements DivisionServiceInterface {

    private static Logger logger = LogManager.getLogger(MethodNotSupportedExceptionHandler.class);

    public DivisionResult getDivisionResult(int dividend, int divider){
        return new DivisionResult(new Division(dividend,divider), calculateQuotient(dividend,divider), calculateReminder(dividend,divider));
    }

    public DivisionResult formResponse(int dividend, int divider){
        Validator.validate(dividend,divider);
        logger.info("Successful division:dividend {} divider {}",dividend,divider);
        return getDivisionResult(dividend,divider);
    }

    public int calculateQuotient(int dividend, int divider){
        return dividend/divider;
    }

    public int calculateReminder(int dividend, int divider){
        return dividend%divider;
    }

}
