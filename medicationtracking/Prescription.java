package medicationtracking;

// Represents a prescription linking a doctor, patient, and medication
public class Prescription {
    private int id; // Unique identifier for the prescription
    private Doctor doctor; // The doctor who issued the prescription
    private Patient patient; // The patient who received the prescription
    private Medication medication; // The medication prescribed

    // Constructor to initialize a Prescription object
    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
    }

    // Getter for the doctor
    public Doctor getDoctor() {
        return doctor;
    }

    // Override toString to display prescription details
    @Override
    public String toString() {
        return "Prescription ID: " + id + " | Doctor: " + doctor.getName() + " | Patient: " + patient.getName() + " | Medication: " + medication.getName();
    }
}