package medicationtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;

/**
 * Person class (Super class for Patient & Doctor)
 */
class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String phoneNumber;

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
}

/**
 * Patient class (inherits from Person)
 */
class Patient extends Person {
    private List<Prescription> prescriptions;

    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.prescriptions = new ArrayList<>();
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }
}

/**
 * Doctor class (inherits from Person)
 */
class Doctor extends Person {
    private String specialization;

    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
    }
}

/**
 * Medication class
 */
class Medication {
    private int id;
    private String name;
    private int dosage;
    private int quantityInStock;
    private LocalDate expiryDate;

    public Medication(int id, String name, int dosage, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiryDate();
    }

    private LocalDate generateRandomExpiryDate() {
        Random random = new Random();
        int yearsOffset = random.nextInt(4) - 2; // Random year offset (-2 to +2 years)
        return LocalDate.now().plusYears(yearsOffset);
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return name + " (Expiry: " + expiryDate + ")";
    }
}

/**
 * Prescription class
 */
class Prescription {
    private int id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate prescriptionExpiry;

    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiry = LocalDate.now().plusYears(1);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return "Prescription ID: " + id + " | Doctor: " + doctor.getName() + " | Patient: " + patient.getName() + " | Medication: " + medication.getName();
    }
}

/**
 * Medication Tracking System class (Main logic)
 */
public class MedicationTrackingSystem {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Medication> medications = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();
    private static int idCounter = 1;

    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Pharmacy Management System =====");
            System.out.println("1: Add Patient");
            System.out.println("2: Add Doctor");
            System.out.println("3: Add Medication");
            System.out.println("4: Search Medication");
            System.out.println("5: Check Expired Medications");
            System.out.println("6: Print All Prescriptions for a Doctor");
            System.out.println("7: Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    system.addPatient(scanner);
                    break;
                case 2:
                    system.addDoctor(scanner);
                    break;
                case 3:
                    system.addMedication(scanner);
                    break;
                case 4:
                    system.searchMedication(scanner);
                    break;
                case 5:
                    system.checkExpiredMedications();
                    break;
                case 6:
                    system.printPrescriptionsForDoctor(scanner);
                    break;
                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    /**
     * Add a new patient
     */
    private void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        patients.add(new Patient(idCounter++, name, age, phone));
        System.out.println("Patient added successfully!");
    }

    /**
     * Add a new doctor
     */
    private void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        doctors.add(new Doctor(idCounter++, name, age, phone, specialization));
        System.out.println("Doctor added successfully!");
    }

    /**
     * Add a new medication
     */
    private void addMedication(Scanner scanner) {
        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Dosage: ");
        int dosage = scanner.nextInt();
        System.out.print("Enter Quantity in Stock: ");
        int quantity = scanner.nextInt();

        medications.add(new Medication(idCounter++, name, dosage, quantity));
        System.out.println("Medication added successfully!");
    }

    /**
     * Search for a medication
     */
    private void searchMedication(Scanner scanner) {
        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();
        for (Medication med : medications) {
            if (med.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + med);
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    /**
     * Check for expired medications
     */
    private void checkExpiredMedications() {
        System.out.println("Checking for expired medications...");
        for (Medication med : medications) {
            if (med.isExpired()) {
                System.out.println("Expired: " + med);
            }
        }
    }

    /**
     * Print all prescriptions for a doctor
     */
    private void printPrescriptionsForDoctor(Scanner scanner) {
        System.out.print("Enter Doctor's Name: ");
        String name = scanner.nextLine();
        for (Prescription prescription : prescriptions) {
            if (prescription.getDoctor().getName().equalsIgnoreCase(name)) {
                System.out.println(prescription);
            }
        }
    }
}
