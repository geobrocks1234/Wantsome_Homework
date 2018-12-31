package week1;
import java.util.Scanner;
import java.lang.System;

public class HeightPersonConverter {

    //Exercise 3

    private final static double FOOT_IN_CM = 30.48;
    private final static double INCH_IN_CM = 2.54;

    public static int FootInchToCm(double f, double i){
        double sum = f* FOOT_IN_CM +i* INCH_IN_CM;
        return (int)sum;
    }

    public static int CmToFoot(int c){
        double result = (double)c/FOOT_IN_CM;
        return (int)result;
    }

    public static int CmToInchesRest(int c){
        double rest = (double)c-CmToFoot(c)*FOOT_IN_CM;
        double result = rest/INCH_IN_CM;
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println("This program convert the height of a Person from feet and inches to centimeters and .\n");
        System.out.println("================================================================\n\n");

        //PART A - Convert feet and inches to centimeters
        System.out.println("Convert your height from feet and inches into centimeters.");
        Scanner scanned = new Scanner(System.in);
        System.out.println("Please insert the values for feet: ");
        double f = scanned.nextDouble();
        System.out.println("Please insert the values for inches: ");
        double i = scanned.nextDouble();
        System.out.println("Convert "+f+" feet and "+i+ " inches into centimeters: "+ FootInchToCm(f,i)+" cm.");
        System.out.println("\n\n");

        //PART B - Convert centimeters to feet and inches
        System.out.println("Convert your height from centimeters into feet and inches.");
        System.out.println("Please insert the values in centimeters: ");
        int c = scanned.nextInt();
        System.out.println("Convert "+c+" centimeters into feet and inches2.: "+CmToFoot(c)+" feet and "+CmToInchesRest(c)+" inches.");
    }
}
