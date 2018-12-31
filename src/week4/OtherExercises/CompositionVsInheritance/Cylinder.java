package week4.OtherExercises.CompositionVsInheritance;

import week4.OtherExercises.Circle.Circle;

public class Cylinder {

    private Circle base;
    private double height;

    // Constructor with default color, radius and height
    public Cylinder() {
        base = new Circle(); // Call the constructor to construct the Circle
        height = 1.0;
    }

    // 2nd Constructor
    public Cylinder(double height) {
        base = new Circle();
        this.height = height;
    }

    //3rd Constructor
    public Cylinder(double radius, double height) {
        base = new Circle(radius);
        this.height = height;
    }

    // A public method for retrieving the height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // A public method for computing the volume of cylinder
    public double getVolume() {
        return base.getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "base=" + base +
                ", height=" + height +
                '}';
    }
}