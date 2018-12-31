package week1;

import java.util.Scanner;
import java.lang.System;

public class RemoveMiddleDigit {

    //Exercise 6

    public static boolean checkRangeNum(int n) {
        boolean a = (n > 9999 && n <= 99999) ? true : false;
        return a;
    }

    public static int ExtractMiddleDigit(int n) {
        int firstTwo = n / 1000;
        int lastTwo = n % 100;
        return firstTwo * 100 + lastTwo;
    }

    public static void main(String[] args) {
        System.out.println("This program extracts the middle digit from an integer with 5 digits.");
        System.out.println("================================================================\n\n");
        System.out.println("Please insert a number in interval: (9999,99999].");

        Scanner scanned = new Scanner(System.in);
        System.out.println("Number value is : ");
        int n = scanned.nextInt();

        String finalMessage = (checkRangeNum(n)==true)?("The number "+n+" after middle digit extraction is: "+ExtractMiddleDigit(n)+"."):"Please insert a number by 5 digits format.";
        System.out.println(finalMessage);
    }
}

