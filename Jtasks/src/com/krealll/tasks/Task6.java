package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Task6 extends Task{

    private int seconds;
    private static final int MINUTES_IN_DAY=3600;
    private static final int SECONDS_IN_MINUTE=60;

    public Task6(){}

    @Override
    public void run() {
        try {
            setStopValue(0);
            validate();
            while (seconds != getStopValue()) {
                task6Helper();
                validate();
            }
        }
        catch (RuntimeException e){
            System.out.println(String.format("In method run: %s",Task6.class));
            throw e;
        }
    }

    @Override
    public void validate() throws ValidateException {

        try {
            Scanner in = new Scanner(System.in);
            seconds = in.nextInt();
            if (seconds<0)
                throw new ValidateException("Invalid seconds argument");
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            throw new ValidateException("Invalid argument");
        }
    }

    private void task6Helper() {
        System.out.println(String.format("Hours:%d, minutes:%d,seconds:%d"
                ,seconds/MINUTES_IN_DAY,(seconds%MINUTES_IN_DAY)/SECONDS_IN_MINUTE
                ,((seconds%MINUTES_IN_DAY)%SECONDS_IN_MINUTE)));
    }
}
