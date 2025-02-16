package medicationtracking;

// Patients are also people, so they extend the Person class.
public class Patient extends Person {
    // Constructor to initialize a Patient object
    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber); // Call the superclass (Person) constructor
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Override toString to display patient details
    @Override
    public String toString() {
        return "Patient ID: " + id + " | Name: " + getName() + " | Age: " + age + " | Phone: " + phoneNumber;
    }
}