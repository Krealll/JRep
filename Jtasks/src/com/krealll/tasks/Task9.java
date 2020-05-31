package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task9 extends Task {

    private int radius;

    public Task9(){}

    @Override
    public void run() {
        try {
            setStopValue(0);
            validate();
            while (radius!=getStopValue()) {
                task9Helper();
                validate();
            }
        }
        catch (RuntimeException e){
            System.out.println(String.format("In method run: %s",Task9.class));
            throw e;
        }
    }

    @Override
    public void validate() throws ValidateException {
        try {
            Scanner in = new Scanner(System.in);
            radius=in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            throw new ValidateException("Invalid argument");
        }
    }

    private void task9Helper() {
            System.out.println(String.format("Length of circle is: %f \n Area is: %f"
                    ,calculateCircleLength(radius),calculateCircleLength(radius)));
    }

    private double calculateCircleLength(int radius){
        return radius*2*Math.PI;
    }

    private double calculateCircleArea(int radius){
        return Math.PI*radius*radius;
    }
}
