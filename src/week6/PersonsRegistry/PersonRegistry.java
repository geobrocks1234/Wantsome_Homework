package week6.PersonsRegistry;

import java.util.Set;

public interface PersonRegistry {

    /**
     * Tries to add a new Person to the registry
     * @param person
     * @throws DuplicateCnpException if a Person with same CNP is already registered
     */
    void register(Person person) throws DuplicateCnpException;

    /**
     * Finds a Person by CNP and removes it from registry.
     * If Person is not found, will still work (no errors, and does nothing)
     * @param cnp
     */
    void unregister(int cnp);

    /**
     * get the number of currently registered persons.
     * @return
     */
    int count();

    /**
     * Get the list of CNP values of all persons.
     * @return
     */
    Set<Integer> cnps();

    /**
     * Get the list of unique names of all persons.
     * @return
     */
    Set<String> uniqueNames();

    /**
     * Find a Person by cnp; returns null if no Person found.
     * @param cnp
     * @return
     */
    Person findByCnp(int cnp);

    /**
     * Find the persons with a specified name (may be zero, one or more)
     * Comparing Person name with specified name should be case insensitive.
     * @param name
     * @return
     */
    Set<Person> findByName(String name);

    /**
     * Get the average age for all persons (or 0 if it cannot be computed)
     * @return
     */
    double averageAge();

    /**
     * Get the percent (value between 0-100) of adults (persons with age >= 18)
     * from the number of all persons (or 0 as default if it cannot be computed)
     * @return
     */
    double adultsPercentage();

    /**
     * Get the percent (value between 0-100) of adults who voted
     * from the number of all adult persons (age>=18)
     * @return
     */
    double adultsWhoVotedPercentage();

    Set<Person> allPersons();

}
