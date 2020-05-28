package com.krealll.restservice.service;

import com.krealll.restservice.application.exceptions.BadArgumentsException;
import com.krealll.restservice.application.exceptions.ServerException;

public class Validator {

    static public boolean validate (int dividend , int divider)
        throws ServerException, BadArgumentsException {
        if(!checkDdt(divider)){
            throw new BadArgumentsException(String.format("Divider is %d. Wrong value",divider));
        }
        if (checkServerError(dividend,divider)){
            throw new ServerException(String.format("Fake Server Exception: dividend %d divider %d",dividend,divider));
        }
        else return true;
    }

    private  static  boolean checkDdt(int divider){
        return divider != 0;
    }

    private  static  boolean checkServerError(int dividend, int divider){ return dividend==4&&divider==2;}
}
