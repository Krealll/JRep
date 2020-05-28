package com.krealll.restservice.service;

import com.krealll.restservice.application.handlers.MethodNotSupportedExceptionHandler;
import com.krealll.restservice.model.DivisionResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService  {

    private static Logger logger = LogManager.getLogger(MethodNotSupportedExceptionHandler.class);
    @Autowired
    DivisionCacher<DivisionResult> cacher;
    @Autowired
    Counter RequestCounter;

    public DivisionResult getDivisionResult(int dividend, int divider){
        return new DivisionResult(calculateQuotient(dividend,divider), calculateReminder(dividend,divider));
    }

    public DivisionResult formResponse(int dividend, int divider){
        Validator.validate(dividend,divider);
        RequestCounter.increment();
        logger.info("Successful division:dividend {} divider {}",dividend,divider);
        return cacheData(dividend,divider);
    }

    private DivisionResult cacheData(int dividend, int divider){
        DivisionResult result = cacher.contains(dividend,divider)?
                cacher.get(dividend,divider):
                cacher.put(dividend,divider,getDivisionResult(dividend,divider));
        return result;
    }

    public int calculateQuotient(int dividend, int divider){
        return dividend/divider;
    }

    public int calculateReminder(int dividend, int divider){
        return dividend%divider;
    }

    public int getRequestCounter() {
        return RequestCounter.getCounter();
    }
}
