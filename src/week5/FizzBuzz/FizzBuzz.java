package week5.FizzBuzz;

public class FizzBuzz {
    public static String fizzBuzz ( int number ) {
        if ( number % 3 == 0 ) {
            if ( number % 5 == 0 ) {
                return "fizzbuzz";
            } else {
                return "fizz";
            }
        } else if ( number % 5 == 0 ) {
            return "buzz";
        }
        return String.valueOf ( number );
    }

    public static String returnFizzBuzz ( int[] array){
        String s = "";
        for(int i=0;i<array.length;i++){
            s += fizzBuzz ( array[i] ) + " ";
        }
        return s;
    }
}
