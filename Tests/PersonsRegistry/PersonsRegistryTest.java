package PersonsRegistry;

import org.junit.Test;
import week6.PersonsRegistry.DuplicateCnpException;
import week6.PersonsRegistry.Person;
import week6.PersonsRegistry.PersonRegistry;
import week6.PersonsRegistry.PersonRegistryImpl;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PersonsRegistryTest {
    private final static double DELTA = 0.00001; //precision used for comparing doubles

    @Test
    public void testEmptyRegistry() {
        PersonRegistry reg = new PersonRegistryImpl ();

        assertEquals(0, reg.count());
        assertTrue(reg.cnps().isEmpty());
        assertTrue(reg.uniqueNames().isEmpty());
        assertNull(reg.findByCnp(1000));
        assertTrue(reg.findByName("").isEmpty());
        assertEquals(0, reg.averageAge(), DELTA);
        assertEquals(0, reg.adultsPercentage(), DELTA);
        assertEquals(0, reg.adultsWhoVotedPercentage(), DELTA);
    }

    @Test
    public void testNonEmptyRegistry() throws DuplicateCnpException {
        PersonRegistry reg = new PersonRegistryImpl();
        reg.register(new Person (1234, "Ion", 14, false));
        reg.register(new Person(2233, "Ana", 12, false));
        reg.register(new Person(2678, "Ana", 3, false));
        reg.register(new Person(1235, "Costel", 21, false));
        reg.register(new Person(2367, "Maria", 33, true));

        assertEquals(5, reg.count());
        assertEquals(newSet(1234, 2233, 2678, 1235, 2367), reg.cnps());

        assertEquals(16.6, reg.averageAge(), DELTA);
        assertEquals(40.0, reg.adultsPercentage(), DELTA);
        assertEquals(50.0, reg.adultsWhoVotedPercentage(), DELTA);

        assertEquals(newSet("Ana", "Costel", "Ion", "Maria"), reg.uniqueNames());
        assertEquals(
                newSet(
                        new Person(2233, "Ana", 12, false),
                        new Person(2678, "Ana", 3, false)),
                reg.findByName("ANA"));

        assertNull(reg.findByCnp(1000)); //non-existing cnp
        assertEquals(new Person(2678, "Ana", 3, false), reg.findByCnp(2678));

        //unregister an existing Person should work
        reg.unregister(2678);
        assertEquals(4, reg.count());
        assertEquals(newSet(1234, 2233, 1235, 2367), reg.cnps());
        assertNull(reg.findByCnp(2678)); //after unregister, should not find it anymore

        //unregister an non-existing Person should work without exceptions (and do nothing)
        reg.unregister(2678);
        assertEquals(4, reg.count());
        assertNull(reg.findByCnp(2678));

        //registering 2 (different) persons with same cnp should fail with exception
        reg.register(new Person(1555, "Alex", 40, true));
        try {
            reg.register(new Person(1555, "Alesia", 20, false));
            fail("Registering a second Person with same cnp should have failed!");
        } catch(DuplicateCnpException e) {
            //ok, expected to get this exception when test works well (so just 'bury' it)
        }
    }

    //helper method for easy building a new Set with some given elements (of a custom type)
    private static <E> Set<E> newSet(E... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }
}
