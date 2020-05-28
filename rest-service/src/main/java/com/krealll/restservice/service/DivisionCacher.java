package com.krealll.restservice.service;

import com.krealll.restservice.model.DivisionResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class DivisionCacher <T extends DivisionResult> {

    private static Logger logger = LogManager.getLogger(DivisionCacher.class);
    private HashMap<String,T> divisionDataBase;

    public DivisionCacher(){divisionDataBase= new HashMap<>();}

    public T get(int dividend, int divider){
        return get(toKey(dividend,divider));
    }

    public T put (int dividend, int divider, T result){
        return put(toKey(dividend,divider),result);

    }

    public boolean contains (int dividend, int divider){
        return contains(toKey(dividend,divider));
    }

    private boolean contains(String key){
        if (divisionDataBase.containsKey(key))
        {
            logger.info("Returned existing division: {}",key);
            return true;
        }
        else
            return false;
    }

    private T get(String key){
        return divisionDataBase.get(key);
    }

    private T put(String key,T divisionResult){
        logger.info("Added new element with key: {}",key);
        divisionDataBase.put(key,divisionResult);
        return divisionResult;
    }

    String toKey(int first, int second){
        return String.format("%s_%s",first,second);
    }


}
