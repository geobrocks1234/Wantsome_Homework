package week1;
import java.util.Scanner;
import java.lang.System;

public class AscendingOrderIntegers {

    //Exercise 5

    public static boolean checkIsAscOrdered(int a, int b, int c){
        return (a<=b && b<=c)?true:false;
    }

    public static void main(String[] args) {
        System.out.println("This program verifies if 3 numbers inserted are in ascending order.");
        System.out.println("================================================================\n\n");
        System.out.println("Please insert the values of the numbers.\n");

        Scanner scanned = new Scanner(System.in);
        System.out.println("The first number is : ");
        int a = scanned.nextInt();
        System.out.println("The second number is : ");
        int b = scanned.nextInt();
        System.out.println("The third number is : ");
        int c = scanned.nextInt();

        String finalMessage = (checkIsAscOrdered(a,b,c)==true)?("The list of numbers ["+a+", "+b+", "+c+"] inserted are in ascending order."):("The list of numbers ["+a+", "+b+", "+c+"] inserted are not in ascending order.");
        System.out.println(finalMessage);

    }
}
