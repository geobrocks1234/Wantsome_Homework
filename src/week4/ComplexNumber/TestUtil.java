package week4.ComplexNumber;

/**
 * An utility class with some static methods, useful for writing test classes.
 * <p>
 * - You can import the needed methods directly in your test class, like:
 * import static week4.TestUtil.*;
 * <p>
 * - You can then use it for checking conditions (if a check fails, test will end with exception):
 * assertEquals("abc", "abc"); //expecting this to run without errors
 * assertTrue( 2 == 3); //this will fail with exception!
 */

public class TestUtil {

    /**
     * Checks if 2 objects are equal (using the .equals() method of them)
     */
    public static void assertEquals(Object obj1, Object obj2) {
        assertTrue (java.util.Objects. equals (obj1, obj2),
                "objects should be equal: [" + obj1 + "] vs. [" + obj2 + "]" );
    }
    /**
     * Check if a given condition is true.
     * It also supports a description for the condition, to be printed in the error message.
     * Throws an exception if the check fails.
     */
    public static void assertTrue( boolean condition, String description) {
        if (!condition) throw new RuntimeException( "Assert check failed: " + description);
    }
    /**
     * Check if a given condition is true
     */
    public static void assertTrue( boolean condition) {
        assertTrue (condition, "condition should be true" );
    }
    /**
     * Check if a given condition is false
     */
    public static void assertFalse( boolean condition) {
        assertTrue (!condition, "condition should be false" );
    }

}
