package medicationtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// The main system. Runs everything.
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
            System.out.println("\n===== Pharmacy System =====");
            System.out.println("1: Add Patient");
            System.out.println("2: Add Doctor");
            System.out.println("3: Add Medication");
            System.out.println("4: Search Medication");
            System.out.println("5: Check Expired Medications");
            System.out.println("6: Print All Prescriptions for a Doctor");
            System.out.println("7: Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> system.addPatient(scanner);
                case 2 -> system.addDoctor(scanner);
                case 3 -> system.addMedication(scanner);
                case 4 -> system.searchMedication(scanner);
                case 5 -> system.checkExpiredMedications();
                case 6 -> system.printPrescriptionsForDoctor(scanner);
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        patients.add(new Patient(idCounter++, name, age, phone));
        System.out.println("Patient added!");
    }

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
        System.out.println("Doctor added!");
    }

    private void addMedication(Scanner scanner) {
        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Dosage: ");
        int dosage = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        medications.add(new Medication(idCounter++, name, dosage, quantity));
        System.out.println("Medication added!");
    }

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

    private void checkExpiredMedications() {
        System.out.println("Expired medications:");
        for (Medication med : medications) {
            if (med.isExpired()) {
                System.out.println(med.getName() + " is expired!");
            }
        }
    }

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
