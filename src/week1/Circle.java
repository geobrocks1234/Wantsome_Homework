package week1;

public class Circle {
    private static final double PI =3.14;

    public static double circleArea(double radius){
        return PI*radius*radius;
    }

    public static double circleCircumference(double radius){
        return 2*PI*radius;
    }
}
