package week3.Room;

import week3.Person.Person;

import java.util.Scanner;

public class Room {
    /*===== Fields =============*/
    private int capacity;
    private Person[] persons;

    /*===== Constructor =======*/
    public Room(int capacity) {
        this.capacity = capacity;
        this.persons = new Person[capacity];
    }

    /*===== Getter =====*/
    public int getCapacity() {
        return capacity;
    }

    public Person[] getPersons(){
        return persons;
    }

    /*==== Other Methods ====*/
    int countPersons(Person[] persons) {
        int count = 0;
        for (int i = 0; i < persons.length; i++) {
            if(persons[i]!=null) {
                count++;
            }
            else{
                continue;
            }
        }
        return count;
    }

    public void printAll() {
        int capacity = this.getCapacity();
        int count = this.countPersons(persons);
        if (count == 0) {
            System.out.println("Capacity of the Room is " + capacity + " but are no persons entered right now.");
        }
        else {
            System.out.println("Capacity of the Room is: " + capacity + " and are " + count + " persons entered here.Let's meet them!: ");
        }
        for(int i=0;i<persons.length;i++){
            if(persons[i]!=null) {
                System.out.println(persons[i].description());
            }
            else{
                continue;
            }
        }
    }

    boolean isPresent(String personName) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getName().equalsIgnoreCase(personName) || persons[i]!=null) {
                return true;
            }
            else if(persons[i]==null){
                return false;
            }
        }
        return false;
    }

    public void enter(Person person) {
        int personsCount = this.countPersons(persons);
        if (personsCount >= this.getCapacity() && isPresent(person.getName()) == true) {
            System.out.println("This Room has reached the maximum capacity or "+person.getName()+" may already exist in this Room. Please find another Room.");
        } else if (personsCount < this.getCapacity()) {
            persons[personsCount] = person;
        }
    }

    public void printOldest() {
        String[] names;
        int maxAge = persons[0].calculateAge(persons[0].getBirthYear());
        int j=0;
        names = new String[1];
        names[0]=persons[0].getName();
        System.out.println("The oldest persons from this Room are: ");
        for (int i = 1; i < persons.length; i++) {
            if (persons[i].calculateAge(persons[i].getBirthYear()) > maxAge) {
                maxAge = persons[i].calculateAge(persons[i].getBirthYear());
                names[j] = persons[i].getName();
            } else if (persons[i].calculateAge(persons[i].getBirthYear()) == maxAge) {
                names = new String[1];
                j++;
                names[j] = persons[i].getName();
            }
        }
        for(int k=0; k<names.length;k++){
            System.out.println("Name: "+names[k]+"; Age: "+maxAge+".");
        }
    }

    public void printNames(String hairColor){
        System.out.println("Persons names in the Room with color of hair "+hairColor+" are: ");
        for(int i=0;i<persons.length;i++){
            if(persons[i].getHairColor().equalsIgnoreCase(hairColor)){
                System.out.println(persons[i].getName());
            }
        }
    }
    /* Point BONUS upgraded */
    private char checkInput(String input){
        Scanner scanned = new Scanner(System.in);
        while(input!="0" || input!="1") {
            System.out.println("Please insert just 0 for CANCEL or 1 for CONTINUE to exit of Person from this Room!");
            String outChar = scanned.next();
            if(outChar.equals("1") || outChar.equals("0"))
            return outChar.toCharArray()[0];
        }
        return input.toCharArray()[0];
    }

    private boolean verifyExit(char verify){
        if (verify=='0'){
            return false;
        }
        return true;
    }

    private void updatePersons(int index){
        for (int i=index;i<persons.length-1;i++){
            persons[i]=persons[i+1];
        }
    }

    public void exit(String personName){
        System.out.println("Are you sure you want to exit "+personName+" from this Room?");
        Scanner scanned = new Scanner(System.in);
        String input = scanned.next();
        if(verifyExit(checkInput(input))==true){
            System.out.println("Person with name "+personName+" was successfully deleted from this Room!");
            for (int i=0;i<persons.length;i++){
                if( persons[i].getName().equalsIgnoreCase(personName)){
                    updatePersons(i);
                }
            }
        }
    }
}