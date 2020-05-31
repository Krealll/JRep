package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task8 extends Task {

    private double x;

    public Task8(){}

    @Override
    public void run() {
        try {
            setStopValue(0);
            validate();
            while (x!=getStopValue()) {
                task8Helper();
                validate();
            }
        }
        catch (RuntimeException e){
            System.out.println(String.format("In method run: %s",Task8.class));
            throw e;
        }
    }

    @Override
    public void validate() throws ValidateException {

        try {
            Scanner in = new Scanner(System.in);
            x=in.nextDouble();
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
            throw new ValidateException("Invalid argument");
        }
    }

    private void task8Helper() {
      if(x<3){
          System.out.println(String.format("Result is: %f",1/(x*x*x-6)));
      }
      else {
          System.out.println(String.format("Result is: %f",-x*x+3*x+9));
      }
    }


}
