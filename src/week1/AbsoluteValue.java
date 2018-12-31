package week1;

public class AbsoluteValue {

    //Exercise 9

    static double abs (double value){
        return (value<= 0.0D) ? 0.0D - value : value;
    }

    public static void main(String[] args) {
        // test abs() method
        System.out.println("Absolute value for -5 is: "+abs(-5)+".");
        System.out.println("Absolute value for 10 is: "+abs(10)+".");
        System.out.println("Absolute value for -2 is: "+abs(-2)+".");
        System.out.println("Absolute value for 0 is: "+abs(0)+".");
    }
}
