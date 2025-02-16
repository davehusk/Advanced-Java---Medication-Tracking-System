package medicationtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This is the main system. Now it can add patients and doctors.
public class MedicationTrackingSystem {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();

    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Pharmacy System =====");
            System.out.println("1: Add Patient");
            System.out.println("2: Add Doctor");
            System.out.println("3: Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                system.addPatient(scanner);
            } else if (option == 2) {
                system.addDoctor(scanner);
            } else {
                System.out.println("Exiting...");
                break;
            }
        }
    }

    private void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        patients.add(new Patient(patients.size() + 1, name, age, phone));
        System.out.println("Patient added!");
    }

    private void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        doctors.add(new Doctor(doctors.size() + 1, name, age, phone));
        System.out.println("Doctor added!");
    }
}
