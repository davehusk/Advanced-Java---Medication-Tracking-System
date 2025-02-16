public class Prescription {
    private Patient patient;
    private Doctor doctor;
    private Medication medication;

    public Prescription(Patient patient, Doctor doctor, Medication medication) {
        this.patient = patient;
        this.doctor = doctor;
        this.medication = medication;
    }

    @Override
    public String toString() {
        return "Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Medication: " + medication.getName();
    }
}
