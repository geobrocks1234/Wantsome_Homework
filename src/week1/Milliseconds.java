package week1;

import java.util.Scanner;
import java.lang.System;

//Exercise 2

public class Milliseconds {

    //The function that checks if the hours, minutes and seconds are in range (e.g. 0 <= M or S <60)
    private static boolean checkRange60(int a) {
        boolean b = (a>=0 && a<60)?true:false;
        return b;
    }

    private static boolean checkRange24(int a) {
        boolean b = (a>=0 && a<24)?true:false;
        return b;
    }

    /*This function converts values of hours, minutes and second into milliseconds given three integers as parameters
    and verifies if value of minutes and secods is in range of [0 ,60).
     */
    private static double millisecondsConverter(int h, int m, int s) {

        double a = h * 60 * 60 * 1000;
        double b = m * 60 * 1000;
        double c = s * 1000;

        return a + b + c;
    }

    public static void main(String[] args) {

        System.out.println("This program convert hours (H), minutes(M) and seconds(S) to milliseconds.\n\n");
        System.out.println("================================================================\n\n");
        System.out.println("Please insert the values for H, M and S.\n\n");

        Scanner scanned = new Scanner(System.in);
        System.out.println("Hours value is : ");
        int h = scanned.nextInt();
        String massageH = (checkRange24(h)==true)?"Well done, value's hours inserted is correct!":"Hours inserted are not in range! Please insert a valid number between 0 and 23 inclusive.";
        System.out.println(massageH);
        System.out.println("Minutes value is : ");
        //String massageM = (checkRange60(m)==true)?"Well done, value's minutes inserted is correct!":"Minutes inserted are not in range! Please insert a valid number between 0 and 59 inclusive.";
        int m = scanned.nextInt();
        String massageM = (checkRange60(m)==true)?"Well done, value's minutes inserted is correct!":"Minutes inserted are not in range! Please insert a valid number between 0 and 59 inclusive.";
        System.out.println(massageM);
        System.out.println("Seconds value is : ");
        int s = scanned.nextInt();
        String massageS = (checkRange60(s)==true)?"Well done, value's seconds inserted is correct!":"Seconds inserted are not in range! Please insert a valid number between 0 and 59 inclusive.";
        System.out.println(massageS);
        System.out.println("\n\n");

        String finalMessage = (checkRange24(h)==true && checkRange60(m)==true && checkRange60(s)==true)?("The value converted to milliseconds for the value of " + h + " hour(s), " + m + " minute(s) and " + s + " second(s) is: " + millisecondsConverter(h, m, s) + " milliseconds."):"Please insert values in range!";
        System.out.println(finalMessage);
        System.out.println("\n");

    }

}

