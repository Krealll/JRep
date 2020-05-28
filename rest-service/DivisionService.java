package com.example.restservice;

public class DivisionService {

    Division divide(Integer dividend, Integer divider){
        return new Division(dividend/divider, dividend%divider);
    }

}
