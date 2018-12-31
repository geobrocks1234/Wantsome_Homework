package week1;

import java.util.Scanner;
import java.lang.System;
import java.lang.Math;

//Exercise 14

//Din lipsa de timp am folosit si libraria Math si structuri ca if
public class QuadraticEquation {
    private static void NonRealRoots(int a, int b, int c){
        double d = (b*b - 4*a*c);
        double re = -b/(2*a);
        if (d>=0){
            System.out.println(Math.sqrt(d)/(2*a)+re);
            System.out.println(-Math.sqrt(d)/(2*a)+re);
        }
        else{
            System.out.println(re+" + "+(Math.sqrt(-d)/(2*a))+"i");
            System.out.println(re+" - "+(Math.sqrt(-d)/(2*a))+"i");
        }
    }

    public static void main(String[] args) {
        //Part A & B
        System.out.println("This program calculates the non-real roots of quadratic equation.");
        System.out.println("================================================================");
        System.out.println("Please inser the coefficients a, b and c.\n\n");
        Scanner scanned = new Scanner(System.in);
        System.out.println("Coefficient a is: ");
        int a = scanned.nextInt();
        System.out.println("Coefficient b is: ");
        int b = scanned.nextInt();
        System.out.println("Coefficient c is: ");
        int c = scanned.nextInt();
        System.out.println("The soluion for quadratic equation is: ");
        NonRealRoots(a,b,c);
    }
}

