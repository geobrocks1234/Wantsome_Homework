package week3.Person;

import java.util.Calendar;

public class Person {

    /*===== Fields =============*/
    private String name;
    private int birthYear;
    private String hairColor;

    /*===== Constructors =======*/
    public Person(String name, int birthYear, String hairColor) {
        this.name = name;
        this.birthYear = birthYear;
        this.hairColor = hairColor;
    }

    public Person(String name, int birthYear) { this(name, birthYear, "brown");}

    /*===== Getters & setters =====*/
    public String getName() { return name; }

    public int getBirthYear() { return birthYear; }

    public String getHairColor() { return hairColor; }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public boolean isOlderThan(Person other) {
        return this.birthYear<other.birthYear;
    }

    public static int calculateAge(int birthYear) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if ((birthYear != 0) && (year != 0)) {
            return year-birthYear;
        } else {
            return 0;
        }
    }

    public String description() {
        return "Hello, "+this.getName()+"! Your birth year is "+Integer.toString(this.getBirthYear())+" so you have "+calculateAge(this.getBirthYear())+" years old and "+this.getHairColor()+" hair color!";
    }
}
