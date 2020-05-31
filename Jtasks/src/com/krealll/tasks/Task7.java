package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task7 extends Task {

    private int point1X;
    private int point1Y;
    private int point2X;
    private int point2Y;

    public Task7(){}

    @Override
    public void run() {
        try {
            setStopValue(0);
            validate();
            while (point1X != getStopValue()&&point1Y!=getStopValue()&&
                    point2X!=getStopValue()&&point2Y!=getStopValue()) {
                task7Helper();
                validate();
            }
        }
        catch (RuntimeException e){
            System.out.println(String.format("In method run: %s",Task7.class));
            throw e;
        }
    }

    @Override
    public void validate() throws ValidateException {

        try {
            Scanner in = new Scanner(System.in);
            point1X=in.nextInt();
            point1Y=in.nextInt();
            point2X=in.nextInt();
            point2Y=in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            throw new ValidateException("Invalid argument");
        }
    }

    private  void task7Helper() {
        int condition;
            condition=Integer.compare(point1X * point1X + point1Y * point1Y,
                    point2X * point2X + point2Y * point2Y);
            if(condition==-1){
                System.out.println("First point is closer");
            }
            else if (condition==0)
                System.out.println("Points are equidistant");
            else
                System.out.println("Second point is closer");
    }
}



