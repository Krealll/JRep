package com.krealll.restservice.model;

public class DivisionResult {
    private Integer quotient;
    private Integer reminder;

    public DivisionResult( int quotient, int reminder){
        this.quotient=quotient;
        this.reminder=reminder;
    }

    public Integer getQuotient() {
        return quotient;
    }

    public Integer getReminder() {
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