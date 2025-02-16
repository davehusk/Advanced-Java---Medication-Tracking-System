package medicationtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main system
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
            system.clearScreen();
            System.out.println("=======================================");
            System.out.println("     * PHARMACY MANAGEMENT SYSTEM *     ");
            System.out.println("=======================================");
            System.out.println("1 -> Add Patient");
            System.out.println("2 -> Add Doctor");
            System.out.println("3 -> Add Medication");
            System.out.println("4 -> Search Medication");
            System.out.println("5 -> Check Expired Medications");
            System.out.println("6 -> Print All Prescriptions for a Doctor");
            System.out.println("7 -> Exit");
            System.out.println("=======================================");
            System.out.print("Select an option: ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Invalid input! Please enter a number.");
                system.waitForEnter(scanner);
                continue;
            }

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
                    System.out.println("\nExiting... Thank you for using the system!");
                    return;
                }
                default -> {
                    System.out.println("Invalid option! Please try again.");
                    system.waitForEnter(scanner);
                }
            }
        }
    }

    // Add a new patient
    private void addPatient(Scanner scanner) {
        System.out.println("\n[+] ADD NEW PATIENT");
        System.out.println("---------------------------");
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        patients.add(new Patient(idCounter++, name, age, phone));
        System.out.println("✅ Patient added successfully!");
        waitForEnter(scanner);
    }

    // Add a new doctor
    private void addDoctor(Scanner scanner) {
        System.out.println("\n[+] ADD NEW DOCTOR");
        System.out.println("---------------------------");
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
        System.out.println("✅ Doctor added successfully!");
        waitForEnter(scanner);
    }

    // Add a new medication
    private void addMedication(Scanner scanner) {
        System.out.println("\n[+] ADD NEW MEDICATION");
        System.out.println("---------------------------");
        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Dosage (mg): ");
        int dosage = scanner.nextInt();
        System.out.print("Enter Quantity in Stock: ");
        int quantity = scanner.nextInt();

        medications.add(new Medication(idCounter++, name, dosage, quantity));
        System.out.println("✅ Medication added successfully!");
        waitForEnter(scanner);
    }

    // Search for a medication (partial match search)
    private void searchMedication(Scanner scanner) {
        System.out.println("\n[*] AVAILABLE MEDICATIONS");
        System.out.println("---------------------------");
        if (medications.isEmpty()) {
            System.out.println("No medications in the system.");
            waitForEnter(scanner);
            return;
        }

        for (Medication med : medications) {
            System.out.println("- " + med.getName());
        }

        System.out.println("\n[*] SEARCH MEDICATION");
        System.out.print("Enter Medication Name (partial allowed): ");
        String searchName = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Medication med : medications) {
            if (med.getName().toLowerCase().contains(searchName)) {
                System.out.println("Found: " + med);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No medications found matching '" + searchName + "'.");
        }
        waitForEnter(scanner);
    }

    // Check for expired medications
    private void checkExpiredMedications() {
        System.out.println("\n[*] CHECK EXPIRED MEDICATIONS");
        System.out.println("---------------------------");

        boolean expiredFound = false;
        for (Medication med : medications) {
            if (med.isExpired()) {
                System.out.println("⚠️ EXPIRED: " + med);
                expiredFound = true;
            }
        }
        if (!expiredFound) {
            System.out.println("✅ No expired medications found.");
        }
        waitForEnter(new Scanner(System.in));
    }

    // Search for a doctor and print prescriptions
    private void printPrescriptionsForDoctor(Scanner scanner) {
        System.out.println("\n[*] AVAILABLE DOCTORS");
        System.out.println("---------------------------");
        if (doctors.isEmpty()) {
            System.out.println("No doctors in the system.");
            waitForEnter(scanner);
            return;
        }

        for (Doctor doc : doctors) {
            System.out.println("- " + doc.getName());
        }

        System.out.println("\n[*] SEARCH PRESCRIPTIONS FOR A DOCTOR");
        System.out.print("Enter Doctor's Name (partial allowed): ");
        String searchName = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Prescription prescription : prescriptions) {
            if (prescription.getDoctor().getName().toLowerCase().contains(searchName)) {
                System.out.println("📄 " + prescription);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No prescriptions found for doctors matching '" + searchName + "'.");
        }
        waitForEnter(scanner);
    }

    // Utility function: Press Enter to continue
    private void waitForEnter(Scanner scanner) {
        System.out.println("\nPress ENTER to continue...");
        scanner.nextLine();
    }

    // Utility function: Clear the screen (only works in terminals)
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
