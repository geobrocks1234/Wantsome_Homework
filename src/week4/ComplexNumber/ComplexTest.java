package week4.ComplexNumber;

import static week4.ComplexNumber.Complex.complex;
import static week4.ComplexNumber.TestUtil.assertEquals;

public class ComplexTest {

    public static void main(String[] args) {
        System. out .println( "Testing the functionality of Complex class..." );
        //complex some instances of Complex class (using the static .complex() method)
        Complex c0 = complex ( 0 , 0 );
        Complex c1 = complex ( 1 , 2 );
        Complex c2 = complex ( 3 , 4 );
        //check expected results of some operations:
        assertEquals ( complex (- 1 , - 2 ), c1.negate());
        assertEquals ( complex ( 4 , 6 ), c1.add(c2));
        assertEquals ( complex (- 5 , 10 ), c1.multiply(c2));
        //check some generic arithmetic rules:
        assertEquals (c1.add(c2), c2.add(c1)); //add is commutative
        assertEquals (c1.multiply(c2), c2.multiply(c1)); //multiply is commutative
        assertEquals (c1, c1.add(c2).add(c2.negate())); //adding a number and its negate should cancel out
        assertEquals (c1, c1.negate().negate()); //double negation cancels out
        assertEquals (c0, c0.multiply(c2)); //multiply anything by (0,0) gives (0,0)
        System. out .println( "... all tests passed successfully!" );
    }

}
