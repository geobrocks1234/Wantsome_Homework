package week1;

import java.util.Scanner;
import java.lang.System;

//Exercise 1

public class TriangleChecker {

    //This function returns the perfect square of a number given as parameter
    private static int squareNumber(int n) {
        return n * n;
    }

    //This function calculates the maximum of 3 numbers given as parameters
    private static int calculateMax(int a, int b, int c) {
        int max = a;
        max = (b > max) ? b : max;
        max = (c > max) ? c : max;
        return max;
    }

    public static void main(String[] args) {
        {
            //Part A

            System.out.println("This program checks if triangle is a valid and right-angled one.\n\n");
            System.out.println("================================================================\n\n");
            System.out.println("Please insert the angles of the triangle!\n\n");

            Scanner scannned = new Scanner(System.in);
            System.out.println("A's angle degree is : ");
            int a = scannned.nextInt();
            //System.out.println("\n");
            System.out.println("B's angle degree is : ");
            int b = scannned.nextInt();
            //System.out.println("\n");
            System.out.println("C's angle degree is : ");
            int c = scannned.nextInt();
            //System.out.println("\n");

            int sum = a + b + c;
            final int VALID = 180;

            String resultValue1 = (sum < VALID) ? "not a valid triangle" : (a == 90 || b == 90 || c == 90) ? "valid triangle, right angled" : "valid triangle, not right angled";

            System.out.println(resultValue1);
            System.out.println("\n");

        }

        {
            // PART B

            System.out.println("Now, try to find out the same thing but with length sides of the triangle.\n\n");
            System.out.println("================================================================\n\n");
            System.out.println("Please insert the edges of the triangle!\n\n");

            Scanner scannned = new Scanner(System.in);
            System.out.println("A's length side is : ");
            int x = scannned.nextInt();
            //System.out.println("\n");
            System.out.println("B's length side is : ");
            int y = scannned.nextInt();
            //System.out.println("\n");
            System.out.println("C's length side is : ");
            int z = scannned.nextInt();
            System.out.println("\n\n");

            int max = calculateMax(x, y, z);
            long x2 = squareNumber(x);
            long y2 = squareNumber(y);
            long z2 = squareNumber(z);

            String resultValue2 = (x + y < z || x + z < y || y + z < x) ? "not a valid triangle" : ((x == max && x2 == y2 + z2) || (y == max && y2 == x2 + z2) || (z == max && z2 == x2 + y2)) ? "valid, right angled" : "valid, not right angled";

            System.out.println(resultValue2);
            System.out.println("\n");

        }
    }
}
