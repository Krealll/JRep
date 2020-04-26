package com.example.restservice;

public class Division {
    private Integer quotient;
    private Integer reminder;

    public Division (Integer quo, Integer rem){
        this.quotient=quo;
        this.reminder=rem;
    }

    public Integer getQuotient() {
        return quotient;
    }

    public Integer getReminder() {
        return reminder;
    }

    public void setQuotient(Integer quotient) {
        this.quotient = quotient;
    }

    public void setReminder(Integer reminder) {
        this.reminder = reminder;
    }
}