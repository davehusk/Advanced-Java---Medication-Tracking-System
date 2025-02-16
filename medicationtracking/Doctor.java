package medicationtracking;

// Doctors are also people, so they extend the Person class.
public class Doctor extends Person {
    private String specialization; // The doctor's specialization (e.g., Cardiologist, Pediatrician)

    // Constructor to initialize a Doctor object
    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber); // Call the superclass (Person) constructor
        this.specialization = specialization; // Set the specialization
    }

    // Getter for specialization
    public String getSpecialization() {
        return specialization;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Override toString to display doctor details
    @Override
    public String toString() {
        return "Doctor ID: " + id + " | Name: " + getName() + " | Specialization: " + specialization;
    }
}