package com.krealll.tasks;

import com.krealll.tasks.exceptions.ValidateException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 extends Task {

        private int year;
        private int month;

        public Task2(){}

        @Override
        public void run() {
            try {
                setStopValue(0);
                validate();
                while (year != getStopValue()&&month!=getStopValue()) {
                    task2Helper();
                    validate();
                }
            }
            catch (RuntimeException e){
                System.out.println(String.format("In method run: %s",Task2.class));
                throw e;
            }

        }

        private void task2Helper(){
            int days = 0;
            System.out.println(String.format("is %d a leap year? - %b",year,isLeap(year)));
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days=31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days=30;
                    break;
                case  2:
                    days = 28;
                    if(isLeap(year))
                        days++;
                    break;
            }
            System.out.println(String.format("%d days in %dth month",days,month));
        }


        @Override
        public void validate() throws ValidateException {
            try {
                Scanner in = new Scanner(System.in);
                year = in.nextInt();
                if (year<0)
                    throw new ValidateException("Invalid year argument");
                month = in.nextInt();
                if(month<0||month>12)
                    throw new ValidateException("Invalid month argument");
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                throw new ValidateException("Invalid arguments");
            }

        }

        private boolean isLeap(int value){
            if(value%400==0){
                return true;
            }
            else if (value%100==0){
                return true;
            }
            else
                return value % 4 == 0;
        }
}

