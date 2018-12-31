package week6.PersonsRegistry;

import java.util.Objects;

public class Person {

    private int cnp;
    private String name;
    private int age;
    private boolean hasVoted;

    public Person(int cnp, String name, int age, boolean hasVoted){
        this.cnp = cnp;
        this.name = name;
        this.age = age;
        this.hasVoted = hasVoted;
    }

    public int getCnp() {
        return cnp;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return cnp == person.cnp &&
                age == person.age &&
                hasVoted == person.hasVoted &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp, name, age, hasVoted);
    }

    @Override
    public String toString() {
        return "Person{" +
                "cnp=" + cnp +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hasVoted=" + hasVoted +
                '}';
    }
}
