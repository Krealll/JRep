import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        System.out.println("task1");
        task1();
        System.out.println("task2");
        task2();
        System.out.println("task3");
        task3();
        System.out.println("task4");
        task4();
        System.out.println("task5");
        task5();
        System.out.println("task6");
        task6();
        System.out.println("task7");
        task7();
        System.out.println("task8");
        task8();
        System.out.println("task9");
        task9();
        System.out.println("task10");
        task10();
    }

    private static void task10() {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt(),stopValue=-1,
                a =in.nextInt(), b=in.nextInt(),
                h =in.nextInt();
        List<String> results = new ArrayList<>();
        while (value!=stopValue) {
            results= task10Helper(a,b,h);
            for (String s: results
                 ) {
                System.out.println(s);
            }
            a= in.nextInt();
            b= in.nextInt();
            h = in.nextInt();
            value = in.nextInt();
        }
    }

    private static List<String> task10Helper(int a, int b, int h) {
        List<String> resultList= new ArrayList<>();
        for(int i=a;i<=b;i+=h){
            resultList.add(String.format("tg(%d) - %f",i, Math.tan(i)));
        }
        return resultList;
    }

    private static void task9() {
        Scanner in = new Scanner(System.in);
        int radius = in.nextInt(),stopValue=-1;
        while (radius!=stopValue) {
            System.out.println(String.format("Length of circle is: %f \n Area is: %f",radius*2*Math.PI, Math.PI*radius*radius));
            radius= in.nextInt();
        }
    }

    private static void task8() {
        Scanner in = new Scanner(System.in);
        double value = in.nextDouble(),stopValue=-1.0;
        while (value!=stopValue) {
            System.out.println(String.format("tg(x) function result is: %f", Math.tan(value)));
            value= in.nextDouble();
        }
    }

    private static void task7() {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt(), stopX1 = 9999,
                y1 = in.nextInt(), stopY1 = 9999,
                x2 = in.nextInt(), stopX2 = 9999,
                y2 = in.nextInt(), stopY2 = 9999,
        condition;
        while (x1 != stopX1&&x2 != stopX2&&y1 != stopY1&&y2 != stopY2) {
            condition=Integer.compare(x1 * x1 + y1 * y1, x2 * x2 + y2 * y2);
            if(condition==-1){
                System.out.println("First point is closer");
            }
            else if (condition==0)
                System.out.println("Points are equidistant");
            else
                System.out.println("Second point is closer");
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
        }
    }

    private static void task6() {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt(), stopNumber = -1;
        while (number != stopNumber) {
            task6Helper(number);
            number=in.nextInt();
        }
    }

    private static void task6Helper(int n) {
        System.out.println(String.format("Hours:%d, minutes:%d,seconds:%d",n/3600,(n%3600)/60,((n%3600)%60)));
    }

    private static void task5() {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt(),stopNumber = -1;
        while (number!=stopNumber) {
            System.out.println(String.format("Condition: %b", task5Helper(number)));
            number = in.nextInt();
        }
    }

    private static boolean task5Helper(int number) {
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
        return result==number;
    }


    private static void task4() {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt(),stopA = -1,
                B = in.nextInt(),stopB = -1,
                C = in.nextInt(),stopC = -1,
                D = in.nextInt(),stopD = -1;
        while (A!=stopA&&B!=stopB&&C!=stopC&&D!=stopD) {
            System.out.println(String.format("Condition: %b",
                    ((task4Helper(A, B)) || (task4Helper(A, C)) || (task4Helper(A, D))
                            || (task4Helper(B, C)) || (task4Helper(B, D)) || (task4Helper(C, D)))));
            A = in.nextInt();
            B = in.nextInt();
            C = in.nextInt();
            D = in.nextInt();
        }
    }

    private static boolean task4Helper(int first, int second){
        return first%2==0&&second%2==0;
    }

    private static void task3() {
        Scanner in = new Scanner(System.in);
        int area = in.nextInt(),stopArea = -1;
        while (area!=stopArea){
            task3Helper(area);
            area = in.nextInt();
        }
    }

    private static void task3Helper(int area) {
        System.out.println(String.format("Area of second square is %d and it's %d times less than first square",area/2,2));
    }

    private static void task2() {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt(),month=in.nextInt(),
            stopYear = -1, stopMonth = -1;
        while (year!=stopYear&&month!=stopMonth){
            task2Helper(year, month);
            year = in.nextInt();
            month = in.nextInt();
        }
    }

    private static boolean isLeap(int value){
        if(value%400==0){
            return true;
        }
        else if (value%100==0){
            return true;
        }
        else if (value%4==0){
            return true;
        }
        return false;
    }

    private static void task2Helper(int year, int month){
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
                break;
            default:
                System.out.println("Error");
                return;
        }
        System.out.println(String.format("%d days in %dth month",days,month));
    }

    private static void task1() {
        Scanner in = new Scanner(System.in);
        int value=in.nextInt(), stopValue=-1;
        while(value!=stopValue){
            System.out.println(task1Helper(value));
            value=in.nextInt();
        }
    }

    private static int task1Helper(int number){
       return ((number%10)*(number%10))%10;
    }



}
