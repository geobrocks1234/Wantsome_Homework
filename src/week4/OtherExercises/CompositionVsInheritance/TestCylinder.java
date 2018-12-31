package week4.OtherExercises.CompositionVsInheritance;

public class TestCylinder {
    public static void main(String[] args) {

        Cylinder c1 = new Cylinder();
        System.out.println(c1);

        Cylinder c2 = new Cylinder(10);
        System.out.println(c2);

        Cylinder c3 = new Cylinder(2, 10);
        System.out.println(c3);

        c3.setHeight(1);
        System.out.println(c3);

    }
}
