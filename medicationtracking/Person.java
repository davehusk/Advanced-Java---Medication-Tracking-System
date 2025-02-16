package medicationtracking;

// Base class for Person, which is extended by Doctor and Patient
public class Person {
    protected int id; // Unique identifier for the person
    protected String name; // Name of the person
    protected int age; // Age of the person
    protected String phoneNumber; // Phone number of the person

    // Constructor to initialize a Person object
    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Override toString to display person details
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Phone: " + phoneNumber;
    }
}