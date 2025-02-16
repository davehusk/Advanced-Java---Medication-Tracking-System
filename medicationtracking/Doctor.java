package medicationtracking;

// Doctors are also people.
public class Doctor extends Person {
    private String specialization;

    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
    }
}
