package week1;

import java.util.Scanner;
import java.lang.System;

//Exercise 10

public class MeasureShapes {
    public static void main(String[] args) {
        //compare data between circle and square
        //Circle Read + Calculate Data
        System.out.println("This program measures the area and perimeter / circumference of square /circle and comparing them.");
        System.out.println("================================================================\n\n");
        System.out.println("Please insert the radius for circle and the side for square.");

        Scanner scanned = new Scanner(System.in);
        System.out.println("Radius value is: ");
        double r = scanned.nextDouble();
        double CircleArea = Circle.circleArea(r);
        double CircleCircum = Circle.circleCircumference(r);
        System.out.println("Circle Area is: "+CircleArea+".");
        System.out.println("Circle Circumference is: "+CircleCircum+".\n\n");

        //Circle Read + Calculate Data
        System.out.println("Square side value is: ");
        double s = scanned.nextDouble();
        double SquareArea = Square.squareArea(s);
        double SquarePerem = Square.squarePerimeter(s);
        System.out.println("Circle Area is: "+SquareArea+".");
        System.out.println("Circle Circumference is: "+SquarePerem+".\n\n");

        //Comparing Areas
        System.out.println("The greater area between circle and square is: "+((CircleArea>SquareArea)?("circle area "+CircleArea+"."):("square area "+SquareArea+".")));
        System.out.println("\n");
        System.out.println("The greater perimeter/ circumference between circle and square is: "+((CircleCircum>SquarePerem)?("circle circumference "+CircleCircum+"."):("square perimeter "+SquarePerem+".")));
    }
}
