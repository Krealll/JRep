package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task10 extends Task {


    private int leftBorder;
    private int rightBorder;
    private int calculationStep;

    public Task10(){}

    @Override
    public void run() {
        try {
            setStopValue(0);
            validate();
            while (leftBorder!=getStopValue()&&rightBorder!=getStopValue()&&calculationStep!=getStopValue()) {
                task10Helper();
                validate();
            }
        }
        catch (RuntimeException e){
            System.out.println(String.format("In method run: %s",Task10.class));
            throw e;
        }
    }

    @Override
    public void validate() throws ValidateException {
        try {
            Scanner in = new Scanner(System.in);
            leftBorder=in.nextInt();
            rightBorder=in.nextInt();
            if(rightBorder<leftBorder)
                throw new ValidateException("Invalid right border argument");
            calculationStep=in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            throw new ValidateException("Invalid argument");
        }
    }

    private  void task10Helper() {
        List<String> resultList= new ArrayList<>();
        for(int i=leftBorder;i<=rightBorder;i+=calculationStep){
            resultList.add(String.format("tg(%d) - %f",i, Math.tan(i)));
        }
        for (String s: resultList) {
            System.out.println(s);
        }

    }

}
