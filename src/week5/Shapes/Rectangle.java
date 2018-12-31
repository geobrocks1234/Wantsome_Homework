package week5.Shapes;

public class Rectangle implements Shape {

    private double length;
    private double height;

    public Rectangle(double length, double height){
        if(length <= 0 || height <= 0){
            throw new IllegalArgumentException("Rectangle must have positive length and height, but received values: " + length + ", " + height);
        }
        this.length = length;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("This is a rectangle with length = " + length +
                " and height = " + height +
                " (area = " + computeArea() +
                " perimeter = " + computePerimeter() + ")");
    }

    @Override
    public double computeArea() {
        return length*height;
    }

    @Override
    public double computePerimeter() {
        return 2*length + 2*height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", height=" + height +
                '}';
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.length, length) == 0
                && Double.compare(rectangle.height, height) == 0;
    }
}
