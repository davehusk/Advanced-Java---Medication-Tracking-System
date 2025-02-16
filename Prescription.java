package medicationtracking;

// Prescriptions link doctors, patients, and medications.
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

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return "Prescription ID: " + id + " | Doctor: " + doctor.getName() + " | Patient: " + patient.getName() + " | Medication: " + medication.getName();
    }
}
