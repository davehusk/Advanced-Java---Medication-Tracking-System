package medicationtracking;

// This will test some basic functionality.
public class MedicationTrackingSystemTest {
    public static void main(String[] args) {
        Medication med1 = new Medication(1, "Painkiller", 500, 10);
        System.out.println(med1);

        Patient patient = new Patient(1, "David Husk", 30, "123-456-7890");
        Doctor doctor = new Doctor(1, "Dr. Smith", 45, "987-654-3210", "Cardiology");

        Prescription prescription = new Prescription(1, doctor, patient, med1);
        System.out.println(prescription);
    }
}
