package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

public abstract class Task {

    private int stopValue;

    public int getStopValue() {
        return stopValue;
    }

    public void setStopValue(int stopValue) {
        this.stopValue = stopValue;
    }


    public abstract void run();

    public abstract void validate() throws ValidateException;



}
