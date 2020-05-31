package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 extends Task {

    private int area;

    public Task3(){}

    @Override
    public void run() {
        try {
            setStopValue(0);
            validate();
            while (area != getStopValue()) {
                task3Helper();
                validate();
            }
        }
        catch (RuntimeException e){
            System.out.println(String.format("In method run: %s",Task3.class));
            throw e;
        }
    }

    private void task3Helper() {
        System.out.println(String.format("Area of second square is %d and it's %d times less than first square",area/2,2));
    }

    @Override
    public void validate() throws ValidateException {

        try {
            Scanner in = new Scanner(System.in);
            area = in.nextInt();
            if ( area<0)
                throw new ValidateException("Invalid argument");
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            throw new ValidateException("Invalid argument");
        }

    }

}
