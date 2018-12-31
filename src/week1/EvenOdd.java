package week1;
import java.util.Scanner;
import java.lang.System;

public class EvenOdd {

    //Exercise 4

    public static boolean checkNumberRange(int n){
        boolean a = (n>0 && n<1000)?true:false;
        return a;
    }

    public static int EvenOddInt(int n){
        int a = (n%2==0)?0:1;
        return a;
    }

    public static String EvenOddStrng(int n){
        String a = (n%2==0)?"odd":"even";
        return a;
    }

    public static void main(String[] args) {
        System.out.println("This program checks if a number is odd or even.");
        System.out.println("================================================================\n\n");
        System.out.println("Please insert the values for the number you want to find out the parity or not. The number must be into (0,1000) interval!");

        Scanner scanned = new Scanner(System.in);
        System.out.println("Number is : ");
        int n = scanned.nextInt();
        String Message = (checkNumberRange(n)==true)?("The number "+n+" is "+EvenOddStrng(n)+" like "+EvenOddInt(n)+" digit transposed by this software."):"Please insert number in range!";
        System.out.println("\n"+Message);
    }
}
