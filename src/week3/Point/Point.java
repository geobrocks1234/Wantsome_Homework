package week3.Point;

public class Point {
    /*===== Fields ======*/
    private double x;
    private double y;

    /*===== Constructor ======*/
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /*===== Getters ======*/
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    /*===== Setters ======*/
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }

    /*=== Other Methods ===*/
    double distanceTo(Point other){

        return Math.sqrt((other.x-x)*(other.x-x)+(other.y-y)*(other.y-y));
    }

    void move( double deltaX, double deltaY){
        setX(deltaX);
        setY(deltaY);
    }

    public String toString(){
        return "("+getX()+", "+getY()+")";
    }

    static boolean canFormTriangle(Point p1, Point p2, Point p3){
        double a = p1.distanceTo(p2);
        double b = p1.distanceTo(p3);
        double c = p2.distanceTo(p3);
        if (a+b > c && a+c > b && b+c > a) {
            return true;
        }
        else{
            return false;
        }
    }

    private static double calculateMax(Point p1, Point p2, Point p3) {
        double a = p1.distanceTo(p2);
        double b = p1.distanceTo(p3);
        double c = p2.distanceTo(p3);
        double max =0;
        if(b>a){
            b=max;
        }
        else if(c>b){
            return c;
        }else {
            return b;
        }
        return max;
    }

    static boolean canFormRightAngledTriangle(Point p1, Point p2, Point p3){
        double x = p1.distanceTo(p2);
        double y = p1.distanceTo(p3);
        double z = p2.distanceTo(p3);
        double max = calculateMax(p1, p2, p3);
        if((x == max && x*x == y*y + z*z) || (y == max && y*y == x*x + z*z) || (z == max && z*z == x*x + y*y)){
            return true;
        }
        else{
            return false;
        }
    }
}
