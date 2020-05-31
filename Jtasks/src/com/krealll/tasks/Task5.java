package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task5 extends Task{

    private int number;

    public Task5(){}

    @Override
    public void run() {
        try {
            setStopValue(0);
            validate();
            while (number != getStopValue()) {
                task5Helper();
                validate();
            }
        }
        catch (RuntimeException e){
            System.out.println(String.format("In method run: %s",Task5.class));
            throw e;
        }
    }


    @Override
    public void validate() throws ValidateException {

        try {
            Scanner in = new Scanner(System.in);
            number = in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            throw new ValidateException("Invalid argument");
        }
    }

    private void task5Helper() {
        int result = 0,n=number,flag = 0;
        for(int i = 2; i < number; i++)
        {
            while (n % i == 0) {
                n/= i;
                flag =1;
            }
            n=number;
            if(flag==0)
                continue;
            result +=i;
            flag=0;
        }
        result++;
        System.out.println(String.format("Condition: %b", result==number));
    }
}
