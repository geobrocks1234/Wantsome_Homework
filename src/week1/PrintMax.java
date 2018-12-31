package week1;

public class PrintMax {

    //Exercise 8

    static void printMax (int a, int b){
        System.out.println("Maximum number between "+a+" & "+b+" is: "+((a>b)?a:b)+".");
    }

    public static void main(String[] args) {
        // call method printMax with examples from requirements
        printMax( 2, 3);
        printMax(-2, -3);
        printMax( 7, 7);
    }
}
