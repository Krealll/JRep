package com.krealll.restservice.service;

public class DivisionResult {
    private int quotient;
    private int reminder;
    private Division division;

    public DivisionResult(Division division, int quotient, int reminder){
        this.quotient=quotient;
        this.reminder=reminder;
        this.division=division;
    }

    public DivisionResult(int dividend, int divider, int quotient, int reminder){
        this.quotient=quotient;
        this.reminder=reminder;
        this.division=new Division(dividend,divider);
    }

    public int getQuotient() {
        return quotient;
    }

    public int getReminder() {
        return reminder;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionResult result = (DivisionResult) o;
        return quotient==result.quotient&&reminder == result.reminder;
    }
}