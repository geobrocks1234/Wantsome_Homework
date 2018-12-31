package week1;

import java.util.Scanner;
import java.lang.System;

//Exercise 12

public class IntervalDivide {

    //Am scris un for din lipsa de timp
    public static int NumberOfIntegersInInterval(int x, int y, int p){
        int counter=0;
        for(int i=x; i<=y; i++){
            if(i%p==0) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println("This program counting the number of integers divisible by a value given, between another two values given also.");
        System.out.println("================================================================");
        System.out.println("Please insert the values for inferior & superior limits and divisor value.\n\n");
        Scanner scanned = new Scanner(System.in);
        System.out.println("Value of inferior limit is: ");
        int x = scanned.nextInt();
        System.out.println("Value of superior limit is: ");
        int y = scanned.nextInt();
        System.out.println("Divisor is: ");
        int p = scanned.nextInt();
        System.out.println("The number of integers divisible by "+p+" between "+x+" and "+y+" are: "+NumberOfIntegersInInterval(x,y,p));
    }
}


