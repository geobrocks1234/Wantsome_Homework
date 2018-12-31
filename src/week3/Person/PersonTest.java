package week3.Person;

import java.util.Scanner;

public class PersonTest {
    public static void main(String[] args) {

        /* Build new Person instance */
        Person person1 = new Person("Gigel", 1989, "redheaded");
        Person person2 = new Person("Marcela", 1955, "blond");
        Person person3 = new Person("Geo", 1993);

        /* Calling getters, setters and other methods */
        Scanner scanned = new Scanner(System.in);
        System.out.println("If you dyed your hair, insert your new color of your hair.");
        String hairColor = scanned.next();
        person1.setHairColor(hairColor);
        System.out.println("\nIs "+person1.getName()+" older than "+person2.getName()+"? True or False: "+person1.isOlderThan(person2));
        System.out.println("\nIs "+person2.getName()+" older than "+person3.getName()+"? True or False: "+person2.isOlderThan(person3));


        System.out.println("\nAccessing Person info (by getter): birth of year is: " + person3.getBirthYear());
        System.out.println("Means that "+person3.getName()+" has "+person3.calculateAge(person3.getBirthYear())+" years old!");

        System.out.println(person1.description());
        System.out.println(person2.description());
        System.out.println(person3.description());
    }
}
