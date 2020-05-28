package com.krealll.restservice.model;

public class DivisionResult {
    private int quotient;
    private int reminder;

    public DivisionResult( int quotient, int reminder){
        this.quotient=quotient;
        this.reminder=reminder;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionResult result = (DivisionResult) o;
        return quotient==result.quotient&&reminder == result.reminder;
    }
}