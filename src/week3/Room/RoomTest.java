package week3.Room;

import week3.Person.Person;

public class RoomTest {
    public static void main(String[] args) {
        Room room = new Room(3);
        room.printAll(); //should show: capacity=3, and no persons in Room now
        //these should work (add 3 new persons)
        room.enter(new Person ("Ion", 1997, "blonde"));
        room.enter(new Person("Maria", 2001, "blonde"));
        room.enter(new Person("Ana", 1995, "black"));
        //this should print an error message (max capacity reached) and ignore this Person
        room.enter(new Person("Marius", 2003));
        room.printAll(); //should show 3 persons in Room now
        System.out.println("Ion is in Room: " + room.isPresent("Ion")); //should print: true
        System.out.println("Marius is in Room: " + room.isPresent("Marius")); //print: false
        room.printOldest(); //should print: Oldest Person: Ana, 23 years old
        room.printNames("blonde"); //print: Found 2 persons with "blonde" hair: Ion, Maria
        room.exit("Ion"); //Ion found and kicked out..
        System.out.println("Persons in Room now: " + room.countPersons(room.getPersons())); //should print 3
//        Person p4 = new Person("John", 1991, "red");
//        Room.enter(p4); //and another new Person is added instead
//        Room.printOldest(); //should print "John" now for oldest..
//        Room.printNames("red"); //should print that no persons with red hair exis in Room
//        //yes, we can do this! modify a Person in Room from outside,
//        //using a reference which still points to him
//        p4.setHairColor("red");
//        Room.printNames("red"); //now should show that there is 1 Person with red hair (John)
//        //build another Room
//        Room room2 = new Room(10);
//        //all this should work (throw no exceptions) and give some meaningfull answers..
//        room2.printAll();
//        room2.printOldest();
//        room2.printNames("red");
//        room2.exit("Yeti");
//        room2.isPresent("DarthVader");

    }
}