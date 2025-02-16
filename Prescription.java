package medicationtracking;

// This is the prescription class. It tracks prescriptions.
public class Prescription {
    private int id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;

    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
    }
}
