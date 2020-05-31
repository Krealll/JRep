package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4  extends  Task{

    private int numberA;
    private int numberB;
    private int numberC;
    private int numberD;

    public Task4(){}

    @Override
    public void run() {
        try {
            setStopValue(0);
            validate();
            while (numberA != getStopValue()&&numberB!=getStopValue()
                    &&numberC!=getStopValue()&&numberD!=getStopValue()) {
                task4Helper();
                validate();
            }
        }
        catch (RuntimeException e){
            System.out.println(String.format("In method run: %s",Task4.class));
            throw e;
        }
    }

    @Override
    public void validate() throws ValidateException {

        try {
            Scanner in = new Scanner(System.in);
            numberA=in.nextInt();
            numberB=in.nextInt();
            numberC=in.nextInt();
            numberD=in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            throw new ValidateException("Invalid argument");
        }

    }

    private boolean isPairEven(int firstNumber, int secondNumber){
        return firstNumber%2==0&&secondNumber%2==0;
    }

    private void task4Helper(){
        System.out.println(String.format("Condition: %b",
                ((isPairEven(numberA, numberB)) || (isPairEven(numberA, numberC)) || (isPairEven(numberA, numberD))
                        || (isPairEven(numberB, numberC)) || (isPairEven(numberB,numberD)) || (isPairEven(numberC, numberD)))));
    }

}
