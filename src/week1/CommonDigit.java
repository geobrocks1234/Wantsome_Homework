package week1;

import java.util.Scanner;
import java.lang.System;

public class CommonDigit {

    //Exercise 7

    public static boolean checkRange(int a) {
        boolean b = (a>13 && a<89)?true:false;
        return b;
    }

    public static boolean checkDigits(int a, int b){
        int a1 = a/10;
        int a2 = a%10;
        int b1 = b/10;
        int b2 = b%10;
        return (a1==b1 || a1==b2 || a2==b1 || a2==b2)?true:false;
    }

    public static void main(String[] args) {
        System.out.println("This program checks if 2 numbers have digits in common.");
        System.out.println("================================================================\n\n");
        System.out.println("Please insert 2 numbers.");

        Scanner scanned = new Scanner(System.in);
        System.out.println("First number is:");
        int a = scanned.nextInt();
        String massageA = (checkRange(a)==true)?"Well done, value inserted in interval!":"The number inserted is not in range! Please insert a valid number between 13 and 89.";
        System.out.println(massageA);
        System.out.println("Second number is:");
        int b = scanned.nextInt();
        String massageB = (checkRange(b)==true)?"Well done, value inserted in interval!":"The number inserted is not in range! Please insert a valid number between 13 and 89.";
        System.out.println(massageB+"\n");
        String finalMessage = (checkRange(a)==true && checkRange(b)==true)?("The value evaluated as common digits for numbers "+a+" and "+b+" is "+checkDigits(a, b)+"!"):"Please insert numbers in range!";
        System.out.println(finalMessage);

    }
}
