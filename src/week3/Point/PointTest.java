package week3.Point;

public class PointTest {
    public static void main(String[] args) {
        //create 3 points
        Point p1 = new Point( 0 , 0 );
        Point p2 = new Point( 0 , 4 );
        Point p3 = new Point( 3 , 0 );
        //print details of the 3 points (.toString() should be automatically called to convert them to strings)
        System.out.println( "Points: " + p1 + ", " + p2 + ", " + p3);
        System.out.println( " \n p2-p3 distance: " + p2.distanceTo(p3)); //should print: 5.0
        System.out.println( "Can form triangle: " + Point.canFormTriangle (p1, p2, p3)); //should print: true
        System.out.println( "Can form right-angled triangle: " + Point.canFormRightAngledTriangle (p1, p2, p3)); //should print: true
        p2.move( 0 , 0.1 );
        System.out.println( " \n Moved p2 a little, new position: " + p2);
        System.out.println( "Can form triangle: " + Point.canFormTriangle (p1, p2, p3)); //should print: true
        System.out.println( "Can form right-angled triangle: " + Point.canFormRightAngledTriangle (p1, p2, p3)); //prints: false
    }
}
