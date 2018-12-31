package week6.PersonsRegistry;

import java.util.*;

public class PersonRegistryImpl implements PersonRegistry {

    private Map<Integer, Person> persons = new HashMap<>();

    @Override
    public void register(Person newPerson) throws DuplicateCnpException {
        if(persons.get(newPerson.getCnp()) != null){
            throw new DuplicateCnpException("Found duplicate cnp: " + newPerson.getCnp());
        }
        persons.put(newPerson.getCnp(), newPerson);
    }


    @Override
    public void unregister(int cnp) {
        persons.remove(cnp);
    }

    @Override
    public int count() {
        return persons.size();
    }

    @Override
    public Set<Integer> cnps() {
        return persons.keySet();
    }

    @Override
    public Set<String> uniqueNames() {
        Set<String> uniqueNames = new HashSet<>();
        for(Person p: persons.values()){
            uniqueNames.add(p.getName());
        }
        return uniqueNames;
    }

    @Override
    public Person findByCnp(int cnp) {
        for(Person person: persons.values()){
            if(person.getCnp()==cnp){
                return person;
            }
        }
        return null;
    }

    @Override
    public Set<Person> findByName(String name) {
        Set<Person> personsFoundByName = new HashSet<>();

        for(Person person: persons.values()){
            if(person.getName().equalsIgnoreCase(name)){
                personsFoundByName.add(person);
            }
        }
        return personsFoundByName;
    }

    @Override
    public double averageAge() {
        double average = 0;
        for(Person person:persons.values()){
            average+=person.getAge();
        }
        if(persons.size() == 0) {
            return 0;
        }
        return average/persons.size();
    }

    @Override
    public double adultsPercentage() {
        int numberOfAdults = 0;
        for(Person person: persons.values()){
            if(person.getAge()>=18){
                numberOfAdults++;
            }
        }
        if(persons.size()==0){
            return 0;
        }
        return numberOfAdults*100/persons.size();
    }

    @Override
    public double adultsWhoVotedPercentage() {
        int numberOfAdults = 0;
        int hasVoted = 0;
        for(Person person: persons.values()){
            if(person.getAge()>=18){
                numberOfAdults++;
                if(person.isHasVoted()){
                    hasVoted++;
                }
            }
        }
        if(persons.size()==0){
            return 0;
        }
        return hasVoted*100/numberOfAdults;
    }

    @Override
    public Set<Person> allPersons() {

        return new HashSet<>(persons.values());

    }
}