package com.krealll.tasks;

public class TaskManager {
    public static void main(String[] args) {
       try {
            System.out.println("Stop value is 0");
            System.out.println("Task1");
            Task1 task1 = new Task1();
            task1.run();
            System.out.println("Task2");
            Task2 task2 = new Task2();
            task2.run();
            System.out.println("Task3");
            Task3 task3 = new Task3();
            task3.run();
            System.out.println("Task4");
            Task4 task4 = new Task4();
            task4.run();
            System.out.println("Task5");
            Task5 task5 = new Task5();
            task5.run();
            System.out.println("Task6");
            Task6 task6 = new Task6();
            task6.run();
            System.out.println("Task7");
            Task7 task7 = new Task7();
            task7.run();
            System.out.println("Task8");
            Task8 task8 = new Task8();
            task8.run();
            System.out.println("Task9");
            Task9 task9 = new Task9();
            task9.run();
            System.out.println("Task10");
            Task10 task10 = new Task10();
            task10.run();
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
