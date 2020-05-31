package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 extends Task {

    private int number;

    public Task1(){}

    @Override
    public void run() {
        try {
            setStopValue(0);
            validate();
            while (number != getStopValue()) {
                System.out.println(task1Helper(number));
                validate();
            }
        }
        catch (RuntimeException e){
            System.out.println(String.format("In method run: %s",Task1.class));
            throw e;
        }

    }

    private int task1Helper(int number){
        return ((number%10)*(number%10))%10;
    }


    @Override
    public void validate() throws ValidateException {

        try {
            Scanner in = new Scanner(System.in);
            number = in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            throw new ValidateException("Validate exception");
        }

    }


}
