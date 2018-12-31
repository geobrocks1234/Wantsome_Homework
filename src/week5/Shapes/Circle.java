package week5.Shapes;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius){
        if(radius<=0) {
            throw new IllegalArgumentException("Circle must have positive radius, but received value: " + radius);
        }
        this.radius = radius;

    }

    @Override
    public void draw() {
        System.out.println("This is a circle of Radius = " + radius +
                ", Area = " + computeArea() +
                ", Perimeter = " + computePerimeter());
    }

    @Override
    public double computeArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double computePerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }
}
